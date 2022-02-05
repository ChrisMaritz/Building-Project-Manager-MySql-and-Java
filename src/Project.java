import java.sql.SQLException;
import java.util.Scanner;

/**
 * This is the main method class
 * @author Christiann Rudolf Maritz
 *
 */

public class Project {
	
	/**
	 * This is the main method
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		/*
		*The user is welcomed the the program
		*/
		
		System.out.println("Welcome");
	
		/*
		*A new Scanner object is created
		*The user is then prompted with wether they want to enter the building project or not.
		*If they choose not to the program will be exited.
		*the answer is then stored in create.
		*/
		
		Scanner input = new Scanner(System.in);
		Scanner inputDouble = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		System.out.println("\nWould you like to create a project(Enter 'Yes' or 'No')?");
		String create = input.nextLine();
		
		/*
		*if create is equal to "Yes" the program will run
		*/
		
		if(create.toLowerCase().equals("yes")) {
		
			/*
			*The user is then asks for each details of the project
			*And then the information is stored in a variable with each prompt.
			*/
			
			System.out.println("What is the project number?\n");
			String projectNum = input.nextLine();
			System.out.println("What is the projects name?\n");
			String projectName = input.nextLine();
			System.out.println("What is the building type?\n");
			String buildingType = input.nextLine();
			System.out.println("What is the project Address?\n");
			String projectAddress = input.nextLine();
			System.out.println("What is the ERF number?\n");
			int erfNum = inputInt.nextInt();
			
			/*
			*The Scanner is restated as we are calling integers now.
			*This was suggested by a user in the discord server.
			*/
			
			System.out.println("What is the total fee?\n");
			String totalFee = input.nextLine();
			
			/*
			 * Creating a new double 
			 *This is to make sure a digit was entered and not a word
			 */

			double totalFee2 = 0.0;
			
			/*
			*A try catch block to check if the user put in a double correctly
			*If it fails it will print an error to show what the user has done wrong
			*/
			
			boolean tOrF = false;
			
			while(tOrF == false) {
				try {
					System.out.println("What is the total fee?\n");		
					totalFee2 =inputInt.nextDouble();
					tOrF = true;
				}catch(NumberFormatException e) {
					System.out.println("Are you sure you entered a number(decimal place is a . not , As well as not an R?");
					tOrF = false;
				}
			}
			
			/*
			 * Creating a new double
			 *This is to make sure a digit was entered and not a word
			 */
			
			double paidToDate2 = 0.0;
			
			/*
			*A try catch block to check if the user put in a double correctly
			*If it fails it will print an error to show what the user has done wrong
			*/
			
			tOrF = false;
			
			while(tOrF == false) {
				try {
					System.out.println("What is the amount paid so far?\n");		
					paidToDate2 =inputInt.nextDouble();
					tOrF = true;
				}catch(NumberFormatException e) {
					System.out.println("Are you sure you entered a number(decimal place is a . not , As well as not an R?");
					tOrF = false;
				}
			}
			
			/*
			*The next input is applied
			*/
			
			System.out.println("When is the project due(format (2021-03-22), (yyyy-mm-dd))?\n");
			String deadline = input.nextLine();
			
			/*
			*The user is then prompted to enter the Customers details.
			*It is then stored in a variable again with each detail.
			*/
			
			System.out.println("What is the customers first name?\n");
			String custumrName = input.nextLine();
			System.out.println("What is the customers surname?\n");
			String custumrSurname = input.nextLine();
			System.out.println("What is the Customers phone number?\n");
			String custumrPhone = input.nextLine();
			System.out.println("What is the customers email?\n");
			String custumrEmail = input.nextLine();
			System.out.println("What is the customers physical address?\n");
			String custumrAddress = input.nextLine();
			
			/*
			*The customer object is then created and each needed information put in by the user is entered.
			*/
			
			Customer customer = new Customer(custumrName,custumrSurname, custumrPhone, custumrEmail, custumrAddress, projectNum);
			
			/*
			*The user is then prompted to enter the Architects details.
			*It is then stored in a variable again with each detail.
			*/
			
			System.out.println("What is the Architects full name?\n");
			String archiName = input.nextLine();
			System.out.println("What is the Architects phone number?\n");
			String archiPhone = input.nextLine();
			System.out.println("What is the Architects email?\n");
			String archiEmail = input.nextLine();
			System.out.println("What is the Architects physical address?\n");
			String archiAddress = input.nextLine();
			
			/*
			*The Architect object is then created and each needed information put in by the user is entered.
			*/
			
			Architect architect = new Architect(archiName, archiPhone, archiEmail, archiAddress, projectNum);
			
			/*
			*The user is then prompted to enter the Contracters details.
			*It is then stored in a variable again with each detail.
			*/
			
			System.out.println("What is the Contracters full name?\n");
			String contrName = input.nextLine();
			System.out.println("What is the Contracters phone number?\n");
			String contrPhone = input.nextLine();
			System.out.println("What is the Contracters email?\n");
			String contrEmail = input.nextLine();
			System.out.println("What is the Contracters physical address?\n");
			String contrAddress = input.nextLine();
			
			/*
			*The Architect object is then created and each needed information put in by the user is entered.
			*/
			
			Contracter contracter = new Contracter(contrName, contrPhone, contrEmail, contrAddress, projectNum);
			
			/*
			*The building object is then created with each need information inputted by the user.
			*/
			
			Building building = new Building(projectNum, projectName, buildingType, projectAddress, erfNum, totalFee2, paidToDate2, deadline);

			/*
			 * Setting customer object so that it can be used to name project if needed
			 */
			
			building.setCustomerObject(customer);
			
			/*
			 * The surnameName method is called
			 */
			
			building.surnameName();
			
			/*
			 * All the Objects are written to the database
			 */
			
			Database.newInfoToData(customer, architect, contracter, building);
			
		}
		
		/*
		 * The user is prompted with what they would like to do
		 * <p>
		 * All the following methods are related to doing something or getting something from the database
		 */
		
		Scanner input3 = new Scanner(System.in);
		System.out.println("What would you like to do?\n1 - update tables\n2 - finalize\n3 - view still to be complete projects \n4 - view past due projects\n5 - find a project\n6 - exit");
		String answer = input3.nextLine();
		if(answer.equals("1")) {
			Database.updateInfo();
		}else if(answer.equals("2")) {
			Database.finalizer();
		}else if(answer.equals("3")) {
			Database.toBeComplete();
		}else if(answer.equals("4")) {
			Database.PastDue();
		}else if(answer.equals("5")) {
			Database.findProject();
		}
}
}
