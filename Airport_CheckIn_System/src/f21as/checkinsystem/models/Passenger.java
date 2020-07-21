package f21as.checkinsystem.models;
/**
 * This class to encapsulate all passengers' details
 * @author mohammedkhedr
 *
 */
public class Passenger {
    private String fullName;
    private String referenceNumber;
    private boolean checkedIn;

    public Passenger(String referenceNumber, String fullName, boolean checkedIn){
        this.referenceNumber = referenceNumber;
        this.fullName = fullName;
        this.checkedIn = checkedIn;
    }

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
