import javax.swing.*;
import java.awt.*;


public class GameScene extends JPanel {

    public static final int GAME_SPEED = 6, SCORE_BOARD_WIDTH = 260, SCORE_BOARD_HEIGHT = 160, EXIT_WIDTH = 80, EXIT_HEIGHT = 20,
            START_GOAL_SPEED = 19, REDUCE_SPEED = 3, MAX_SPEED = 4, GOAL_IN_GAME = 10, END_LABEL_WIDTH = 350, END_LABEL_HEIGHT = 140,
            SIZE_FONT = 70, BEHIND_THE_LINE = 15, LOSE = 0, GRAPHICS_THICKNESS=3;

    private Player player;
    private Stadium stadium;
    private Ball ball;
    private BackSound backSound;
    private ScoreBoard scoreBoard;
    private JButton exit;
    private JButton menuNewGame;
    private JButton menuGameRule;
    private JLabel winner;
    private JLabel looser;
    private Font endLabelFont;
    private boolean run;
    private int goalSpeed;


    public GameScene(int x, int y, int width, int height, JButton menuNewGame, JButton menuGameRule) {
        this.setBackground(Color.green);
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.run = true;
        this.endLabelFont = new Font("Ariel", Font.ITALIC, SIZE_FONT);
        this.menuNewGame = menuNewGame;
        this.menuGameRule = menuGameRule;
        this.goalSpeed = START_GOAL_SPEED;
        this.scoreBoard = new ScoreBoard(x + Stadium.BOUND_X, Stadium.BOUND_Y + Stadium.BOUND_HEIGHT - SCORE_BOARD_HEIGHT, SCORE_BOARD_WIDTH, SCORE_BOARD_HEIGHT);
        this.add(this.scoreBoard);
        this.backSound = new BackSound();
        this.backSound.backSound("start_game_whistle.wav");
        this.stadium = new Stadium();
        this.player = new Player(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        this.ball = new Ball(this.player.legsX(), this.player.legsY());

        this.exit = addButton(null, "Exit", Stadium.BOUND_X + Stadium.BOUND_WIDTH - EXIT_WIDTH, Stadium.BOUND_Y + Stadium.BOUND_HEIGHT - EXIT_HEIGHT, EXIT_WIDTH, EXIT_HEIGHT);

        this.exit.addActionListener((event) -> {
            this.exitGame();
        });

        this.goalMovement();
        this.gameLoop();
        this.setVisible(true);
    }

    private void goalMovement() {
        Thread t2 = new Thread(() -> {
            boolean goalMovement = true;
            while (this.run) {
                if (goalMovement) {
                    this.stadium.goalMoveRight();
                } else {
                    this.stadium.goalMoveLeft();
                }
                if (reachRightBound(this.stadium.getGoal().getX(), this.stadium.getGoal().getWidth())) {
                    goalMovement = false;
                } else if (reachLeftBound(this.stadium.getGoal().getX())) {
                    goalMovement = true;
                }
                try {
                    repaint();
                    Thread.sleep(this.goalSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    private void gameLoop() {
        Thread t1 = new Thread(() -> {
            keyControl();
            boolean shoot = false;
            while (this.run) {
                switch (this.player.getDirection()) {
                    case Player.RIGHT:
                        this.player.moveRight();
                        break;
                    case Player.LEFT:
                        this.player.moveLeft();
                        break;
                }
                if (reachRightBound(this.player.getLocation(), this.player.getBodyWidth())) {
                    this.player.moveLeft();
                } else if (reachLeftBound(this.player.getLocation())) {
                    this.player.moveRight();
                }
                if (!shoot) {
                    this.ball.dribble(this.player.legsX(), this.player.legsY());
                }
                if (this.ball.getDirection() == Ball.UP) {
                    shoot = true;
                    this.ball.goUp();
                    if (ball.getYLocation() == this.player.legsY() - 1) {
                        backSound.backSound("kick.wav");
                    }
                }
                if (this.ball.getYLocation() == this.stadium.getBoundY() - BEHIND_THE_LINE) {
                    shoot = false;
                    this.ball.setDirection(Ball.NONE);
                }
                if (ballGetEnd() && isGoal()) {
                    System.out.println("goal");
                    this.backSound.backSound("goal.wav");
                    this.scoreBoard.addGoal();
                    if (this.goalSpeed > MAX_SPEED) {
                        this.goalSpeed -= REDUCE_SPEED;
                    } else this.goalSpeed = MAX_SPEED;
                } else if (ballGetEnd() && !isGoal()) {
                    System.out.println("Missed");
                    this.scoreBoard.lessFault();
                }
                if (this.scoreBoard.getGoals() == GOAL_IN_GAME) {
                    this.winner = addLabel(this.endLabelFont, "!! Winner !!", Color.blue, this.getWidth() / 2 - END_LABEL_WIDTH / 2, this.getHeight() / 3 - END_LABEL_HEIGHT / 2, END_LABEL_WIDTH, END_LABEL_HEIGHT);
                    this.backSound.backSound("victory.wav");
                    gameFinished();

                    System.out.println("victory!  game over");


                } else if (this.scoreBoard.getFault() == LOSE) {
                    this.looser = addLabel(this.endLabelFont, "you lose !!", Color.red, this.getWidth() / 2 - END_LABEL_WIDTH / 2, this.getHeight() / 3 - END_LABEL_HEIGHT / 2, END_LABEL_WIDTH, END_LABEL_HEIGHT);
                    this.backSound.backSound("end_game_whistle.wav");
                    gameFinished();
                    System.out.println("game over");
                }
                repaint();
                try {
                    Thread.sleep(GAME_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }

    private void gameFinished() {
        this.run = false;
        this.exit.setFont(this.endLabelFont);
        this.exit.setBounds(this.getWidth() / 2 - END_LABEL_WIDTH / 2, this.getHeight() / 2 - END_LABEL_HEIGHT / 2, END_LABEL_WIDTH, END_LABEL_HEIGHT);
    }

    private boolean ballGetEnd() {
        return this.ball.getYLocation() == this.stadium.getBoundY();
    }

    private boolean isGoal() {
        return this.ball.getXLocation() > this.stadium.getGoalX() && this.ball.getXLocation() < this.stadium.getGoalX() + this.stadium.getGoalWidth();
    }

    private boolean reachRightBound(int objectLocation, int objectWidth) {
        return objectLocation == Stadium.BOUND_X + Stadium.BOUND_WIDTH - objectWidth;
    }

    private boolean reachLeftBound(int objectLocation) {
        return objectLocation == Stadium.BOUND_X;
    }

    private JButton addButton(Font font, String buttonText, int x, int y, int width, int height) {
        JButton button = new JButton(buttonText);
        button.setFont(font);
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        this.add(button);
        return button;
    }

    private JLabel addLabel(Font font, String labelText, Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setForeground(color);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        this.add(label);
        return label;

    }

    public void keyControl() {
        KeyControl keyControl = new KeyControl(this.player, this.ball);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(keyControl);
    }

    public void exitGame() {
        this.run = false;
        this.setVisible(false);
        this.scoreBoard.setVisible(false);
        this.stadium.setVisible(false);
        this.menuNewGame.setVisible(true);
        this.menuGameRule.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setStroke(new BasicStroke(GRAPHICS_THICKNESS));
        super.paintComponent(g);
        this.stadium.paint(g);
        this.ball.paint(g);
        this.player.paint(g);


    }
}