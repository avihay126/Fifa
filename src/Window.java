import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WIN_WID = 900, WIN_HEI = 700;

    public static void main(String[] args) {
        Window window = new Window();

    }

    public Window() {
        this.setSize(WIN_WID, WIN_HEI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("The fast gate by A.I.U.A");
        Menu menu=new Menu(0,0,WIN_WID,WIN_HEI);
        this.add(menu);
        Rules rules =new Rules(0,0,WIN_WID,WIN_HEI+50);
        this.add(rules);
        this.setVisible(true);



    }


}
