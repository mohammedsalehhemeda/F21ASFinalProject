package cw2;

import java.util.ArrayList;
import java.util.Collections;

class passengers extends passengerFile implements Runnable 
{
    ArrayList<String> randomized = new ArrayList<String>();

	  passengerFile newFile = new passengerFile();
	  
	 
	
   Thread passengerthread ;
   passengers()
   { 
	   passengerthread = new Thread(this, "Passengers Thread");
      System.out.println("Passengers Thread" + passengerthread);
      passengerthread.start();
   }
   
   public void run()
   {
	   randomized = readFile1();
	   Collections.shuffle(readFile1());
	   
      try
      {
        for (int i=1 ;i<10;i++)
        {
          System.out.println("Passenger: " + readFile1().get(i));
          Thread.sleep(1000);
        }
     }
     catch(InterruptedException e)
     {
        System.out.println("my thread interrupted");
     }
     System.out.println("mythread run is over" );
   }
}