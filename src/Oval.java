import java.awt.*;

public class Oval {

    private int x;
    private int y;
    private int width;
    private int height;
    private int startAngle;
    private int endAngle;
    private Color color;
    boolean fillOrDraw;

    public Oval(int x, int y, int width, int height, int startAngle, int endAngle, Color color, boolean fillOrDraw) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.color = color;
        this.fillOrDraw = fillOrDraw;
    }

    public void paint(Graphics graphics){
        graphics.setColor(this.color);
        if (this.fillOrDraw) {
            graphics.fillArc(this.x, this.y, this.width, this.height,this.startAngle,this.endAngle);
        }else {
            graphics.drawArc(this.x, this.y, this.width, this.height,this.startAngle,this.endAngle);


        }
    }
    public void setDribble(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void goUp(){
        this.y--;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
