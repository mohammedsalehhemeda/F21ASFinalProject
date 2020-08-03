
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FlightMap {
	private static Map<String, Integer> flightMap = new Hashtable<>();
	
	public static String getNumberOfPassengers(String flightNumber) {
		Integer numberOfPassengers = flightMap.get(flightNumber);
		if(numberOfPassengers == null)
			numberOfPassengers = 0;
		
		numberOfPassengers += 1;
		flightMap.put(flightNumber, numberOfPassengers);
		return Integer.toString(numberOfPassengers);
	}
	
	public static LinkedHashSet<String>  getSetOfFlightCodes(String flightNumber) {
		LinkedHashSet<String> flightCodes = new LinkedHashSet<>();
		Integer numberOfPassengers = flightMap.get(flightNumber);
		if(numberOfPassengers == null)
			numberOfPassengers = 0;
		
		numberOfPassengers += 1;
		flightMap.put(flightNumber, numberOfPassengers);
		flightCodes.add(flightNumber);
		return flightCodes;
//		System.out.println(flightMap.keySet());
	}
	
	
}
