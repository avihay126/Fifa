import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {
    public static final int LINE_DIFFERENCE = 40, PARAMETER_WIDTH = 80, PARAMETER_HEIGHT = 60, PRINT_START_X = 5,
            TITLE_SIZE = 25, CONTENT_SIZE = 20, X_TITLE = 40, Y_TITLE = 0, WIDTH_TITLE = 180, HEIGHT_TITLE = 60, OPPORTUNITIES = 3;

    private int goals;
    private int fault;
    private JLabel title;
    private JLabel goalScore;
    private JLabel faultScore;


    public ScoreBoard(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.gray);
        this.fault = OPPORTUNITIES;
        Font titleFont = new Font("Ariel", Font.BOLD, TITLE_SIZE);
        Font contentFont = new Font("Ariel", Font.BOLD, CONTENT_SIZE);
        this.title = addLabel(titleFont, "Score Board:", Color.black, X_TITLE, Y_TITLE, WIDTH_TITLE, HEIGHT_TITLE);
        JLabel goalsLabel;
        goalsLabel = addLabel(contentFont, "Goals:", Color.black, PRINT_START_X, LINE_DIFFERENCE, PARAMETER_WIDTH, PARAMETER_HEIGHT);
        JLabel faultLabel;
        faultLabel = addLabel(contentFont, "Fault:", Color.black, PRINT_START_X, LINE_DIFFERENCE * 2, PARAMETER_WIDTH, PARAMETER_HEIGHT);
        this.goalScore = addLabel(contentFont, String.valueOf(this.goals), Color.black, PARAMETER_WIDTH, LINE_DIFFERENCE, PARAMETER_WIDTH, PARAMETER_HEIGHT);
        this.faultScore = addLabel(contentFont, String.valueOf(this.fault), Color.black, PARAMETER_WIDTH, LINE_DIFFERENCE * 2, PARAMETER_WIDTH, PARAMETER_HEIGHT);

        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    private JLabel addLabel(Font font, String labelText, Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setForeground(color);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        this.add(label);
        return label;

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }

    public void addGoal() {
        this.goals++;
        this.goalScore.setText(String.valueOf(this.goals));
    }

    public void lessFault() {
        this.fault--;
        this.faultScore.setText(String.valueOf(this.fault));
    }

    public int getGoals() {
        return goals;
    }

    public int getFault() {
        return fault;
    }

}