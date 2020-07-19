package f21as.checkinsystem.models;
/**
 * Construct and hold information relate to the person name. Names can have first, last and middle name.
 * This class also provides different methods for fetching required information such as initials and different combination of names.
 * @author SenguttuvanMahalingam
 *
 */
public class Passenger {

	//region Variables
	private String first_name;
	private String middle_name;
	private String last_name;
	
	//region Constructors
		/**
		 * This is a "Name" object constructor with three available parameters
		 * @param _first_name First name of the person
		 * @param _middle_name Middle name of the person
		 * @param _last_name Last name of the person
		 */
		public Passenger(String _first_name, String _middle_name, String _last_name) {
			first_name = _first_name;
			middle_name = _middle_name;
			last_name = _last_name;
		}
		
		/**
		 * This constructor to be used if middle name is not present.
		 * @param _first_name First name of the person
		 * @param _last_name Last name of the person
		 */
		public Passenger(String _first_name,String _last_name) {
			first_name = _first_name;
			middle_name = null;
			last_name = _last_name;
		}
		
		/**
		 * This constructor to be used if the full name of the person is provided as input.
		 * If the names has space in between them, then the names will be automatically formatted and split in to first, middle and last names.
		 * @param full_name Full name of the person (space between first,middle and last names)
		 */
		public Passenger(String _full_name) {
			
			
			String trimmed_full_name = _full_name.trim();
			
			int first_space_position = trimmed_full_name.indexOf(' ');
			int last_space_position = trimmed_full_name.lastIndexOf(' ');
			
			if (first_space_position == -1)  
			{
				first_name = trimmed_full_name;
			}
			
			else 
			{
				
				first_name = trimmed_full_name.substring(0,first_space_position);
				
				//In case the position of first and last space are same, then it indicates that the middlename is not present
				if (first_space_position == last_space_position) 
				{
					middle_name = null;
				}
				else
				{
					//Get the middle name and also trim it to ensure that there are not double space typo present
					middle_name = trimmed_full_name.substring(first_space_position+1,last_space_position).trim(); 
				}
				
				last_name = trimmed_full_name.substring(last_space_position+1);
			}
		}
	
	//region Methods
	
		/**
		 * Gets the first name of the person
		 * @return First Name
		 */
	public String getFirstName() {
		return first_name;
	}
	
	/**
	 * Gets the last name of the person
	 * @return Last Name (if present). 
	 * @exception NullPointerException : if the last name is not present for the user
	 */
	public String getLastName() {
		return last_name;
	}
	

	/**
	 * Gets the Last and First name of the person in specified format
	 * @param use_comma_delimiter True: If a comma(",") is to be added between the names. False: If comma is not required
	 * @return Last and First name of the Person with/without a comma inbetween them. Ex; LastName , FirstName
	 */
	public String getLastAndFirstName(boolean use_comma_delimiter) {
		String delimiter = " ";
		if (use_comma_delimiter) delimiter = ", ";
		return last_name + delimiter + first_name;
	}
	
	/**
	 * Gets the Initial (first letter of last name) followed by first name
	 * @return Initial followed by the first name. Ex: M Senguttuvan
	 * 
	 */
	public String getLastInitialAndFirstName()
	{
		//In case last name is not present, then return just the first name.
		if (!isNamePresent(last_name)) return first_name;
		String lastname_initial = getInitials(last_name, true);
		return lastname_initial + first_name; //Not adding space inbetween, because it returned by the getinitials method
	}
	
	/**
	 * Gets the Full name of the person
	 * @return Full Name of the person with space between the names.(Middle name is ommitted if not present) Ex: FirstName MiddleName LastName
	 */
	public String getFullName() {
		String _fullName = first_name + " ";
		if (isNamePresent(middle_name))_fullName+= middle_name+ " ";
		if (isNamePresent(last_name)) _fullName+= last_name;
		
		return _fullName;
	}
		
	/***
	 * Gets the initials of the person in desired format
	 * @param include_spaces True: Includes space between the Initials. False: No space between initials
	 * @return Initials (or first letter of each names) with/without spaces between them
	 */
	public String getFullInitials(boolean include_spaces) {
		String result = getInitials(first_name,include_spaces);
		//For below two steps, we need not check if the get initials will return null or not because, we invoke the method
		//only after verifying if a name (middle or last) is present.
		if (isNamePresent(middle_name)) result+=getInitials(middle_name,include_spaces);
		if (isNamePresent(last_name)) result+=getInitials(last_name,false);
		
		//Reason for trimming result is that, in case the last name and middle name are not present, then we are returning
		//first name along with an empty space at the end. So it will remove that.
		return result.trim(); 
	}
	
	/**
	 * Gets the initial (first letter) of the provided name
	 * @param input_name Name from which the initial has to be derived
	 * @param add_space_at_end True: A space " " will be added after the initial False: Space will be omitted
	 * @return Initial of the person with/without space at the end
	 */
	private String getInitials(String input_name, boolean add_space_at_end) {
		//Initiate initial with null value or empty value
		String _initial = null;
		if (input_name.length()>0)
		{
			_initial = input_name.substring(0,1); //Get the first digit of the provided input name
			if (add_space_at_end)_initial += " "; //In case a space is required at end.
		}
		return _initial;
	}
	

	private static boolean isNamePresent(String input_name)
	{
		if (input_name == null || input_name.equals("") || input_name.isEmpty()) return false;
		return true;
	}
	
	/***
	 * Checks if the provided string is empty,null or has "" value.
	 * @param input_name Name (string) which has to be checked
	 * @return True: If the string is not empty or null. False: If the string is empty or null
	 */
	public static boolean isValidName(String input_name) {
		if (!Passenger.isNamePresent(input_name)) return false;
		
		String trimmed_full_name = input_name.trim();
		
		int first_space_position = trimmed_full_name.indexOf(' ');
		if (first_space_position == -1)  //This indicates that only one part of name is provided. We need first name and last name separated by space for processing.
		{
			return false; 
		}
		return true;
	}
	
	@Override
    public String toString() {
        return String.format(first_name + " " + last_name + " - " );
    }
}
