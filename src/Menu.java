import javax.swing.*;
import java.awt.*;

public class Menu extends  JPanel{

    private ImageIcon backGround;

    public Menu(){
        JFrame userName=new JFrame("Enter your username:");
        JTextField userNameTextFiled=new JTextField();
        JLabel userNameLabel=new JLabel("User Name");
        GridLayout gl=new GridLayout();
        gl.setColumns(3);
        gl.setRows(2);
        this.backGround= new ImageIcon("pic_game.jpeg");
        JButton start = new JButton("Start");
        this.add(start);
        userName.add(userNameLabel);
        userName.add(userNameTextFiled);
        userName.setLayout(gl);
        start.setBounds(400,0,100,50);
        start.addActionListener((event)->{

            this.setVisible(false);
        });


    }
    public void paint(Graphics graphics) {
        graphics.drawImage(backGround.getImage(),0,0,900,700,null);
    }
}
