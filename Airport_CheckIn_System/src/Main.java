public class Main {
    public static void main(String[] args) {
    	
    	PassengerQueue q = PassengerQueue.getInstance(); //define the main queue where the passengers will line up. 
    	
    	long checkinTime1 = 3000; 
    	long checkinTime2 = 4000; 
    	
    	CheckinManager chkInManager = new CheckinManager(); 
    	chkInManager.run();

    	Runnable runnable1 = new CheckinDesk(q, checkinTime1);
    	Thread thread1 = new Thread(runnable1, "Desk1");
    	thread1.start();
        
    	Runnable runnable2 = new CheckinDesk(q, checkinTime2);
    	Thread thread2 = new Thread(runnable2, "Desk2");
    	thread2.start();
    }
}