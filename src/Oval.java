import java.awt.*;

public class Oval extends Shape {


    private int startAngle;
    private int endAngle;
    private Color color;
    boolean fillOrDraw;

    public Oval(int x, int y, int width, int height, int startAngle, int endAngle, Color color, boolean fillOrDraw) {
        super(x, y, width, height);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.color = color;
        this.fillOrDraw = fillOrDraw;
    }

    public void paint(Graphics graphics){
        graphics.setColor(this.color);
        if (this.fillOrDraw) {
            graphics.fillArc(this.getX(), this.getY(), this.getWidth(), this.getHeight(),this.startAngle,this.endAngle);
        }else {
            graphics.drawArc(this.getX(), this.getY(), this.getWidth(), this.getHeight(),this.startAngle,this.endAngle);


        }
    }
    public void setDribble(int x,int y){
        this.setX(x);
        this.setY(y);
    }
    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFillOrDraw() {
        return fillOrDraw;
    }

    public void setFillOrDraw(boolean fillOrDraw) {
        this.fillOrDraw = fillOrDraw;
    }
}
