//This is the airlines class
//The class is to send the flights data to the GUI

//import the required libraries
import javax.swing.JTextArea;
import f21as.checkinsystem.models.Booking;

//create the class and implement runnable interface 
 class AirLines implements Runnable { 
		
	 
	//declare an object from the JTextArea class and call it airline
	 	private final JTextArea airline;
	
	//declare the constructor 
	 	public AirLines(JTextArea airline) {
			this.airline = airline;
		}

	 	
	//declare the run method
		public void run() {
			
			//print "Starting thread..." and the name of the running thread in the program
			System.out.println("Starting thread..." + Thread.currentThread().getName());
			
			//save the queue of the passenger in Booking object
			java.util.Queue<Booking> queue = PassengerQueue.ReadQueue();
			
			//this while used to run the code until we display all airlines to the GUI
			while (true) {
				
				//if the queue finished the console will freeze for 10 seconds, this can be removed, it has been added to check the runtime errors of the thread and catch them inside try/catch 
				if (queue.isEmpty()) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					continue;
				}

		//to run the queue object by object, a timer of 5.5 seconds between each object 
		//System.nanoTime() has been used, the following code is to restart the timer each 5.5 seconde
		//here you can change the simulation time of the queue implementation 
				
				long globalStartTime = System.nanoTime();
			    float currentTime = 0;
			    while ( currentTime < 5.5){
			         currentTime = (System.nanoTime() - globalStartTime) /  1000000000f;
				       //display the timer on the console display

			        System.out.println(currentTime);
			    }
				//display the objects of the airlines details each 5.5 seconds on the GUI 

				if(currentTime >5.5) {
					Booking bookingDetails = queue.poll();
					airline.append(bookingDetails.getFlightCode()+"---"+FlightMap.getNumberOfPassengers(bookingDetails.getFlightCode()));
					}
					
			}}}