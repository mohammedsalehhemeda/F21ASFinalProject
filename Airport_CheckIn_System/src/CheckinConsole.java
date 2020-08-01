import java.awt.*;
import javax.swing.*;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import f21as.checkinsystem.models.*;

public class CheckinConsole extends JFrame {
	private JPanel maincontent_pane, panel_queuedetails, panel_2, panel_3;
	private JTextArea displaylist, flight_1, flight_2, flight_3;
	private CardLayout mainCard = new CardLayout(0, 0);
	private JScrollPane scrollList;
	private Iterator<Booking> iter;
	private PassengerQueue q = PassengerQueue.getInstance();
	private CheckinManager chkInManager = new CheckinManager();
	private Queue queue_1;

	//
	private void setupMainFrame() {
		setType(Type.UTILITY);
		setTitle("Airport Checkin Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 500, 500);

		maincontent_pane = new JPanel();
		maincontent_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(maincontent_pane);
		maincontent_pane.setLayout(mainCard);
	}

	private void GUInterface() {
		// This panel for displaying queue updates
		panel_queuedetails = new JPanel();
		maincontent_pane.add(panel_queuedetails);
		JLabel lblNewLabel = new JLabel("Waiting Queue :");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_queuedetails.add(lblNewLabel);
		panel_queuedetails.setLayout(new FlowLayout(FlowLayout.LEFT));
		displaylist = new JTextArea(20, 70);
		displaylist.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		displaylist.setEditable(false);
		scrollList = new JScrollPane(panel_queuedetails, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollList.add(displaylist);
		panel_queuedetails.add(displaylist);
		getContentPane().add(scrollList);

		// Panel2 for displaying Desk1 and Desk2 updates
		panel_2 = new JPanel();
		panel_queuedetails.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT));

		JTextArea desk1_result = new JTextArea(10, 60);
		desk1_result.setEditable(false);
		panel_2.add(desk1_result);

		JTextArea desk2_result = new JTextArea(10, 60);
		desk2_result.setEditable(false);
		panel_2.add(desk2_result);

		// Panel3 for displaying updates on the flights
		panel_3 = new JPanel();
		panel_queuedetails.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JTextArea flight_1;
		JTextArea flight_2;
		JTextArea flight_3;
		flight_1 = new JTextArea(10, 40);
		flight_1.setEditable(false);
		panel_3.add(flight_1);
		flight_2 = new JTextArea(10, 40);
		flight_2.setEditable(false);
		panel_3.add(flight_2);
		flight_3 = new JTextArea(10, 40);
		flight_3.setEditable(false);
		panel_3.add(flight_3);

		queue_1 = new Queue();
		Thread que1 = new Thread(queue_1);
		que1.start();

//		try {
//			que1.join();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		System.out.println("Desk 1 start");

		desk1_result.append("Desk 1:\n");
		Desks desk_1 = new Desks(desk1_result);
		Thread d1 = new Thread(desk_1);
		d1.start();

		desk2_result.append("Desk 2:\n");
		Desks desk_2 = new Desks(desk2_result);
		Thread d2 = new Thread(desk_2);
		d2.start();
		
	}

	private class Queue implements Runnable {

		public void run() {
			System.out.println("Starting thread..." + Thread.currentThread().getName());

			while (true) {
				displaylist.setText("");
				iter = PassengerQueue.ReadQueue().iterator();

				if (iter == null) {
					System.out.println(
							"Queue is empty. No more passengers to proceed..." + Thread.currentThread().getName());
					continue;
				}

				try {
					while (iter.hasNext()) {
						Booking bookingDetails = (Booking) iter.next();
						displaylist.append(bookingDetails.getBookingDetails());
						// iter.remove(); // TODO .. only for display, shouldn't remove items.
					}
				} catch (Exception e) {
					continue;
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				System.out.println("Completing thread..." + Thread.currentThread().getName());
			}
		}
	}

	private class Desks implements Runnable {

//		String[] flightNumber = new String[]{"Flight-1", "Flight-2", "Flight-3"}; // TODO .. Should be replaced with flight name and code from another class
		
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

				Booking bookingDetails = queue.poll();
				desk.append(bookingDetails.getBookingDetails());

//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
				
//				Random r = new Random();
//				System.out.println(FlightMap.assignToFlight(flightNumber[Math.abs(r.nextInt())%3])); // TODO .. to be updated
			}
		}
	}

	public CheckinConsole() {
		setupMainFrame();
		GUInterface();
		setVisible(true);

	}
}