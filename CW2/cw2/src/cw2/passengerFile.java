package cw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class passengerFile {

	String csvFile = "D:\\cw2\\_bookings.csv";
	String line = "";
	String cvsSplitBy = ",";
    List<String> passengers = new ArrayList<>();
    
	bookingDetails pd = new bookingDetails("ss","ss","ss","ss");
	
		public void readFile1()
		{
			
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        while ((line = br.readLine()) != null) {
        	
            // use comma as separator
            String[] passengerDetails = line.split(cvsSplitBy);
       
          
            bookingDetails pd = new bookingDetails(passengerDetails[0], passengerDetails[1], passengerDetails[2], passengerDetails[3]);
            String x = passengerDetails[0];
            
            System.out.println(x);
            
            
    	   // list = passengerDetails[2];
          //  System.out.println(list);

        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
	

	





