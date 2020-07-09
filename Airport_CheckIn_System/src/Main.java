public class Main {
    public static void main(String[] args) {

    	Runnable runnable1 = new Desk1();
    	Thread thread1 = new Thread(runnable1, "Thread1");
    	thread1.start();
        
    	Runnable runnable2 = new Desk1();
    	Thread thread2 = new Thread(runnable2, "Thread2");
    	thread2.start();
    }
}