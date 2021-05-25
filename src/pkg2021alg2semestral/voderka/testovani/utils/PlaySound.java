package pkg2021alg2semestral.voderka.testovani.utils;

import java.applet.*;
import java.net.*;

/**
 *
 * @author Martin
 */
public class PlaySound {
    
    /**
     * Plays sound of success (correct answer) 
     */
    public void playGoodSound(){
        try 
        {
            //setting audio file and it's absolute
            AudioClip clip = Applet.newAudioClip(new URL("file:\\C:\\Users\\Martin\\Documents\\Semestral\\winsound.wav"));
            clip.play();
        } catch (MalformedURLException murle) {
            System.out.println(murle);
            System.out.println("Win sound Error");
        }
    }
    
    /**
     * Plays sound of failture (incorrect answer)
     */
    public void playFailSound(){
        try 
        {
            //setting audio file and it's absolute
            AudioClip clip = Applet.newAudioClip(new URL("file:\\C:\\Users\\Martin\\Documents\\Semestral\\failsound2.wav"));
            clip.play();
        } catch (MalformedURLException murle) {
            System.out.println(murle);
            System.out.println("Win sound Error");
        }
    }
    
}
