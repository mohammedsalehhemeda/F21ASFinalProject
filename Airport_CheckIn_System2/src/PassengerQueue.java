
//import the required libraries
import java.util.*; 
import f21as.checkinsystem.models.*;
import java.util.Iterator;


//this class to iterate PassengerQueue and Queue<Booking>
public class PassengerQueue implements Container {

	   public Iterator getIterator() {
		      return new NameIterator();
		   }

	private static PassengerQueue instance = null; 
	private static Queue<Booking> queueBooking = new LinkedList<>(); 
	
	PassengerQueue() {
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


	
	   private class NameIterator implements Iterator {

		      int index;
		      Booking booking;
		      @Override
		      public boolean hasNext() {
		      
		         if(index < queueBooking.size()){
		            return true;
		         }
		         return false;
		      }

		      @Override
		      public Object next() {
		      
		         if(this.hasNext()){
		            return queueBooking.add(booking);
		         }
		         return null;
		      }		
		   }
		}

