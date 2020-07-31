import java.util.AbstractMap.*;
import java.util.*;
import java.io.*;
import f21as.checkinsystem.models.*;

public class UtilityFileHelper {

	private UtilityObjectCreator creator; 
	
	/**
	 * Reads the CSV file and returns each line as an array list of string 
	 */
	public ArrayList<String> readCSV(String file_path, Boolean ignore_header) {
		
		List<String> result = new ArrayList<String>();
		try {
				//String current_directory = System.getProperty("user.dir"); //To get current directory.
					
				File _file = new File(file_path);
				if (!_file.exists()|| _file.isDirectory()) return null;

					Scanner scanner = new Scanner(_file);
					
					for (int line_number = 0; scanner.hasNextLine(); line_number++) {
						String line_value = scanner.nextLine(); 
						if (ignore_header && line_number ==0) continue; //If we need to ignore header, then ignore first line
						if (line_value.length() != 0) { //Empty lines are not read
							result.add(line_value);
						}
					}
				
					scanner.close();
					Collections.shuffle(result);
					return (ArrayList<String>) result;
			} catch (Exception ex) {
			System.out.println(ex.toString());
			System.out.println(0);
			return null; 
			}
	}

	/**
	 * Writes the string to a text file
	 * @param target_file_path Name of the output file
	 * @param report value that has to be written to the output file
	 */
	public void writeReport(String target_file_path,String report) {
				FileWriter fw;
			try {
				fw = new FileWriter(target_file_path);
				fw.write(report);
				fw.close();
			} 
			catch(FileNotFoundException fnf) {
				System.out.println(target_file_path + " not found");
				System.exit(0);
			}
			
			catch(IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
			
			catch (Exception e) {
				System.out.println(e.toString());
				System.exit(0);
			}
			
		}
	
	public void parseBookingDetail(String line)
	{
		try {
			//Expected booking line should be in below format
			//Booking Reference,Flight Code,Passenger Name,Checkin Status
			//RS-MOH-050220-APRKSN,RS-4982,Monica Mohamed,TRUE
			
			Random rand = new Random();
			Double length_cm, width_cm, height_cm, weight_kg;
			
			String components[] = line.split(",");
			
			if (components.length == 0 || components.length  != 4) return ; //The line has no data or in sufficient data
			
			String booking_ref = components[0].trim();
			String flight_code = components[1].trim(); 
			String passenger_name = components[2].trim();
			Boolean checked_in = Boolean.parseBoolean( components[3].trim());
			
			if (!Booking.isValidReference(booking_ref)) return; //If booking reference is not valid, don't proceed.
			SimpleEntry<Boolean,Passenger> passenger_entry =  creator.createPassenger(booking_ref, passenger_name, checked_in);
			if (!passenger_entry.getKey()) return; //Unable to create passenger, don't proceed.
			
			SimpleEntry<Boolean,Booking> booking_entry =  creator.createBooking(booking_ref, flight_code, passenger_entry.getValue(), checked_in);
			if (!booking_entry.getKey()) return; //Unable to create booking don't proceed.
			
			// Randomly assign a Baggage to the Passenger Booking 
			length_cm = (double) (rand.nextFloat() * (150 - 50) + 50); // max dimensions= 150cm , min= 50cm
			width_cm = (double) (rand.nextFloat() * (150 - 50) + 50);  
			height_cm = (double) (rand.nextFloat() * (150 - 50) + 50);
			weight_kg = (double) (rand.nextFloat() * (40 - 5) + 5); // max weight= 40 kg , min= 5kg 
			
			SimpleEntry<Boolean, Baggage> baggage_entry = creator.createBaggage(length_cm, width_cm, height_cm, weight_kg);
			if (!baggage_entry.getKey()) return; //Unable to create booking don't proceed.
			
			// Add Baggage to Booking 
			booking_entry.getValue().setBaggage(baggage_entry.getValue());
			
			// Add Booking to PassengerQueue 
			PassengerQueue.AddBooking(booking_entry.getValue());
			
			Boolean is_successful = BookingManager.addBooking(booking_ref, booking_entry.getValue()); //Add booking
			System.out.println(is_successful.toString() + " : Adding the booking detail with reference number - " + booking_ref);
	
		} catch (Exception ex) {
			System.out.println("Error while trying to create a booking : " + line);
			System.out.println(ex.toString());
			System.out.println(0);
		}
	}

	public void parseFlightDetail(String line)
	{
		try {
		//Expected flight detail line should be in below format
		//Flight Code,Carrier Name,Destination Code,Airport,Destination,Max Passengers,Max bag weight pax (in kg), max bag volume (cu.m),Excess Baggage Fee (AED per kg)
		//RS-4982,Air Seoul,SEL,Incheon Airport,Seoul-South Korea,50,28,3.86,75
		
		String components[] = line.split(",");
		
		if (components.length == 0 || components.length  != 9) return ; //The line has no data or in sufficient data
		
		String flight_code = components[0].trim();
		String carrier_name = components[1].trim(); 
		String destination_code = components[2].trim();
		String destination_airport = components[3].trim();
		String destination_place = components[4].trim();
		Integer max_passengers = Integer.parseInt(components[5].trim());
		Double max_baggage_weight = Double.parseDouble(components[6].trim());
		Double max_baggage_volume = Double.parseDouble(components[7].trim());
		Double excess_fee = Double.parseDouble(components[8].trim());
		
		if(!Flight.isValidCode(flight_code)) return; //Code is not valid.
		
		SimpleEntry<Boolean, Flight> flight_entry = creator.createFlight(carrier_name, flight_code, max_passengers, max_baggage_weight, max_baggage_volume, excess_fee, destination_code, destination_place, destination_airport);
		if(!flight_entry.getKey()) return; //Unable to create flight.
				
		Boolean is_successful = BookingManager.addFlight(flight_code, flight_entry.getValue()); //Add booking
		System.out.println(is_successful.toString() + " : Adding the flight detail with flight code - " + flight_code);

		} catch (Exception ex) {
			System.out.println("Error while trying to create a flight detail : " + line);
			System.out.println(ex.toString());
			System.out.println(0);
		}
	}

	public UtilityFileHelper() {
		// TODO Auto-generated constructor stub
		creator = new UtilityObjectCreator();
	}

}
