package cw2;

public class bookingDetails {
    String bookingReference;			
    String flightCode;
    String passengerName;
    String checkinStatus;

    public bookingDetails(String bookingReference, String flightCode, String passengerName, String checkinStatus) {
        this.bookingReference = bookingReference;
        this.flightCode = flightCode;
        this.passengerName = passengerName;
        this.checkinStatus = checkinStatus;
    }

    public String getBooking() {
        return bookingReference;
    }
    
    public String getName() {
        return passengerName;
    }

    //more get and set methods here. I have only included what is needed for my answer
}