package timerGUI;
import java.util.Timer;
import java.util.TimerTask;

public class LocalTimer implements Runnable {
	
	private int MILLISECOND = 1000;

	private String name;
	private int totalDuration;
	private int remainingDuration;
	
	public void run(){
		long startTime = System.currentTimeMillis();
		synchronized(this) {
			while(remainingDuration > 0) {
				try{
					wait(MILLISECOND);
					notifyProgress();
					remainingDuration--;
				} catch (InterruptedException e) {
					System.out.println(name + " interuppted");
				}
			}
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = (endTime - startTime)/1000;
		System.out.println("Elapsed time in timer: "+ elapsedTime +" seconds");
		notifyComplete();
	}
	
	public LocalTimer(String nameTimer, int totalDurationTimer) {
		name = nameTimer;
		totalDuration = totalDurationTimer;
		remainingDuration = totalDuration;
	}
	
	public int getTotalDuration() {
		return totalDuration;
	}
	
	public int getRemainingDuration() {
		return remainingDuration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTotalDuration(int totalDurationTimer) {
		totalDuration = totalDurationTimer;
	}
	
	public void setName(String nameTimer) {
		name = nameTimer;
	}
	
	public void notifyProgress() {
		//Does nothing so far, made for future implementation
	}
	
	public void notifyComplete() {
		System.out.println(name + " complete");
	}
}
