package stdouttimer;
import java.util.Timer;
import java.util.TimerTask;

public class LocalTimer implements Runnable {
	
	private int MILISECOND = 1000;

	private String name;
	private int totalDuration;
	private int remainingDuration;
	
	public void run(){
		remainingDuration = totalDuration;
		long startTime = System.currentTimeMillis();
		synchronized(this) {
			while(remainingDuration > 0) {
				try{
					wait(MILISECOND);
					System.out.println(name+": "+remainingDuration);
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
	
	public void notifyComplete() {
		System.out.println(name + " complete");
	}
}
