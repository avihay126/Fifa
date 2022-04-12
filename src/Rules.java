import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel {
    private JLabel rules;
//    public static final int RULES_OF_GAME_WIDTH = 150, RULES_OF_GAME_HEIGHT = 50;

    public Rules(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(Color.blue);
        Font font = new Font("Ariel", Font.BOLD, 30);
        JLabel textRules = new JLabel("<html>Welcome to <br/>" +
                "The fast gate!<br/>" +
                "Game rules:<br/>" +
                "1. Active buttons in the game are:<br/>" +
                "Right arrow to move to the right side, left arrow to move to the left side and top arrow to kick to the goal.<br/>" +
                "2. Pay attention! You have 3 disqualifications, each miss is considered a disqualification.<br/>" +
                "3. After each goal the speed of the goal increases, get ready!<br/>" +
                "good luck!<html>");

        textRules.setBounds(x,y,width,height);
        textRules.setFont(font);
        this.add(textRules);
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
