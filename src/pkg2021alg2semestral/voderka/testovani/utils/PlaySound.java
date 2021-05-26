package pkg2021alg2semestral.voderka.testovani.utils;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class to play sound. Inclueded method to to play sound of success and failture
 * 
 * @author Martin
 */
public class PlaySound implements LineListener{
    
    /**
     * Plays sound of success (correct answer) 
     */
    public void playGoodSound(){        
        String soundPath = "data\\winsound.wav";
        play(soundPath);
    }
    
    /**
     * Plays sound of failture (incorrect answer)
     */
    public void playFailSound(){        
        String soundPath = "data\\failsound2.wav";
        play(soundPath);
    }
    
    /**
    * boolean to indicates start and stop of playing the sound
    */
    boolean playCompleted;
     
    /**
     * Play a given audio file.
     * @param audioFilePath - Path of the sound file.
     */
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
        playCompleted = false;
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);            
            audioClip.start();
            while (!playCompleted) 
            {
            // wait for the playback completes
            try {
            Thread.sleep(1);
            } catch (InterruptedException ex) {
            }
            }
            audioClip.close();
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
        }         
    }
     
    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            //System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            //System.out.println("Playback completed.");
        }
    }
    
    
    
}
