package stdouttimer;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		String timeString;
		int timerDuration;
		
		System.out.print("Enter number of timers to run: ");
		String numberOfTimersString = kb.nextLine();
		int numberOfTimers;
		
		try{
			numberOfTimers = Integer.valueOf(numberOfTimersString);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Expected an integer");
			return;
		}
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i = 0; i < numberOfTimers; i++){
			try {
				System.out.print("Enter a time for the timer (seconds): ");
				timeString = kb.nextLine();
				timerDuration = Integer.valueOf(timeString);
				
				System.out.print("Enter a name for the timer: ");
				String timerName = kb.nextLine();
				
				threads.add(new Thread(new LocalTimer(timerName, timerDuration)));
				threads.get(i).start();
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Expected an integer.");
			}
		}
		System.out.println("ALL TIMERS CREATED");
		/*
		 * for(int x = 0; x < 10000000; x++) { if(x%1000000 == 0)
		 * System.out.println("Stuff is still happening"); }
		 */
	}

}
