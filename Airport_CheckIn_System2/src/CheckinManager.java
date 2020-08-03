//import the required libraries
import java.util.ArrayList;
import javax.swing.JOptionPane;


//
public class CheckinManager {
	
	private UtilityFileHelper helper;
	
	private ArrayList<String> raw_booking_data;
	private ArrayList<String> raw_flight_data;
	private final String BOOKING_DETAILS = "src/_bookings.csv"; //Absolute path to the csv file
	private final String FLIGHT_DETAILS = "src/_flights.csv";
			
	/**
	 * Main Entry method for the application
	 */
	public void run() {
		
		//Read CSV files, process them and store in data structures
		if (!processData()) return;  
		
		//Display check in console
		GUICheckIn _console = new GUICheckIn();
		_console.setVisible(true);
	}
	
	private boolean processData()
	{
		
		//READ THE CSV FILES AND STORE IT AS INTO A LIST (EMPTY LINES WILL BE IGNORED)
		raw_booking_data = helper.readCSV(BOOKING_DETAILS,true); //Read booking details as is
		raw_flight_data = helper.readCSV(FLIGHT_DETAILS,true); //Read flight details as is
		
		if (raw_booking_data == null || raw_flight_data == null) //If either of the lists are null, then raise an error message 
		{
			JOptionPane.showMessageDialog(null,"Unable to read the input files. Please check");
			return false;
		}
		
		//Process all lines in flight data.
		for (String flight_data : raw_flight_data) {
			helper.parseFlightDetail(flight_data);
		}
		

		
		
		//Process all lines in booking data
		for (String booking_data : raw_booking_data) {
			helper.parseBookingDetail(booking_data);
		}
		return true; //If all the above lines are passed, then return true.
	}
	
	
	/**
	 * To initiate properties
	 */
	private void initiation() {
		raw_booking_data = new ArrayList<String>();
		raw_flight_data = new ArrayList<String>();
		helper = new UtilityFileHelper();
	}
		
	public CheckinManager() {
		initiation();
	}
}
