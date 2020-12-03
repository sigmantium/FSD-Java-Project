package backend;
import java.util.Scanner;

public class Registration {
	
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String setUsername;
	private String setPassword;
	
	// Constructor
	public Registration( String firstName, String lastName, String address, String phoneNumber, String emailAddress, String setUsername, String setPassword) {

			
			System.out.print("First Name: ");
			setFirstName(firstName);
			
			System.out.print("Last Name: ");
			setLastName(lastName);
			
			System.out.print("Address: ");
			setAddress(address);
			
			System.out.print("Phone: ");
			setPhoneNumber(phoneNumber);
			
			System.out.print("Email: ");
			setEmailAddress(emailAddress);
			
			System.out.print("Set Username: ");
			setSetUsername(setUsername);
			
			System.out.print("Set a Password (Must have at least 8 characters and one number): ");
			setSetPassword(setPassword);
			}
	
	// Getters and Setters
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSetUsername() {
		return setUsername;
	}
	public void setSetUsername(String setUsername) {
		this.setUsername = setUsername;
	}
	public String getSetPassword() {
		return setPassword;
	}
	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword; }
	
	
	//This will validate the password.
	//This will make sure that the password has more than 8 characters. 
		
	public static Boolean ValPassword(String Password) 
	{  

		if (Password.length() <= 8) 
		{
			System.out.println("Password is not long enough, must be between 8 and 16 characters.");
			return false;	    	
		} 

		if (Password.length() > 16) 
		{
			System.out.println("Password is too long");
			return false;	    	
		} 
		boolean numberPass = false;
		for(int i = 0; i < Password.length(); i++) {
			if(Character.isDigit(Password.charAt(i))) {
				numberPass = true;
				break;
			}
		}
		if(numberPass == false) {
			System.out.println("Password must contain a number.");
			return false;	 			
		}
		
		return true;
	}
}

	    	
	

            
            
          
            	
 
  
           
      
            
    


	