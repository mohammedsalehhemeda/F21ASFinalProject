import javax.swing.JTextArea;

import f21as.checkinsystem.models.Booking;

 class AirLines implements Runnable {  //This method for displaying passengers on Desks windows
		
		private final JTextArea airline;

		public AirLines(JTextArea airline) {
			this.airline = airline;
		}

		public void run() {
			System.out.println("Starting thread..." + Thread.currentThread().getName());

			java.util.Queue<Booking> queue = PassengerQueue.ReadQueue();
			while (true) {
				if (queue.isEmpty()) {

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					continue;
				}

				
				long globalStartTime = System.nanoTime();
			    float currentTime = 0;
			    while ( currentTime < 5.5){
			         currentTime = (System.nanoTime() - globalStartTime) /  1000000000f;
			        System.out.println(currentTime);
			    }
				if(currentTime >5.5) {
					Booking bookingDetails = queue.poll();
//					String joined = String.join("\n", FlightMap.getSetOfFlightCodes(bookingDetails.getFlightCode()));
					airline.append(bookingDetails.getFlightCode()+"---"+FlightMap.getNumberOfPassengers(bookingDetails.getFlightCode()));
	//				
					}
//					airline.append(joined);
	//				System.out.println(joined);
					
			}}}