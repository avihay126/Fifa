import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;


public class Player implements KeyListener {

public static final int HEAD_WIDTH=10,HEAD_HEIGHT=10,LEG_WIDTH=6,SHOULDERS_HEIGHT=4,HAND_WIDTH=5,NECK_MARGIN=2,
        BODY_MARGIN=3,SHOULDERS_MARGIN=5,NONE=0,RIGHT=1,LEFT=2;

    private Rectangle head;
    private Rectangle neck;
    private Rectangle body;
    private Rectangle rightLeg;
    private Rectangle leftLeg;
    private Rectangle rightHand;
    private Rectangle leftHand;
    private Rectangle shoulders;
    private int direction;


    public Player(int x,int y){
        this.direction=NONE;
        this.head=new Rectangle(x,y,HEAD_WIDTH,HEAD_HEIGHT,Color.black,true);
        this.neck=new Rectangle(x+NECK_MARGIN,this.head.getY()+this.head.getHeight(),HEAD_WIDTH-(NECK_MARGIN*2),HEAD_HEIGHT/2,Color.lightGray,true);
        this.body=new Rectangle(x-BODY_MARGIN,this.neck.getY()+this.neck.getHeight(),HEAD_WIDTH+(BODY_MARGIN*2),HEAD_HEIGHT*2,Color.blue,true);
        this.leftLeg=new Rectangle(this.body.getX(),this.body.getY()+this.body.getHeight(),LEG_WIDTH,this.body.getHeight()*4/3,Color.lightGray,true);
        this.rightLeg=new Rectangle(this.body.getX()+this.body.getWidth()-LEG_WIDTH,this.body.getY()+this.body.getHeight(),LEG_WIDTH,this.body.getHeight()*4/3,Color.lightGray,true);
        this.shoulders=new Rectangle(this.body.getX()-SHOULDERS_MARGIN,this.body.getY(),this.body.getWidth()+(SHOULDERS_MARGIN*2),SHOULDERS_HEIGHT,Color.blue,true);
        this.rightHand=new Rectangle(this.shoulders.getX(),this.shoulders.getY(),HAND_WIDTH,this.body.getHeight(),Color.lightGray,true);
        this.leftHand=new Rectangle(this.shoulders.getX()+this.shoulders.getWidth()-HAND_WIDTH,this.shoulders.getY(),HAND_WIDTH,this.body.getHeight(),Color.lightGray,true);


    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getLocation(){
        return this.body.getX();
    }
    public int legsX(){
        return this.leftLeg.getX()+this.leftLeg.getWidth();
    }
    public int legsY(){
        return this.rightLeg.getY()+this.rightLeg.getHeight();
    }

    public void moveRight(){
        this.head.moveRight();
        this.neck.moveRight();
        this.body.moveRight();
        this.rightLeg.moveRight();
        this.leftLeg.moveRight();
        this.rightHand.moveRight();
        this.leftHand.moveRight();
        this.shoulders.moveRight();

    }
    public void moveLeft(){
        this.head.moveLeft();
        this.neck.moveLeft();
        this.body.moveLeft();
        this.rightLeg.moveLeft();
        this.leftLeg.moveLeft();
        this.rightHand.moveLeft();
        this.leftHand.moveLeft();
        this.shoulders.moveLeft();
    }
    public void paint(Graphics graphics){
        this.head.paint(graphics);
        this.neck.paint(graphics);
        this.body.paint(graphics);
        this.leftLeg.paint(graphics);
        this.rightLeg.paint(graphics);
        this.shoulders.paint(graphics);
        this.leftHand.paint(graphics);
        this.rightHand.paint(graphics);
    }

}
