import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class Music {
    Clip clip = createClip(new File("nc162451.wav"));
    public Music(){}

    public void start() {
        clip.start();
    }
    
    public void stop(){
        clip.stop();
		clip.flush();
		clip.setFramePosition(0);
    }

    public static Clip createClip(File path) {
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
			
			AudioFormat af = ais.getFormat();
			
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			Clip c = (Clip)AudioSystem.getLine(dataLine);
			
			c.open(ais);
			
			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
}