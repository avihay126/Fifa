import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel {
    private JLabel rules;
//    public static final int RULES_OF_GAME_WIDTH = 150, RULES_OF_GAME_HEIGHT = 50;

    public Rules(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        Font font = new Font("Ariel", Font.BOLD, 16);
        JLabel textRules = new JLabel("Welcome to \n" +
                "The fast gate!\n" +
                "Game rules:\n" +
                "1. Active buttons in the game are:\n" +
                "Right arrow to move to the right side, left arrow to move to the left side and top arrow to kick to the goal.\n" +
                "2. Pay attention! You have 3 disqualifications, each miss is considered a disqualification.\n" +
                "3. After each goal the speed of the goal increases, get ready!\n" +
                "good luck!");
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
