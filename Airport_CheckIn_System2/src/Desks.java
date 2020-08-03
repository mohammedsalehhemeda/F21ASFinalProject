import javax.swing.JTextArea;

import f21as.checkinsystem.models.Booking;

class Desks implements Runnable {  //This method for displaying passengers on Desks windows
		
		private final JTextArea desk;

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
				
				long globalStartTime = System.nanoTime();
			    float currentTime = 0;
			    while ( currentTime < 5.5){
			         currentTime = (System.nanoTime() - globalStartTime) /  1000000000f;
			        System.out.println(currentTime);
			    }
				if(currentTime >5.5) {
				Booking bookingDetails = queue.poll();
					desk.append(bookingDetails.getBookingDetails()); 
				}
					}
		}
	}
