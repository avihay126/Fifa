import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {

    private int goals;
    private int fault;
    private int level;
    private Rectangle boardParameters;


    public ScoreBoard(int x,int y,int width,int height){
    this.boardParameters=new Rectangle(x,y,width,height, Color.blue,true);
        JLabel goals=new JLabel("Goals:");
        goals.setBounds(x,y,width,height);
        this.add(goals);
        JLabel fault=new JLabel("Fault:");
        fault.setBounds(x,y,width,height);
        this.add(fault);
        JLabel level=new JLabel("Level:");
        level.setBounds(x,y,width,height);
        this.add(level);
    }
}
