
public class Customer {
	
	//Attributes
	//All this attributes are made to hold the customers details.
			
	String name;
	String phoneNum;
	String email;
	String physiAddress;
	String projectNum;
		
	//Methods
	//Creating object constructer.
	//Each parameter entered will be what the attributes will be equal to.
			
	public Customer(String name, String phoneNum, String email, String physiAddress, String projectNum) {
		
		//Here it can be seen with the use of the this. keyword the attributes are equal to the parameters put in.
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}
	
	//Returning all the values as a String for display purposes.
	
	public String toString() {
		
		//A string variable output is created with the needed format for each details of the customer.
		//each needed bit info is the info that was created in the object constructer.
		
		String output = "\nCustomer for project number " + projectNum;
		output += "\nPhonenumber: " + phoneNum;
		output += "\nEmail: " + email;
		output += "\nPhysical Address: " + physiAddress + "\n";
		
		//The output is returned so it can be printed if needed
		
		return output;
		}
	
	//Creating a method which will return the customers contact Details.
	//This method is returned as an array; the use of this can be seen in Building.java
	
	public String[] contactDets() {
		
		//each string item is equal to the items created in the object constructer.
		
		String[] contact = {this.phoneNum, this.email, this.name};
		
		//The array is returned so it can be used in Building.java
		
		return contact;
	}
}
