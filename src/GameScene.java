import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel {


    private Player player;
    private Stadium stadium;
    private Ball ball;
    private static int speedGame;


    public GameScene(int x, int y, int width, int height) {
        this.setBackground(Color.green);
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.speedGame=15;
        this.stadium = new Stadium();
        this.stadium.goalMovement(speedGame);
        this.player = new Player(this.getX()+this.getWidth()/2, this.getY()+this.getHeight()/2);
        this.ball = new Ball(this.player.legsX(), this.player.legsY());
        this.gameLoop();

    }

    private void gameLoop() {
        Thread t1 = new Thread(() -> {
            keyControl();
            boolean shoot = false;
            while (true) {

                switch (this.player.getDirection()) {
                    case Player.RIGHT:
                        this.player.moveRight();
                        break;
                    case Player.LEFT:
                        this.player.moveLeft();
                        break;
                }
                if (this.player.getLocation()==this.stadium.getBoundX()+this.stadium.getBoundWidth()-this.player.getBodyWidth()){
                    this.player.moveLeft();
                }else if(this.player.getLocation()==this.stadium.getBoundX()){
                    this.player.moveRight();
                }
                if (!shoot) {
                    this.ball.dribble(this.player.legsX(), this.player.legsY());
                }
                if (this.ball.getDirection() == Ball.UP) {
                    shoot = true;
                    this.ball.goUp();
                }
                if (this.ball.getYLocation() == this.stadium.getBoundY() - 5) {
                    shoot = false;
                    this.ball.setDirection(Ball.NONE);
                }
                if (this.ball.getYLocation()==this.stadium.getBoundY()&&(this.ball.getXLocation()>this.stadium.getGoalX()&&this.ball.getXLocation()<this.stadium.getGoalX()+this.stadium.getGoalWidth())){
                    this.speedGame-=2;
                    System.out.println("goal");

                }
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }

    public void keyControl() {
        KeyControl keyControl = new KeyControl(this.player, this.ball);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(keyControl);
    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics=(Graphics2D) g;
        graphics.setStroke(new BasicStroke(3));
        super.paintComponent(g);
        this.stadium.paint(g);
        this.ball.paint(g);
        this.player.paint(g);


    }


}