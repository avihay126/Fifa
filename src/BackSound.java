import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


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
        //TODO: add loop to sound

    }

}

