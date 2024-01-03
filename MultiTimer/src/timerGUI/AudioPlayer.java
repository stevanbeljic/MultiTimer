package timerGUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	public static void main(String[] args) {
		System.out.println("here");
		try {
			FileWriter fw = new FileWriter("test.txt");
			fw.write("You think you're the king, im the king\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("in here");
		}
		System.out.println("now here");
		AudioPlayer player = new AudioPlayer();
		player.play();
	}
	public AudioPlayer() {
		
	}
	
	public void play() {
		try {
			File audioFile = new File("src/timerGUI/harp.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			Thread.sleep(4000);
			
			clip.close();
			audioStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
