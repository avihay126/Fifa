import javax.swing.*;
import java.awt.*;

public class Menu extends  JPanel{

    private ImageIcon backGround;

    public Menu(int x,int y,int width,int height){
        this.setDoubleBuffered(true);
        this.setVisible(true);
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        JButton newGame = new JButton("New Game");
        newGame.setBounds(this.getWidth()/2,this.getHeight()/2,100,50);
        this.add(newGame);
        this.backGround=new ImageIcon("pic_game.jpeg");



        newGame.addActionListener((event)->{
            newGame.setVisible(false);

            GameScene gameScene = new GameScene(0, 0, width,height);
            this.add(gameScene);


        });






    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(this.backGround.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);

    }







//    private ImageIcon backGround;
//
//    public Menu(int width,int height){
//        this.setDoubleBuffered(true);
//        this.setBounds(0,0,width,height);
//        this.setLayout(null);
//        this.setVisible(true);
//
//
//          this.backGround= new ImageIcon("pic_game.jpeg");
//
//
////
////
////
////        JButton start = new JButton("Start");
////        this.add(start);
////        start.setBounds(400,0,100,50);
////        JFrame userName=new JFrame("Enter your username:");
////        JTextField userNameTextFiled=new JTextField();
////        JLabel userNameLabel=new JLabel("User Name");
////        GridLayout gl=new GridLayout();
////        gl.setColumns(3);
////        gl.setRows(2);
////        userName.add(userNameLabel);
////        userName.add(userNameTextFiled);
////        userName.setLayout(gl);
////        start.addActionListener((event)->{
////            start.setVisible(false);
////
////            GameScene gameScene = new GameScene(0, 0, width,height);
////            this.add(gameScene);
////
////
////        });
//
//
//
//    }
//
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        g.drawImage(this.backGround.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);
//    }
//

}
