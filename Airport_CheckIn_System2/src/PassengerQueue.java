import java.util.*; 

import f21as.checkinsystem.models.*;

public class PassengerQueue {
	
	private static PassengerQueue instance = null; 
	private static Queue<Booking> queueBooking = new LinkedList<>(); 
	
	private PassengerQueue() {
		if (instance != null) {
			throw new IllegalStateException("Object already instanciated.");
		}
	}
	
	public static PassengerQueue getInstance() {
		if(instance == null) {
			instance = new PassengerQueue(); 
		}
		return instance; 
	}
	
	public static Boolean AddBooking(Booking booking) {
		return queueBooking.add(booking);
	}
	
	public static Booking RetrieveBooking() {
		return queueBooking.remove();
	}
	
	public static Queue<Booking> ReadQueue() {
		return queueBooking;
	}

}
