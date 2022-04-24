import javax.swing.*;
import java.awt.*;

public abstract class Helper {

    public static JButton addButton(JPanel panel, Font font, String buttonText, int x, int y, int width, int height) {
        JButton button = new JButton(buttonText);
        button.setFont(font);
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        panel.add(button);
        return button;
    }
    public static JLabel addLabel(JPanel panel,Font font, String labelText, Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setForeground(color);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        panel.add(label);
        return label;

    }
}
