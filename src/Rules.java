import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel {
    public static final int EXIT_WIDTH = 100, EXIT_HEIGHT = 50, SIZE_FONT = 30;

    private JLabel rules;
    private JButton exit;

    public Rules(int x, int y, int width, int height, JButton menuNewGame, JButton menuGameRule) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.lightGray);
        Font font = new Font("Ariel", Font.BOLD, SIZE_FONT);
        this.rules=Helper.addLabel(this,font,"<html>Welcome to " +
                " The fast gate!<br/>" +
                "Game rules:<br/>" +
                "1. Active buttons in the game are:<br/>" +
                "Right arrow to move to the right side, left arrow to move to the left side and top arrow to kick to the goal.<br/>" +
                "2. You have to score " + GameScene.GOAL_IN_GAME + " goals to win.<br/>" +
                "3. Pay attention! You have 3 disqualifications, each miss is considered a disqualification.<br/>" +
                "4. After each goal the speed of the goal increases, get ready!" + "\n" +
                "5. We recommend playing with sound.<br/>" +
                "good luck!<html>",Color.black,x, y, width, height);
        this.setDoubleBuffered(true);
        this.setVisible(true);
        this.exit = Helper.addButton(this,font, "Exit", this.getWidth() / 2 - EXIT_WIDTH / 2, Stadium.BOUND_Y + Stadium.BOUND_HEIGHT - EXIT_HEIGHT, EXIT_WIDTH, EXIT_HEIGHT);
        this.exit.addActionListener((event) -> {
            this.setVisible(false);
            this.exit.setVisible(false);
            menuGameRule.setVisible(true);
            menuNewGame.setVisible(true);
        });
    }

}
