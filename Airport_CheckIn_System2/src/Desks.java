import javax.swing.JTextArea;

import f21as.checkinsystem.models.Booking;

class Desks  implements Runnable  {  //This method for displaying passengers on Desks windows
		
		private final JTextArea desk;
		private JTextArea airline;
		
		public Desks(JTextArea desk) {
			this.desk = desk;
	
		}

		
		

	
		
		
		
		public void run() {
			System.out.println("Starting thread..." + Thread.currentThread().getName());

			java.util.Queue<Booking> queue = PassengerQueue.ReadQueue();
			while (true) {
				if (queue.isEmpty()) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					continue;
					
					
				}
				
				//to run the queue object by object, a timer of 5.5 seconds between each object 
				//System.nanoTime() has been used, the following code is to restart the timer each 5.5 seconds
				//here you can change the simulation time of the queue implementation 
				
				long globalStartTime = System.nanoTime();
			    float currentTime = 0;
			    while ( currentTime < 5.5){
			         currentTime = (System.nanoTime() - globalStartTime) /  1000000000f;
			       //display the timer on the console display
			         System.out.println(currentTime);
			    }
				if(currentTime >5.5) {
					
					//display the objects of the booking details each 5.5 seconds on the GUI 
					Booking bookingDetails = queue.poll();
					desk.append(bookingDetails.getBookingDetails()+"---"+bookingDetails.getFlightCode()+"\n"); 

				}
					}
		}
	}
