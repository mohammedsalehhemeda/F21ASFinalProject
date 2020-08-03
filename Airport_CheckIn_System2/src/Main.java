
//main class

public class Main {
    public static void main(String[] args) {
    	
    	PassengerQueue q = PassengerQueue.getInstance(); //define the main queue where the passengers will line up. 
    	
    	CheckinManager chkInManager = new CheckinManager(); 
    	chkInManager.run();

    	//run the first thread
    	Runnable runnable1 = new CheckinDesk(q);
    	Thread thread1 = new Thread(runnable1, "Desk1");
    	thread1.start();
        
    	//run the second thread
    	Runnable runnable2 = new CheckinDesk(q);
    	Thread thread2 = new Thread(runnable2, "Desk2");
    	thread2.start();
    }
}

//