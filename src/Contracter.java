import java.util.Scanner;

public class Contracter {
	
	//Attributes
	//Each attribute is used to store the information of the contracter.
		
	String name;
	String phoneNum;
	String email;
	String physiAddress;
	String projectNum;
	
	//Methods
	//Creating object constructer.
	//Each parameter entered will be what the attributes will be equal to.
		
	public Contracter(String name, String phoneNum, String email, String physiAddress, String projectNum) {
		
		//Here it can be seen with the use of the this. keyword the attributes are equal to the parameters put in.
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}
	
	//Returning all the values as a String for display purposes.
	
	public String toString() {
		
		//A string variable output is created with the needed format for each details of the contracter.
		//each needed bit info is the info that was created in the object constructer.
		
		String output = "Contracter for project number " + projectNum;
		output += "\nPhonenumber: " + phoneNum;
		output += "\nEmail: " + email;
		output += "\nPhysical Address: " + physiAddress + "\n";
		
		//It is then returned so it can be printed for later uses
		
		return output;
		}
	
	//This Method functions as changing the details of the details of the constructer if needed; this will be called in the Edit object
	
	public void editContr() {
		
		//A new scanner is created
		//The user is then prompted with what the new phone number needed would be.
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is the new phone number?\n");
		
		//The phoneNum attribute is then equal to the users input.
		
		this.phoneNum = input.nextLine();
		
		//The same is then done but just with asking for a new email.
		
		System.out.println("What is the new email?\n");
		this.email = input.nextLine();
	}
}
