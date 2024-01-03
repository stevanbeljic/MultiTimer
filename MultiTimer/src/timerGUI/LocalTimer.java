package timerGUI;

public class LocalTimer {
	
	private String name;
	private int totalDuration;
	private int remainingDuration;
		
	public LocalTimer(String nameTimer, int totalDurationTimer) {
		name = nameTimer;
		totalDuration = totalDurationTimer;
		remainingDuration = totalDuration;
	}
	
	public void decrementTime() {
		remainingDuration--;
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
	}
	
	public void notifyComplete() {
		//System.out.println(name + " complete");
	}
}
