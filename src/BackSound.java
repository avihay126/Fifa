import javax.sound.sampled.*;
import java.io.File;


public class BackSound {

    public void backSound(String sound) {
        try {
            File waveFile = new File(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(waveFile));
            clip.start();
        } catch (Exception e) {
            System.out.println("sound doesn't work");
        }

    }

}

