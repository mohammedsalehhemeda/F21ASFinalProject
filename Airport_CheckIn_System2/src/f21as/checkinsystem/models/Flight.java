package f21as.checkinsystem.models;

//this class to help identifying the Baggage rules

public class Flight {
	
	//declare the variables for the flights details

	private String flight_code;
	private String carrier_name;
	private String destination_code;
	private String destination_airport;
	private String destination_location;
	private Integer max_seats;
	private Double max_baggage_weight_pax;
	private Double max_baggage_volume_pax;
	private Double excess_baggage_fee;
	
	//Getters and setters
	public String getName() {
		return carrier_name;
	}
	
	public String getFlightCode() {
		return flight_code;
	}
	
	public String getDestination() {
		
		String destination_details = "CODE : " + destination_code + "\n";
		destination_details +=  "AIRPORT" +" : "  + destination_airport + "\n";
		destination_details +=  "LOCATION" +" : "  + destination_location + "\n";
		return destination_details;
	}
	
	public Integer getSeatCapacity() {
		return max_seats;	
	}
	
	public Double getMaxBaggageWeight() {
		return max_baggage_weight_pax;
	}
	
	public Double getMaxBaggageVolume() {
		return max_baggage_volume_pax;
	}
	
	public Double getExcessFeePerKg() {
		return excess_baggage_fee;
	}
	
	
	public static boolean isValidCode(String _flight_code)
	{
		
		return true;
	}
	
	
	//the baggage constructor to create flight objects

	public Flight (String _carrier_name, String _flight_code,Integer _max_seats, Double _weight_pax, Double _volume_pax, Double _excee_fee, String _des_code, String _des_location,String _des_airport) {
		carrier_name = _carrier_name;
		flight_code = _flight_code;
		max_baggage_volume_pax = _volume_pax;
		max_baggage_weight_pax = _weight_pax;
		excess_baggage_fee = _excee_fee;
		destination_airport = _des_airport;
		destination_code  =_des_code;
		destination_location = _des_location;
		max_seats = _max_seats;
	}
}
