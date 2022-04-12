import javax.swing.*;
import java.awt.*;


public class Stadium extends JPanel {

    public static final int BOUND_X = 20, BOUND_Y = 80, BOUND_WIDTH = 850, BOUND_HEIGHT = 570,
            KEEPER_WIDTH = 200, KEEPER_HEIGHT = 80, KEEPER_MARGIN = 90, OVAL_16_HEIGHT = 100, OVAL_16_MARGIN = 20, HALF_OVAL_HEIGHT = 200,
            CORNER_WIDTH = 10, GOAL_MARGIN = 25,WIDTH_FLAG = 20, HEIGHT_FLAG = 40, BOUND_Y_FLAG = BOUND_Y-(WIDTH_FLAG)*2,START_GOAL_SPEED=20,
            CORNER_START_ANGLE=90,CORNER_END_ANGLE=270, OVAL_START =0, OVAL_END =180,PENALTY_SIZE=4;
    private Rectangle bounds;
    private Rectangle goalKeeper;
    private Rectangle plaza16;
    private Oval oval16;
    private Oval halfOval;
    private Oval elevenPoint;
    private Oval rightCorner;
    private Oval leftCorner;
    private Rectangle goal;
    private ImageIcon leftFlag;
    private ImageIcon rightFlag;
    private ImageIcon CrowdAshkelon;
    private int speedGame;

//    private JLabel nameUser;


    public Stadium() {

        this.setLayout(null);
        this.setBackground(Color.green);
        this.bounds = new Rectangle(BOUND_X, BOUND_Y, BOUND_WIDTH, BOUND_HEIGHT, Color.white, false);
        this.goalKeeper = new Rectangle(BOUND_X + BOUND_WIDTH / 2 - KEEPER_WIDTH / 2, BOUND_Y, KEEPER_WIDTH, KEEPER_HEIGHT, Color.white, false);
        this.plaza16 = new Rectangle(this.goalKeeper.getX() - KEEPER_MARGIN, this.bounds.getY(), this.goalKeeper.getWidth() + (KEEPER_MARGIN * 2), KEEPER_HEIGHT * 2, Color.white, false);
        this.oval16 = new Oval(this.goalKeeper.getX() + OVAL_16_MARGIN, BOUND_Y + this.plaza16.getHeight() - (OVAL_16_HEIGHT / 2), this.goalKeeper.getWidth() - (OVAL_16_MARGIN * 2), OVAL_16_HEIGHT, OVAL_START, -OVAL_END, Color.white, false);
        this.halfOval = new Oval(this.plaza16.getX(), BOUND_Y + BOUND_HEIGHT - (HALF_OVAL_HEIGHT / 2), this.plaza16.getWidth(), HALF_OVAL_HEIGHT, OVAL_START, OVAL_END, Color.white, false);
        this.elevenPoint = new Oval(this.goalKeeper.getX() + this.goalKeeper.getWidth() / 2, (this.goalKeeper.getY() + this.goalKeeper.getHeight() + this.plaza16.getY() + this.plaza16.getHeight()) / 2, PENALTY_SIZE, PENALTY_SIZE, OVAL_START, OVAL_END*2, Color.white, true);
        this.leftCorner = new Oval(bounds.getX(), BOUND_Y, CORNER_WIDTH, CORNER_WIDTH, CORNER_START_ANGLE, -CORNER_END_ANGLE, Color.white, false);
        this.rightCorner = new Oval(BOUND_X + BOUND_WIDTH - CORNER_WIDTH, BOUND_Y, CORNER_WIDTH, CORNER_WIDTH, CORNER_START_ANGLE, CORNER_END_ANGLE, Color.white, false);
        this.goal = new Rectangle(this.goalKeeper.getX() + GOAL_MARGIN, BOUND_Y - GOAL_MARGIN, this.goalKeeper.getWidth() - (GOAL_MARGIN * 2), GOAL_MARGIN, Color.white, false);
        this.leftFlag = new ImageIcon("left flag.png");
        this.rightFlag = new ImageIcon("right flag.png");
        this.CrowdAshkelon = new ImageIcon("crowd Ashkelon.png");
        this.speedGame=START_GOAL_SPEED;

        this.setVisible(true);
        this.setDoubleBuffered(true);


    }


    public int setGoalY() {
        return this.goal.getY()  ;
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
    public int getGoalX(){
        return this.goal.getX();
    }

    public int getGoalWidth(){
        return this.goal.getWidth();
    }

    public Rectangle getGoal() {
        return goal;
    }
    public void goalMoveRight(){
        this.goal.moveRight();
    }
    public void goalMoveLeft(){
        this.goal.moveLeft();
    }

    public void setGoal(Rectangle goal) {
        this.goal = goal;
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

        graphics.drawImage(rightFlag.getImage(), BOUND_X, BOUND_Y_FLAG, WIDTH_FLAG, HEIGHT_FLAG, null);
        graphics.drawImage(leftFlag.getImage(), BOUND_WIDTH , BOUND_Y_FLAG, WIDTH_FLAG, HEIGHT_FLAG, null);
        graphics.drawImage(CrowdAshkelon.getImage(), 0,0,900,42,null);
    }
}