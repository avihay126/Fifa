import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {


    private int goals;
    private int fault;
    private int level;



    public ScoreBoard(int x, int y,int width,int height) {
        this.setLayout(null);
        this.setBounds(500, 500, 100, 100);
        this.setBackground(Color.red);
        JLabel goals = new JLabel("Goals:");
        goals.setBounds(0,0,100,100);
        this.add(goals);
        JLabel fault = new JLabel("Fault:");
        fault.setBounds(x, y, 45, 26);
        this.add(fault);
        JLabel level = new JLabel("Level:");
        level.setBounds(x, y, 45, 26);
        this.add(level);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
    }



    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
