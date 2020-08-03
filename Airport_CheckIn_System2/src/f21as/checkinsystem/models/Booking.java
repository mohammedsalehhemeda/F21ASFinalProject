//used under the following package

package f21as.checkinsystem.models;

//this class to help identifying the Baggage rules

public class Booking {
	
	//declare the variables for the booking details

	private String reference;
	private Passenger passenger;
	private Boolean is_checked_in;
	private String flight_code;
	private Baggage baggage_info;
	
	//Getters and setters
	public String getReference() {
		return reference;
	}
	
	public String getFlightCode() {
		return flight_code;
	}
	
	public Boolean getCheckinStatus() {
		return is_checked_in;
	}
	
	public Passenger getPassenger() {
		return passenger;	
	}
	
	public Baggage getBaggage() {
		return baggage_info;
	}
	
	//Setters
	public void updatePassenger(Passenger _passenger) {
		passenger = _passenger;
	}
	
	public void setBaggage(Baggage _baggage_info) {
		baggage_info = _baggage_info;
	}
	
	public void updateCheckinStatus(Boolean checkin_status) {
		is_checked_in = checkin_status;
	}
	
	public static boolean isValidReference(String _reference)
	{
		//Expected booking reference should be in below format
		// XX-AAAAAA ; X- number/letter, A - letter 
		// Ex: EK-FDWEFA
		if (_reference.length() != 9) return false;
		String components[] = _reference.split("-");
		if (components.length != 2) return false;
		
		for (char c : components[1].toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }
		return true;
	}
	
	public String getBookingDetails() {
		String booking_details = "REF CODE" +" : "  + reference + "\n";
		booking_details +=  "PASSENGER"+" : "  + passenger.getFullName() + "\n";
		booking_details +=  "CHECKIN" +" : "  +  is_checked_in.toString() + "\n";
		return booking_details;
	}
	
	//the baggage constructor to create booking objects

	public Booking(String _reference, String _flight_code,Passenger _passenger, Boolean checkin_status) {
		reference = _reference;
		flight_code = _flight_code;
		passenger = _passenger;
		is_checked_in = checkin_status;
	}
	
}
