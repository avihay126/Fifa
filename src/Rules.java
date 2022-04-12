import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel {
    private JLabel rules;
    private JButton exit;

    public Rules(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.lightGray);
        Font font = new Font("Ariel", Font.BOLD, 30);
        this.rules = new JLabel("<html>Welcome to " +
                "The fast gate!<br/>" +
                "Game rules:<br/>" +
                "1. Active buttons in the game are:<br/>" +
                "Right arrow to move to the right side, left arrow to move to the left side and top arrow to kick to the goal.<br/>" +
                "2. Pay attention! You have 3 disqualifications, each miss is considered a disqualification.<br/>" +
                "3. After each goal the speed of the goal increases, get ready!<br/>" +
                "good luck!<html>");
        this.rules.setBounds(x,y,width,height);
        this.rules.setFont(font);
        this.rules.setVisible(true);
        this.add(this.rules);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }


}
