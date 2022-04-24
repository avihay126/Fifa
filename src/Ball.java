import java.awt.*;

public class Ball {
    public static final int NONE = 0, UP = 1,START_ANGLE=0, END_ANGLE = 360, WIDTH_OVAL = 10, HEIGHT_OVAL = 10;

    private Oval ball;
    private int direction;

    public Ball(int x, int y) {
        this.ball = new Oval(x, y, WIDTH_OVAL, HEIGHT_OVAL, START_ANGLE, END_ANGLE, Color.black, true);
        this.direction = NONE;

    }

    public void dribble(int x, int y) {
        this.ball.setDribble(x, y);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public int getXLocation() {
        return this.ball.getX();
    }

    public int getYLocation() {
        return this.ball.getY();
    }

    public void goUp() {
        this.ball.goUp();
    }

    public void paint(Graphics graphics) {
        this.ball.paint(graphics);
    }

}
