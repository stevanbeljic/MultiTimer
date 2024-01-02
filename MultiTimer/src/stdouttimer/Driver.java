package stdouttimer;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		String timeString;
		int timerDuration;
		
		while(true){
			try {
				System.out.print("Enter a time for the timer (seconds): ");
				timeString = kb.nextLine();
				timerDuration = Integer.valueOf(timeString);
				break;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Expected an integer.");
			}
		}
		
		System.out.print("Enter a name for the timer: ");
		String timerName = kb.nextLine();
		
		Thread t = new Thread(new LocalTimer(timerName, timerDuration));
		t.start();
		
		Thread t1 = new Thread(new LocalTimer("timer2", timerDuration+2));
		t1.start();
		/*
		 * for(int x = 0; x < 10000000; x++) { if(x%1000000 == 0)
		 * System.out.println("Stuff is still happening"); }
		 */
	}

}
