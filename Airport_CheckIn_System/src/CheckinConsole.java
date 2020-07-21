import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import f21as.checkinsystem.models.*;

public class CheckinConsole extends JFrame implements ActionListener {

	private JPanel maincontent_pane,panel_checkdetails , panel_addbaggage,panel_left;
	private JTextField txt_booking_reference , txt_last_name, txt_height,  txt_width, txt_length, txt_weight;
	private JButton btn_clearscreen,btn_fetch_booking, btn_baggage_cancel,btn_baggage_calculatefee;
	private JTextArea txtarea_bookingdetails;
	private JLabel lblExcessFee;
	private CardLayout mainCard = new CardLayout(0,0);
	private final String CARD_BOOKINGS="card_checkdetails";
	private final String CARD_BAGGAGE="card_addbaggage";
	
	//Private variables for calculation
	private Booking current_booking;
	private Flight current_flight;
	private Baggage current_baggage;
	
		
	private void setupMainFrame() {
		setType(Type.UTILITY);
		setTitle("Airport Checkin Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 292);
		
		maincontent_pane = new JPanel();
		maincontent_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(maincontent_pane);
		maincontent_pane.setLayout(mainCard);
	}

	private void setupBookingsPanel() {
		panel_checkdetails = new JPanel();
		maincontent_pane.add(panel_checkdetails, CARD_BOOKINGS);
		panel_checkdetails.setLayout(new GridLayout(4,1));
		
		JPanel panel_1 = new JPanel();
		panel_checkdetails.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ENTER DETAILS TO FETCH BOOKING :");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_checkdetails.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblBookingReference = new JLabel("Booking Reference :");
		lblBookingReference.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblBookingReference);
		
		txt_booking_reference = new JTextField();
		panel_2.add(txt_booking_reference);
		txt_booking_reference.setColumns(30);
		
		JPanel panel_3 = new JPanel();
		panel_checkdetails.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblLastName);
		
		txt_last_name = new JTextField();
		panel_3.add(txt_last_name);
		txt_last_name.setColumns(36);
		
