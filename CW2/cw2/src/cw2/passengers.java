package cw2;

class passengers implements Runnable
{
   Thread passengerthread ;
   passengers()
   { 
	   passengerthread = new Thread(this, "Passengers Thread");
      System.out.println("Passengers Thread" + passengerthread);
      passengerthread.start();
   }
   public void run()
   {
      try
      {
        for (int i=0 ;i<10;i++)
        {
          System.out.println("Passenger " + i);
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