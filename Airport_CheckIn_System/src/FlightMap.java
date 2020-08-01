import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class FlightMap {
	private static Map<String, Integer> flightMap = new Hashtable<>();
	
	public static void assignToFlight(String flightNumber) {
		Integer numberOfPassengers = flightMap.get(flightNumber);
		if(numberOfPassengers == null)
			numberOfPassengers = 0;
		
		numberOfPassengers += 1;
		flightMap.put(flightNumber, numberOfPassengers);
		
		System.out.println(flightNumber + " - " + numberOfPassengers);
	}
	
	
}
