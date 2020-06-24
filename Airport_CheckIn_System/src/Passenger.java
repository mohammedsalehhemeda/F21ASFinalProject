/**
 * This class to encapsulate all passengers' details
 * @author mohammedkhedr
 *
 */
public class Passenger {
    private String firstName;
    private String lastName;
    private String referenceNumber;
    private boolean checkedIn;

    public Passenger(String referenceNumber, String firstName, String lastName, boolean checkedIn){
        this.referenceNumber = referenceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkedIn = checkedIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return String.format(firstName + " " + lastName + " - " + (checkedIn?"Checked in" : "Not yet"));
    }
}
