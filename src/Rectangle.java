import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    boolean fillOrDraw;

    public Rectangle(int x, int y, int width, int height, Color color,boolean fillOrDraw) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.fillOrDraw=fillOrDraw;
    }

    public void moveRight(){
       this.x++;

    }
    public void moveLeft(){
        this.x--;
    }

    public void paint(Graphics graphics){
        graphics.setColor(this.color);
        if (this.fillOrDraw) {
            graphics.fillRect(this.x, this.y, this.width, this.height);
        }else {
            graphics.drawRect(this.x, this.y, this.width, this.height);
        }
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
