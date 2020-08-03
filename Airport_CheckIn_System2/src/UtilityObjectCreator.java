import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import f21as.checkinsystem.models.*;

public class UtilityObjectCreator {
	
	public SimpleEntry<Boolean, Passenger> createPassenger(String referenceNumber, String fullName, boolean checkedIn) {
		
		SimpleEntry<Boolean, Passenger> result = new AbstractMap.SimpleEntry<>(false,null);
			
		//if (!Passenger.isValidName(full_name))return result; //At this point return false
		//
		Passenger new_passenger = new Passenger(referenceNumber, fullName, checkedIn);
		result = new AbstractMap.SimpleEntry<>(true,new_passenger);
		return result;
		
	}
	
	public SimpleEntry<Boolean, Booking> createBooking(String reference,String flight_code,Passenger passenger, Boolean checkin_status) {
		
		SimpleEntry<Boolean, Booking> result = new AbstractMap.SimpleEntry<>(false,null);
		if (!Booking.isValidReference(reference) || passenger == null) return result; //Booking reference is not valid or passenger is null, return the null value.	
		
		Booking new_booking = new Booking(reference, flight_code, passenger, checkin_status);
		result = new AbstractMap.SimpleEntry<>(true,new_booking);
		return result;
	}

	public SimpleEntry<Boolean, Baggage> createBaggage(Double length_cm, Double width_cm,Double height_cm,Double weight_kg) {
	
	SimpleEntry<Boolean, Baggage> result = new AbstractMap.SimpleEntry<>(false,null);
		
	Baggage new_baggage = new Baggage(length_cm, width_cm, height_cm, weight_kg);
	result = new AbstractMap.SimpleEntry<>(true,new_baggage);
	return result;
	}
	
	public SimpleEntry<Boolean, Flight> createFlight(String _carrier_name, String _flight_code,Integer _max_seats, Double _weight_pax, Double _volume_pax, Double _excee_fee, String _des_code, String _des_location,String _des_airport) {
		
		SimpleEntry<Boolean, Flight> result = new AbstractMap.SimpleEntry<>(false,null);
		if (!Flight.isValidCode(_flight_code)) return result;
		Flight new_flight = new Flight(_carrier_name, _flight_code, _max_seats, _weight_pax, _volume_pax, _excee_fee, _des_code, _des_location, _des_airport);
		result = new AbstractMap.SimpleEntry<>(true,new_flight);
		return result;
	}
	
	public UtilityObjectCreator() {
		// TODO Auto-generated constructor stub
		
	}

}
