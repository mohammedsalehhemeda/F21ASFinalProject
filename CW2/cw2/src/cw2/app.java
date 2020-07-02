package cw2;

public class app {

	public static void main(String[] args) {
		  passengers cnt = new passengers();
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
