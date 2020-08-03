//This is the airlines class
//The class is used to manage the bookings
//Objects of this class have been used a lot in the other classes 

//import the required libraries
import java.util.*;
import f21as.checkinsystem.models.Baggage;
import f21as.checkinsystem.models.Booking;
import f21as.checkinsystem.models.Flight;

public class BookingManager {

	//STATIC PROPERTIES TO BE ACCESSED BY OTHER METHODS AS WELL
		private static TreeMap<String, Booking> bookings_map = new TreeMap<String,Booking>();
		private static HashMap<String, Flight> flights_map = new HashMap<String,Flight>();
	
		

		public static Booking getBooking(String reference_number) {
			try {
				if (!bookings_map.containsKey(reference_number)) return null;
				Booking result = bookings_map.get(reference_number);
				return result;
				
			} catch (Exception e) {
				// TODO: handle exception
				
				return null;
			}
		}
		
		public static Boolean addBooking(String reference_number, Booking booking) {
			if (bookings_map.containsKey(reference_number)) return false; //Booking already exists
			bookings_map.put(reference_number, booking);
			return true;
		}
		
		public static Flight getFlight(String flight_code) {
			try {
				if (!flights_map.containsKey(flight_code)) return null;
				Flight result = flights_map.get(flight_code);
				return result;
				
			} catch (Exception e) {
				// TODO: handle exception
				
				return null;
			}
		}
		
		public static Boolean addFlight(String flight_code, Flight flight) {
			if (flights_map.containsKey(flight_code)) return false;
			flights_map.put(flight_code, flight);
			return true;
		}
		
		public static String getReport()
		{
			String result = "***********FLIGHT REPORTS************" + "\n"+ "\n"+ "\n"+ "\n";
			for (Map.Entry flight_entry : flights_map.entrySet()) {
				
				Flight  _flight = (Flight) flight_entry.getValue();
				String flight_code = _flight.getFlightCode();
				Integer total_checked_in = 0;
				Double total_baggage_weight = 0.0;
				Double total_baggage_volume = 0.0;
				Double total_excess_fee = 0.0;
				
				for (Map.Entry booking_entry : bookings_map.entrySet()) {
					Booking _booking = (Booking) booking_entry.getValue();
					
					if (!_booking.getFlightCode().equals(flight_code)) continue;
					
					//Flight code matches.
					if (_booking.getCheckinStatus()) total_checked_in ++; // passenger has checked in
					
					Baggage _baggage = _booking.getBaggage();
					if (_baggage != null)
					{
						total_baggage_volume +=_baggage.getVolume();
						total_baggage_weight += _baggage.getWeight();
						total_excess_fee  += _baggage.getExcessFee();
					}
				}
				
				result += "FLIGHT DETAILS : " + "\n";
				result += _flight.getDestination();
				result += "TOTAL PASSENGERS CHECKED IN : " + total_checked_in + "\n";
				result += "TOTAL BAGGAGE WEIGHT : " + total_baggage_weight+ "\n";
				result += "TOTAL BAGGAGE VOLUME : " + total_baggage_volume+ "\n";
				result += "TOTAL EXCESS FEE COLLECTED : " + total_excess_fee+ "\n"+"\n";
				
				if (_flight.getMaxBaggageVolume() < total_baggage_volume)
				{
					result += "Current baggge volume exceeds the maximum limit of " +_flight.getMaxBaggageVolume()+"\n";
				}
				
				if (_flight.getMaxBaggageWeight() < total_baggage_weight)
				{
					result += "Current baggge weight exceeds the maximum limit of " +_flight.getMaxBaggageWeight()+"\n";
				}
				result += "\n"+"\n"+"\n";
			}
			return result;
		}
		
	public BookingManager() {
		// TODO Auto-generated constructor stub
	}

}
