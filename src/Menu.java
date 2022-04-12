import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public static final int BUTTON_WIDTH = 150, BUTTON_HEIGHT = 50;

    private ImageIcon backGround;
    private JButton newGame;
    private JButton rulesOfGame;

    public Menu(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.backGround = new ImageIcon("the fast gate wind.png");
        Font font = new Font("Ariel", Font.BOLD, 20);
        this.newGame=addButton(font,"New Game",this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight() - BUTTON_HEIGHT * 4.8), BUTTON_WIDTH, BUTTON_HEIGHT);
        this.rulesOfGame=addButton(font,"Game Rules",this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight() - BUTTON_HEIGHT * 3.8), BUTTON_WIDTH, BUTTON_HEIGHT);

        this.newGame.addActionListener((event) -> {
            unVisibleButton();
            GameScene gameScene = new GameScene(0, 0, width, height, this.newGame);
            this.add(gameScene);
        });
        this.rulesOfGame.addActionListener((event) -> {
            unVisibleButton();
            Rules rules = new Rules(x, y, width, height);
            this.add(rules);
        });
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    private void unVisibleButton() {
        this.newGame.setVisible(false);
        this.rulesOfGame.setVisible(false);
    }

    private JButton addButton(Font font, String buttonText,int x,int y,int width,int height){
        JButton button=new JButton(buttonText);
        button.setFont(font);
        button.setBounds(x,y,width,height);
        button.setVisible(true);
        this.add(button);
        return button;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.backGround.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}

