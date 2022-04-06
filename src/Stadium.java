import javax.swing.*;
import java.awt.*;


public class Stadium extends JPanel {

    public static final int BOUND_X = 10, BOUND_Y = 20, BOUND_WIDTH = 870, BOUND_HEIGHT = 640,
            KEEPER_WIDTH = 200, KEEPER_HEIGHT = 80, KEEPER_MARGIN = 90, OVAL_16_HEIGHT = 100, OVAL_16_MARGIN = 20, HALF_OVAL_HEIGHT = 200,
            CORNER_WIDTH = 10, GOAL_MARGIN = 15;
    private Rectangle bounds;
    private Rectangle goalKeeper;
    private Rectangle plaza16;
    private Oval oval16;
    private Oval halfOval;
    private Oval elevenPoint;
    private Oval rightCorner;
    private Oval leftCorner;
    private Rectangle goal;


    public Stadium() {
        this.setBackground(Color.green);
        this.bounds = new Rectangle(BOUND_X, BOUND_Y, BOUND_WIDTH, BOUND_HEIGHT, Color.white, false);
        this.goalKeeper = new Rectangle(BOUND_X + BOUND_WIDTH / 2 - KEEPER_WIDTH / 2, BOUND_Y, KEEPER_WIDTH, KEEPER_HEIGHT, Color.white, false);
        this.plaza16 = new Rectangle(this.goalKeeper.getX() - KEEPER_MARGIN, this.bounds.getY(), this.goalKeeper.getWidth() + (KEEPER_MARGIN * 2), KEEPER_HEIGHT * 2, Color.white, false);
        this.oval16 = new Oval(this.goalKeeper.getX() + OVAL_16_MARGIN, BOUND_Y + this.plaza16.getHeight() - (OVAL_16_HEIGHT / 2), this.goalKeeper.getWidth() - (OVAL_16_MARGIN * 2), OVAL_16_HEIGHT, 0, -180, Color.white, false);
        this.halfOval = new Oval(this.plaza16.getX(), BOUND_Y + BOUND_HEIGHT - (HALF_OVAL_HEIGHT / 2), this.plaza16.getWidth(), HALF_OVAL_HEIGHT, 0, 180, Color.white, false);
        this.elevenPoint = new Oval(this.goalKeeper.getX() + this.goalKeeper.getWidth() / 2, (this.goalKeeper.getY() + this.goalKeeper.getHeight() + this.plaza16.getY() + this.plaza16.getHeight()) / 2, 5, 5, 0, 360, Color.white, true);
        this.leftCorner = new Oval(bounds.getX(), BOUND_Y, CORNER_WIDTH, CORNER_WIDTH, 90, -270, Color.white, false);
        this.rightCorner = new Oval(BOUND_X + BOUND_WIDTH - CORNER_WIDTH, BOUND_Y, CORNER_WIDTH, CORNER_WIDTH, 90, 270, Color.white, false);
        this.goal = new Rectangle(this.goalKeeper.getX() + GOAL_MARGIN, BOUND_Y - GOAL_MARGIN, this.goalKeeper.getWidth() - (GOAL_MARGIN * 2), GOAL_MARGIN, Color.white, false);


    }

    public void goalMovement(int speed) {
        Thread t2 = new Thread(() -> {
            boolean goalMovement = true;
            while (true) {
                if (goalMovement) {
                    this.goal.moveRight();
                } else {
                    this.goal.moveLeft();
                }
                if (this.goal.getX() == BOUND_X + BOUND_WIDTH - this.goal.getWidth()) {
                    goalMovement = false;
                } else if (this.goal.getX() == BOUND_X) {
                    goalMovement = true;
                }
                try {
                    repaint();
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }


    public int getGoalX() {
        return this.goal.getX();
    }

    public int setGoalY() {
        return this.goal.getY()  ;
    }
    public int getGoalWidth(){
        return this.goal.getWidth();
    }

    public int getBoundY() {
        return this.bounds.getY();
    }

    public int getBoundX() {
        return this.bounds.getX();
    }

    public int getBoundWidth() {
        return this.bounds.getWidth();
    }

    public void paint(Graphics graphics) {
        this.bounds.paint(graphics);
        this.goalKeeper.paint(graphics);
        this.plaza16.paint(graphics);
        this.oval16.paint(graphics);
        this.halfOval.paint(graphics);
        this.elevenPoint.paint(graphics);
        this.rightCorner.paint(graphics);
        this.leftCorner.paint(graphics);
        this.goal.paint(graphics);

    }
}
