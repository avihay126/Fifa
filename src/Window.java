import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WIN_WID = 900, WIN_HEI = 700;

    public static void main(String[] args) {
        Window window = new Window();

    }

    public Window() {
        this.setVisible(true);
        this.setSize(WIN_WID, WIN_HEI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("The fast gate by A.I.U.A");
        GameScene gameScene = new GameScene(0, 0, WIN_WID , WIN_HEI);
      add(gameScene);


    }


}
