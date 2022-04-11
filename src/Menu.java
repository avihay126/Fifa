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
        Font font =new Font("Ariel",Font.BOLD,20);
        this.newGame = new JButton("New Game");
        this.newGame.setFont(font);
        this.newGame.setBounds(this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight()  - BUTTON_HEIGHT*4.8), BUTTON_WIDTH,BUTTON_HEIGHT );
        this.newGame.setVisible(true);
        this.add(newGame);
        this.newGame.addActionListener((event) -> {
            this.newGame.setVisible(false);
            GameScene gameScene = new GameScene(0, 0, width, height,this.newGame);
            this.add(gameScene);
        });
        Font font1 =new Font("Ariel",Font.BOLD,16);
        this.rulesOfGame = new JButton("Rules Of Game");
        this.rulesOfGame.setFont(font1);
        this.rulesOfGame.setBounds(this.getWidth() / 2 - BUTTON_WIDTH / 2, (int) (this.getHeight()  - BUTTON_HEIGHT*3.8), BUTTON_WIDTH, BUTTON_HEIGHT);
        this.rulesOfGame.setVisible(true);
        this.add(rulesOfGame);
        this.rulesOfGame.addActionListener((event) -> {
            this.rulesOfGame.setVisible(false);
        Rules rules=new Rules(x,y,width,height);
            this.add(rules);

        this.setDoubleBuffered(true);
        this.setVisible(true);

    });

    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.backGround.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);


    }
}

