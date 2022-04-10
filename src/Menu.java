import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public static final int NEW_GAME_WIDTH = 150, NEW_GAME_HEIGHT = 50;

    private ImageIcon backGround;
    private JButton newGame;

    public Menu(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.backGround = new ImageIcon("pic_game.jpeg");
        Font font =new Font("Ariel",Font.BOLD,20);
        this.newGame = new JButton("New Game");
        this.newGame.setFont(font);
        this.newGame.setBounds(this.getWidth() / 2 - NEW_GAME_WIDTH / 2, this.getHeight() / 2 - NEW_GAME_HEIGHT / 2, NEW_GAME_WIDTH, NEW_GAME_HEIGHT);
        this.newGame.setVisible(true);
        this.add(newGame);
        this.newGame.addActionListener((event) -> {
            this.newGame.setVisible(false);
            GameScene gameScene = new GameScene(0, 0, width, height,this.newGame);
            this.add(gameScene);
        });
        this.setDoubleBuffered(true);
        this.setVisible(true);


    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.backGround.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);


    }
}