		JPanel panel_4 = new JPanel();
		panel_checkdetails.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5,5));
		
		btn_clearscreen = new JButton("CLEAR");
		btn_clearscreen.addActionListener(this);
		panel_4.add(btn_clearscreen);
		
		btn_fetch_booking = new JButton("FETCH");
		btn_fetch_booking.addActionListener(this);
		panel_4.add(btn_fetch_booking);
	}
	
	private void setupBaggagePanel() {

		panel_addbaggage = new JPanel();
		maincontent_pane.add(panel_addbaggage, CARD_BAGGAGE);
		panel_addbaggage.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_addbaggage.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEnterBaggageDetails = new JLabel("ENTER BAGGAGE DETAILS");
		lblEnterBaggageDetails.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEnterBaggageDetails, BorderLayout.SOUTH);
		lblEnterBaggageDetails.setForeground(Color.BLUE);
		lblEnterBaggageDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtarea_bookingdetails = new JTextArea();
		panel_4.add(txtarea_bookingdetails);
		
		JPanel panel_3 = new JPanel();
		panel_addbaggage.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_left = new JPanel();
		panel_3.add(panel_left);
		panel_left.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_left.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblHeightinCm = new JLabel("Height (in cm) :");
		panel_6.add(lblHeightinCm);
		
		txt_height = new JTextField();
		panel_6.add(txt_height);
		txt_height.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_left.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblWidthinCm = new JLabel("Width (in cm) :");
		panel_7.add(lblWidthinCm);
		
		txt_width = new JTextField();
		txt_width.setColumns(10);
		panel_7.add(txt_width);
		
		JPanel panel_8 = new JPanel();
		panel_left.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLengthinCm = new JLabel("Length (in cm) :");
		panel_8.add(lblLengthinCm);
		
		txt_length = new JTextField();
		txt_length.setColumns(10);
		panel_8.add(txt_length);
		
		JPanel panel_right = new JPanel();
		panel_3.add(panel_right);
		panel_right.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_weight = new JPanel();
		panel_right.add(panel_weight);
		panel_weight.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_weight.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblWeightinKg = new JLabel("Weight (in kg) :");
		panel_5.add(lblWeightinKg);
		
		txt_weight = new JTextField();
		panel_5.add(txt_weight);
		txt_weight.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_weight.add(panel_9, BorderLayout.CENTER);
		
		JLabel lblExcessFeeaed = new JLabel("Excess Fee (AED) : ");
		panel_9.add(lblExcessFeeaed);
		
		lblExcessFee = new JLabel("");
		lblExcessFee.setForeground(Color.RED);
		panel_9.add(lblExcessFee);
		
		JPanel panel = new JPanel();
		panel_right.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_baggage_cancel = new JButton("CANCEL");
		btn_baggage_cancel.addActionListener(this);
		panel.add(btn_baggage_cancel);
		
		btn_baggage_calculatefee = new JButton("CALCULATE");
		btn_baggage_calculatefee.addActionListener(this);
		btn_baggage_calculatefee.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel.add(btn_baggage_calculatefee);
	}
	
	private void clearScreen() {
		txt_booking_reference.setText("");
		txt_last_name.setText("");
		txt_height.setText("");
		txt_length.setText("");
		txt_width.setText("");
		lblExcessFee.setText("");
		txt_weight.setText("");
	}
	
	private void fetchDetails() {
		//Fetch details if present and go to baggage screen
		Booking _booking = BookingManager.getBooking(txt_booking_reference.getText());
		if (_booking == null)
		{
			JOptionPane.showMessageDialog(null, "Booking reference doesn't exist. Please retry");
			return;
		}
		
		/*
		String lname = _booking.getPassenger().getLastName();
		if (!lname.equals(txt_last_name.getText()))
		{
			JOptionPane.showMessageDialog(null, "Last name doesn't correspond to the booking reference. Please retry with correct last name.");
			return;
		}
		*/
	
		String fcode = _booking.getFlightCode();
		current_booking = _booking;
		current_flight= BookingManager.getFlight(fcode);

		
		String booking_details = current_booking.getBookingDetails();
		booking_details += current_flight.getDestination();
	    txtarea_bookingdetails.setText(booking_details);
	    
	    if (_booking.getCheckinStatus()) btn_baggage_calculatefee.setEnabled(false);
	    
	  //Go to Baggage card
	    mainCard.show(maincontent_pane,CARD_BAGGAGE);
	}
	
	private void baggage_cancel() {
		//Clear screen and go back to first screen.
		clearScreen();
		mainCard.show(maincontent_pane, CARD_BOOKINGS);
		
	}
	
	private void calculateFee() {
	//Calculate fee if values are correct else return error.
		try {
			Double _height = Double.parseDouble(txt_height.getText());
			Double _weight = Double.parseDouble(txt_weight.getText());
			Double _width = Double.parseDouble(txt_width.getText());
			Double _length = Double.parseDouble(txt_length.getText());
			
			Baggage  _baggage = new Baggage(_length, _width, _height, _weight);
			Double _excess_fee = _baggage.calcuateExcessFee(current_flight.getMaxBaggageWeight(), current_flight.getExcessFeePerKg());
			lblExcessFee.setText(_excess_fee.toString());
			
			Double _current_volume = _baggage.getVolume();
			Double _allowed_volume = current_flight.getMaxBaggageVolume();
			
			if (_current_volume > _allowed_volume)
			{
				String volume_message = "Allowed luggage volume for this flight is :" + _allowed_volume + " cu.m"+ "\n";
				volume_message += "Your luggage volume is " + _current_volume + " cu.m" + "\n";
				volume_message += "You cannot check in this luggage";
				JOptionPane.showMessageDialog(null, volume_message);
				return;
			}
			
			current_baggage = _baggage; //Setup current baggage to check in
			
			String message = "You have an excess baggage fee of "+ _excess_fee + " AED." + "\n";
			message += "Do you wish to check in now?";
			int check_in = JOptionPane.showConfirmDialog(null, message);
			
			if (check_in == JOptionPane.YES_OPTION)
			{
				current_baggage.setExcessFee(_excess_fee);
				checkin();
				generateReport();
				JOptionPane.showMessageDialog(null, "Check in succesful and report is generated..");
				baggage_cancel();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Check in not done.");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter only numerical values");
		}
		
	}
	
	private void checkin()
	{
		//We have already set up the current baggage above.
		
		BookingManager.getBooking(current_booking.getReference()).setBaggage(current_baggage);
		BookingManager.getBooking(current_booking.getReference()).updateCheckinStatus(true);
		
		JOptionPane.showMessageDialog(null, BookingManager.getBooking(current_booking.getReference()).getBookingDetails());
	}
	
	private void generateReport() {
		
		String _final_report = BookingManager.getReport();
		UtilityFileHelper helper = new UtilityFileHelper();
		helper.writeReport("GeneratedReport.txt", _final_report);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_clearscreen) {
			clearScreen();
	  	}
	  	else if (e.getSource() == btn_fetch_booking) {
	  		fetchDetails();
	  	
	  	}
	  	else if (e.getSource() == btn_baggage_cancel) {
	  		baggage_cancel();
	  	}
	  	else if (e.getSource() == btn_baggage_calculatefee) {
	  		calculateFee();
	  	}
	}

	public CheckinConsole() {
		setupMainFrame();
		setupBookingsPanel();
		setupBaggagePanel();
		setVisible(true);
	}
}
