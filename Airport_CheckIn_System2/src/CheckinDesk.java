import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import java.util.concurrent.TimeUnit;
import f21as.checkinsystem.models.Booking;
import f21as.checkinsystem.models.Passenger;

import java.io.IOException;

public class CheckinDesk implements Runnable{
    //private HashMap<String, Passenger> bookingPassengerHashMap;
    //private HashMap<String, Passenger> lastNamePassengerHashMap;
	

    PassengerQueue passengerQueue = null; 
    Booking bookingDetails = null; 

    public CheckinDesk(PassengerQueue q){
        //bookingPassengerHashMap = new HashMap<>();
        //lastNamePassengerHashMap = new HashMap<>();
        passengerQueue = q; 
        
    }
/**
 * Reading bookings.csv file and storing the passenger's data in HashMap once with a reference number as the key 
 * and another time as the last name as the key
 * @return hash map (reference number, Passenger)
 * @return hash map (last name, Passenger)
 */
    public void run() {
    	System.out.println("Starting thread..."+Thread.currentThread().getName());
        /*
    	try {
            String csvFilePath = "src/_bookings.csv";
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath)); //Reading CSV file
            String line = br.readLine(); // To skip the first line - header.
            while((line = br.readLine()) != null){
                String split[] = line.split(","); //Splitting by ','
                boolean checkedIn = false;
                if (split[3].equals("TRUE"))
                    checkedIn = true;
                Passenger p = new Passenger(split[0], split[2], checkedIn); //Storing cells in as Passenger objects
                bookingPassengerHashMap.put(split[0], p);
                //lastNamePassengerHashMap.put(split[2], p);
            }
        } catch (IOException e) { //Throwing IOEXCEPTON while reading the file
            System.out.println(e.getMessage() + " Error with the CSV file");
        }
        */
        synchronized(passengerQueue){
        	java.util.Iterator<Booking> iter = passengerQueue.ReadQueue().iterator();
        	if(iter == null){
            	System.out.println("Queue is empty. No more passengers to proceed..."+Thread.currentThread().getName());
                //System.exit(1);
            }
            while(iter.hasNext()){
                bookingDetails = (Booking) iter.next();
      

//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    // recommended because catching InterruptedException clears interrupt flag
//                    Thread.currentThread().interrupt();
//                    // you probably want to quit if the thread is interrupted
//                    return;
//                }
//                
                
                System.out.println(bookingDetails.getBookingDetails());
                iter.remove();
            }
        }

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			System.out.println(e1.getMessage());
		}
    	System.out.println("Completing thread..."+Thread.currentThread().getName());
    	
    	
    }

/**
 * Returns Passenger details with reference number
 * @param referenceNumber
 * @return Passenger details with reference number
 */
    /*
    public Passenger getPassengerByReferenceNumber(String referenceNumber){
        return bookingPassengerHashMap.get(referenceNumber);
    }
    */
    /**
     * Returns Passenger details with last name
     * @param referenceNumber
     * @return Passenger details with last name
     */
    /*
    public Passenger getPassengerByLastName(String lastName){
        return lastNamePassengerHashMap.get(lastName);
    }
    */
}