import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel {
    public static final int RULES_OF_GAME_WIDTH = 150, RULES_OF_GAME_HEIGHT = 50;

    private JButton rulesOfGame;

    public Rules(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        Font font =new Font("Ariel",Font.BOLD,16);
        this.rulesOfGame = new JButton("Rules Of Game");
        this.rulesOfGame.setFont(font);
        this.rulesOfGame.setBounds(this.getWidth() / 2 - RULES_OF_GAME_WIDTH / 2, this.getHeight() / 2 - RULES_OF_GAME_HEIGHT / 2, RULES_OF_GAME_WIDTH, RULES_OF_GAME_HEIGHT);
        this.rulesOfGame.setVisible(true);
        this.add(rulesOfGame);
        this.rulesOfGame.addActionListener((event) -> {
            this.rulesOfGame.setVisible(false);

        });
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }
}
