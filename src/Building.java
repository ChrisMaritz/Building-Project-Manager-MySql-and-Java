import java.util.Scanner;

public class Building {
	
	//Attributes
	//All the variables up to deadline is what will be the Building object constructers values.
	//custumrName, contrName, architName are all objects created in other object contructer and there purpose will be further explained.
	
	String projectNum;
	String projectName;
	String buildingType;
	String projectAddress;
	String erfNum;
	Integer totalFee;
	Integer paidToDate;
	String deadline;
	Customer customrName;
	Contracter contrName;
	Architect architName;
	
	//Methods
	//Creating object constructer;
	//Each parameter entered when the object contructer is called will be the equal value for the variables of the information of the Building object.
	
	public Building(String projectNum, String projectName, String buildingType, String projectAddress, String erfNum, Integer totalFee, Integer paidToDate, String deadline) {
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.erfNum = erfNum;
		this.totalFee = totalFee;
		this.paidToDate = paidToDate;
		this.deadline = deadline;
	}
	
	//Creating a Method which will operate as changing the deadline, this will be called in Edit object to edit the deadline;
	
	public void changeDueDate() {
		
		//Creating new Scanner
		//The user is the prompted with what the new Due date is.
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is new due date?\n");
		
		//The users input is the saved to the variable deadline.
		
		this.deadline = input.nextLine();
		
	}
	
	//Creating a Method which will operate in change the paidToDate variable and will be called in the Edit object.
	
	public void changePaidToDate() {
		
		//Creating new Scanner
		//The user is the prompted with how much has been paid so far
		
		Scanner input = new Scanner(System.in);
		System.out.println("How much has been paid?\n");
		
		//The variable paidToDate is then equal to the input.
		
		this.paidToDate = input.nextInt();
	}
	
	//This function callCustomerObject() served as a purpose to have the variable customrName equal to the parameter.
	//The parameter would be a Customer object.
	//This allows the Customer object to be used with ease within this Building object.
	
	public void callCustomerObject(Customer name) {
		this.customrName = name;
	}
	
	//This function callArchitectObject() served as a purpose to have the variable contrName equal to the parameter.
	//The parameter would be a Contracter object.
	//This allows the contracter object to be used with ease within this Building object.
	
	public void callArchitectObject(Architect name) {		
		this.architName = name;
	}
	
	//This function callContraObject() served as a purpose to have the variable contrName equal to the parameter.
	//The parameter would be a Contracter object.
	//This allows the contracter object to be used with ease within this Building object.
	
	public void callContraObject(Contracter name) {
		this.contrName = name;
	}
		
	//Creating Method to turn all the information in a String in the appropriate format
	
	public String toString() {
		
		//A string variable called output is created
		//output is the equal to all the needed information to display the buildings details in an appropriate manner.
		//each added info is the variable declared at the beginning of the object.
		
		String output = "Project number: " + projectNum;
		output += "\nproject Name: " + projectName;
		output += "\nBuilding Type: " + buildingType; 
		output += "\nProject Address: " + projectAddress;
		output+= "\nTotal fee: " + totalFee;
		output += "\nERF Number: " + erfNum;
		output+= "\nPaid so far: " + paidToDate;
		output += "\nDeadline: " + deadline + "\n";
		
		//Each object toString() method is then called thus displaying the customer,contracter as well as the architects information
		
		output += customrName.toString();
		output += contrName.toString();
		output += architName.toString();
		
		//It is then return allowing the user to print it if needed by calling the function.
		
		return output;
	}
	
	//Creating a Method to finalize the project and create an invoice
	//If this function is called it will also function as to finalize the building project.
	
	public String finalized() {
		
		//Creating a String array which is equal to the function of contactDets() on a customer object
		//contactDets() will create an array which stored the customers contact details
		
		String[] contact = customrName.contactDets();
		
		//A string is created called finalized which is then equal to needed information to create an invoice.
		
		String finalized = "Invoice";
		
		//One can see here how the array contact is used to output the information of the customer for the invoice
		
		finalized += "\nCustomer " + contact[1] + " phone number: " + contact[0];
		finalized += "\nCustomer " + contact[1] + " email: " + contact[2]; 
		
		//The total amount to be paid is calculated by minus the total fee by what has been paid so far.
		
		finalized += "\nTotal amount: " + (totalFee - paidToDate);
		finalized += "\nFinalized: Yes\n";
		
		//The invoice is then return so it can be printed.
		
		return finalized;
	}
	}