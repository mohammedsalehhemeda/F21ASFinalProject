package cw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class app {

	public static void main(String[] args) {
		

        
		passengers cnt = new passengers();
		  passengerFile newFile = new passengerFile();
		  
		  newFile.readFile1();
		      
		  
		  try
	       {
	          while(cnt.passengerthread.isAlive())
	          {
	            System.out.println("Passengers are still comming!"); 
	            Thread.sleep(1000);
	          }
	       }
	       catch(InterruptedException e)
	       {
	          System.out.println("Main thread interrupted");
	       }
	       System.out.println("Main thread run is over" );
	       
	}

}
