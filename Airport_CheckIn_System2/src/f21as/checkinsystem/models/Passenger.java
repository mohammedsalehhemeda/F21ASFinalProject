//used under the following package

package f21as.checkinsystem.models;
//this class to help identifying the passengers details

/**
 * This class to encapsulate all passengers' details
 * @author mohammedkhedr
 *
 */
public class Passenger {
	
	//declare the variables for the passenger details

    private String fullName;
    private String referenceNumber;
    private boolean checkedIn;

	//declare the constructor of the passenger to create objects from it

    public Passenger(String referenceNumber, String fullName, boolean checkedIn){
        this.referenceNumber = referenceNumber;
        this.fullName = fullName;
        this.checkedIn = checkedIn;
    }

    //getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFirstName(String fullName) {
        this.fullName = fullName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
    @Override
    public String toString() {
        return String.format(fullName + " - " + (checkedIn?"Checked in" : "Not yet"));
    }
    
}
