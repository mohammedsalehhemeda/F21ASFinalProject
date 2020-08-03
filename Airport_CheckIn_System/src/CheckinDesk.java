import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import f21as.checkinsystem.models.Baggage;
import f21as.checkinsystem.models.Booking;
import f21as.checkinsystem.models.Flight;
import f21as.checkinsystem.models.Passenger;

import java.io.IOException;

public class CheckinDesk implements Runnable{
    
    Booking bookingDetails = null; 
    PassengerQueue passengerQueue;
    long checkinTime;

    public CheckinDesk(PassengerQueue q, long checkinTime){
    	passengerQueue = q;
    	this.checkinTime = checkinTime;
    }
    
    /**
	 * Run the main thread where each Passenger/Booking will be processed and assigned to their Flight 
	 */
    public void run() {
//    	System.out.println("Starting thread..."+Thread.currentThread().getName());
        
        synchronized(passengerQueue){
        	Iterator iter = passengerQueue.ReadQueue().iterator();
        	if(iter == null){
            	System.out.println("Queue is empty. No more passengers to proceed..."+Thread.currentThread().getName());
            }
            while(iter.hasNext()){
                bookingDetails = (Booking) iter.next();
                System.out.println(bookingDetails.getBookingDetails());
                processCheckIn(bookingDetails, Thread.currentThread().getName());
                iter.remove();
            }
        }
        
		try {
			Thread.sleep(checkinTime); // This represent reasonable time for checkIn 
		} catch (InterruptedException e1) {
			System.out.println(e1.getMessage());
		}
		
    	System.out.println("Completing thread..."+Thread.currentThread().getName());
    }
    
    /**
	 * Assign each Booking to the Flight and process the check in  
	 */
    public Boolean processCheckIn(Booking bookingDetails, String threadName) {
    	Boolean checkin_status = false; 
		try {
			if (bookingDetails.getCheckinStatus()) {
				checkin_status = true;
				System.out.println(threadName + ": Booking is already checked in. Please proceed to Gate."); 
			}
			else {
				Flight flight = BookingManager.getFlight(bookingDetails.getFlightCode()); 
				
				if(flight == null) {
					System.out.println(threadName + ": Flight is not found.");
					checkin_status = false; 
					return checkin_status;
				}
				
				Baggage bg = bookingDetails.getBaggage(); 
				Double excess_fees = bg.calcuateExcessFee(flight.getMaxBaggageWeight(), flight.getExcessFeePerKg()); 
				
				// check excess fees status 
				if (excess_fees > 0.0) {
					System.out.println(threadName + ": You are required to pay excess fees: " + excess_fees.toString() + "AED.");
					bg.setExcessFee(excess_fees);
				}
				
				checkin_status = true; 
				bookingDetails.updateCheckinStatus(checkin_status);
				
				System.out.println(threadName + ": Check in is complete. Please proceed to Gate.");
				
			}
		}
		catch(Exception e){
			System.out.println(threadName + ": An error occured while check in booking details." + e.getMessage());
		}
    	
		return checkin_status;
    }
        
}