import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public static final int BUTTON_WIDTH = 150, BUTTON_HEIGHT = 50, SIZE_FONT = 20;
    public static final double BUTTON_Y_DIRECTION = 4.8;

    private ImageIcon backGround;
    private JButton newGame;
    private JButton rulesOfGame;

    public Menu(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.backGround = new ImageIcon("the fast gate wind.png");
        Font font = new Font("Ariel", Font.BOLD, SIZE_FONT);
        this.newGame = Helper.addButton(this,font, "New Game", this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight() - BUTTON_HEIGHT * BUTTON_Y_DIRECTION), BUTTON_WIDTH, BUTTON_HEIGHT);
        this.rulesOfGame = Helper.addButton(this,font, "Game Rules", this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight() - BUTTON_HEIGHT * (BUTTON_Y_DIRECTION - 1)), BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonsListener();
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    private void unVisibleButton() {
        this.newGame.setVisible(false);
        this.rulesOfGame.setVisible(false);

    }

    private void buttonsListener() {
        this.newGame.addActionListener((event) -> {
            unVisibleButton();
            GameScene gameScene = new GameScene(0, 0, this.getWidth(), this.getHeight(), this.newGame, this.rulesOfGame);
            this.add(gameScene);
        });
        this.rulesOfGame.addActionListener((event) -> {
            unVisibleButton();
            Rules rules = new Rules(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.newGame, this.rulesOfGame);
            this.add(rules);
        });
    }

    private JButton addButton(Font font, String buttonText, int x, int y, int width, int height) {
        JButton button = new JButton(buttonText);
        button.setFont(font);
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        this.add(button);
        return button;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.backGround.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}

