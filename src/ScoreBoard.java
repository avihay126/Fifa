import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {
    public static final int LINE_DIFFERENCE=40, PARAMETER_WIDTH=80,PARAMETER_HEIGHT=60, PRINT_START_X=5,
    SIZE_FONT1=25,SIZE_FONT2=20 ,X_TITLE=40, Y_TITLE=0, WIDTH_TITLE=180,HEIGHT_TITLE=60;

    private int goals;
    private int fault;
    private JLabel goalScore;
    private JLabel faultScore;





    public ScoreBoard(int x, int y,int width,int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.gray);
        this.fault=3;
        Font font=new Font("Ariel",Font.BOLD,SIZE_FONT1);
        Font font2=new Font("Ariel",Font.BOLD,SIZE_FONT2);
        JLabel title=new JLabel("Score Board:");

        title.setBounds(X_TITLE,Y_TITLE,WIDTH_TITLE,HEIGHT_TITLE);
        title.setForeground(Color.black);
        title.setFont(font);
        this.add(title);


        JLabel goalsLabel = new JLabel("Goals:");
        goalsLabel.setBounds(PRINT_START_X,LINE_DIFFERENCE,PARAMETER_WIDTH,PARAMETER_HEIGHT);
        goalsLabel.setFont(font2);
        goalsLabel.setForeground(Color.black);
        this.add(goalsLabel);

        JLabel faultLabel = new JLabel("Fault:");
        faultLabel.setBounds(PRINT_START_X, LINE_DIFFERENCE*2, PARAMETER_WIDTH, PARAMETER_HEIGHT);
        faultLabel.setFont(font2);
        faultLabel.setForeground(Color.black);
        this.add(faultLabel);


        this.goalScore=new JLabel(String.valueOf(this.goals));
        this.goalScore.setBounds(PARAMETER_WIDTH,LINE_DIFFERENCE,PARAMETER_WIDTH,PARAMETER_HEIGHT);
        this.goalScore.setFont(font2);
        this.goalScore.setForeground(Color.black);
        this.add(goalScore);

        this.faultScore=new JLabel(String.valueOf(this.fault));
        this.faultScore.setBounds(PARAMETER_WIDTH,LINE_DIFFERENCE*2,PARAMETER_WIDTH,PARAMETER_HEIGHT);
        this.faultScore.setFont(font2);
        this.faultScore.setForeground(Color.black);
        this.add(faultScore);





        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
    }

    public void addGoal(){
        this.goals++;
        this.goalScore.setText(String.valueOf(this.goals));
    }
    public void lessFault(){
        this.fault--;
        this.faultScore.setText(String.valueOf(this.fault));
    }





    public JLabel getGoalScore() {
        return goalScore;
    }

    public void setGoalScore(JLabel goalScore) {
        this.goalScore = goalScore;
    }

    public JLabel getFaultScore() {
        return faultScore;
    }

    public void setFaultScore(JLabel faultScore) {
        this.faultScore = faultScore;
    }



    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;

    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;

    }

    public void setGoalsZero(){
        this.goals=0;
        this.goalScore.setText(String.valueOf(this.goals));
    }
    public void setFaultZero(){
        this.fault=3;
        this.faultScore.setText(String.valueOf(this.fault));

    }



}