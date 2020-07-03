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
    int counter;
	bookingDetails pd = new bookingDetails("ss","ss","ss","ss");
    String[] passengerNames;
	ArrayList<String> name1 = new ArrayList<String>();

		public void readFile1()
		{
			
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		
            while ((line = br.readLine()) != null) {
        	
            // use comma as separator
            String[] passengerDetails = line.split(cvsSplitBy);
            bookingDetails pd = new bookingDetails(passengerDetails[0], passengerDetails[1], passengerDetails[2], passengerDetails[3]);

//            ArrayList<String> names = new ArrayList<String>();
            name1.add(passengerDetails[2]);
            
            
//            
//			passengerNames[counter]=passengerDetails[2];
//            
//            for(counter = 0; counter<passengerDetails[2].length(); counter++ )
//            System.out.println(passengerNames[counter]);
//            
            
    	   // list = passengerDetails[2];
          //  System.out.println(list);

        }
            
    } catch (IOException e) {
        e.printStackTrace();
    }

        System.out.println(name1.get(3));

}
}
	

	





