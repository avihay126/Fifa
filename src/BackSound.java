import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class BackSound {


    public BackSound() {
//        try {
//            File waveFile=new File("SoccerCrowd.wav");
//            Clip clip=AudioSystem.getClip();
//            clip.open(AudioSystem.getAudioInputStream(waveFile));
//                clip.start();
//        } catch (Exception e){
//            System.out.println("sound doesn't work");
//                 }
//        //TODO: add loop to sound

    }

    public void backSound() {
        try {
            File waveFile = new File("SoccerCrowd.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(waveFile));
            clip.start();
        } catch (Exception e) {
            System.out.println("sound doesn't work");
        }
        //TODO: add loop to sound

    }

}

