package timerGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	
	private Clip clip;
	private String fileName;
	private String filePath = "src/timerGUI/";
	
	public AudioPlayer() {
		
	}
	
	public AudioPlayer(String fName) {
		fileName = fName;
	}
	
	public void play() {
		try {
			String fullFilePath = filePath + fileName;
			File audioFile = new File("src/timerGUI/harp.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();			
			audioStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopClip() {
		clip.close();
	}
}
