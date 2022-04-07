import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.Scanner;

public class BackSound {


    public BackSound()  {
        try {

            File waveFile=new File("Soccer+Stadium+Crowd.wav");
            Clip clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(waveFile));
            System.out.println("cvbn");
            clip.start();


        } catch (LineUnavailableException x){
            System.out.println("k");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("d");
        } catch (IOException e) {
            System.out.println("j");        }

    }
}
