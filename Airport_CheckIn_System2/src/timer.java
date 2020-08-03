
//this class to use swing timing
//after implementing the timer we did not use it


import java.util.Timer;
import java.util.TimerTask;

public class timer{

	
int secondsPassed = 0;
	
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
	
		
		
		
		
	public void run() {
			secondsPassed++;
			System.out.println(secondsPassed); 
			
	}
	
	};
	
	public void start() {
		myTimer.scheduleAtFixedRate(task,1000,1000);	}



	
	}
