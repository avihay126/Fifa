import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Rectangle extends Shape {


    private Color color;
    boolean fillOrDraw;

    public Rectangle(int x, int y, int width, int height, Color color, boolean fillOrDraw) {
        super(x, y, width, height);
        this.color = color;
        this.fillOrDraw = fillOrDraw;
    }



    public void paint(Graphics graphics){
        graphics.setColor(this.color);
        if (this.fillOrDraw) {
            graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }else {
            graphics.drawRect(this.getX(), this.getY(), this.getWidth(),  this.getHeight());
        }

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
