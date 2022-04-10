import javax.swing.*;
import java.awt.*;

public class Menu extends  JPanel{

    private ImageIcon backGround;

    public Menu(){
        JFrame window=new JFrame("Enter your username:");
        JTextField userNameTextFiled=new JTextField();
        JLabel userNameLabel=new JLabel("User Name");
        this.backGround= new ImageIcon("pic_game.jpeg");
        JButton start = new JButton("Start");
        this.add(start);
        window.add(userNameLabel);
        window.add(userNameTextFiled);
        start.setBounds(400,0,100,50);
        start.addActionListener((event)->{

            this.setVisible(false);
        });


    }
    public void paint(Graphics graphics) {
        graphics.drawImage(backGround.getImage(),0,0,900,700,null);
    }
}
