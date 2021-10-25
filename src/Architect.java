
public class Architect {

	//Attributes
	//Each attribute is used to store the information of the Architect.
	
	String name;
	String phoneNum;
	String email;
	String physiAddress;
	String projectNum;
	
	//Methods
	//Creating object constructer.
	//Each parameter entered will be what the attributes will be equal to.
	
	public Architect(String name, String phoneNum, String email, String physiAddress, String projectNum) {
		
		//Here it can be seen with the use of the this. keyword the attributes are equal to the parameters put in.
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}
	
	//Returning all the values as a String for display purposes.
	
	public String toString() {
		
		//A string variable output is created with the needed format for each details of the Architect.
		//each needed bit info is the info that was created in the object constructer.
		
		String output = "Architect for project number " + projectNum;
		output += "\nPhonenumber: " + phoneNum;
		output += "\nEmail: " + email;
		output += "\nPhysical Address: " + physiAddress + "\n";
		
		//It is then returned so that it can be printed if needed
		
		return output;
	}
	
}
