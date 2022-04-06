import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScene extends JPanel {


    private Player player;
    private Stadium stadium;
    private Ball ball;


    public GameScene(int x, int y, int width, int height) {
        Random random = new Random();
        this.setBackground(Color.green);
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        int o = random.nextInt(600);
        int d = 340;

        this.stadium = new Stadium();
        this.stadium.goalMovement();
        this.player = new Player(o, d);
        this.ball = new Ball(this.player.legsX(), this.player.legsY());
        this.gameLoop();


    }

    private void gameLoop() {
        Thread t1 = new Thread(() -> {
            KeyControl keyControl = new KeyControl(this.player,this.ball);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(keyControl);
            boolean shoot=false;
            while (true) {
                switch (this.player.getDirection()){
                    case Player.RIGHT:
                        this.player.moveRight();
                        if (!shoot){
                            this.ball.dribble(this.player.legsX(), this.player.legsY());
                        }
                        break;
                    case Player.LEFT:
                        this.player.moveLeft();
                        if (!shoot){
                            this.ball.dribble(this.player.legsX(), this.player.legsY());
                        }
                        break;
                }
                if (this.ball.getDirection()==Ball.UP){
                    shoot=true;
                    this.ball.goUp();
                }
                if (this.ball.getYLocation()==this.stadium.getBoundY()+5){
                    this.ball.dribble(this.player.legsX(), this.player.legsY());
                    shoot=false;
                    this.ball.setDirection(Ball.NONE);
                }
                repaint();
                try {
                    Thread.sleep(7);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            }
        });
        t1.start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.stadium.paint(g);
        this.ball.paint(g);
        this.player.paint(g);


    }


}