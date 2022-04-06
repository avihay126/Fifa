import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {

    private Player player;
    private Ball ball;

    public KeyControl(Player player,Ball ball) {
        this.player=player;
        this.ball=ball;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                this.player.setDirection(Player.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                this.player.setDirection(Player.LEFT);
                break;
            case KeyEvent.VK_UP:
                this.ball.setDirection(Ball.UP);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
