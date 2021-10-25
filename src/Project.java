import java.util.Scanner;

public class Project {
	public static void main(String[] args) {
		
		//The user is welcomed the the program
		
		System.out.println("Welcome");
		
		//A new Scanner object is created
		//The user is then prompted with wether they want to create a new building project or not.
		//If they choose not to the program will be exited.
		//the answer is then stored in create.
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nWould you like to create a new building project(Enter 'Yes' or 'No')?");
		String create = input.nextLine();
		
		//if create is equal to "Yes" the program will run
		
		if(create.equals("Yes")) {
			
			//The user is then asks for each details of the project
			//And then the information is stored in a variable with each prompt.
			
			System.out.println("What is the project number?\n");
			String projectNum = input.nextLine();
			System.out.println("What is the projects name?\n");
			String projectName = input.nextLine();
			System.out.println("What is the building type?\n");
			String buildingType = input.nextLine();
			System.out.println("What is the project Address?\n");
			String projectAddress = input.nextLine();
			System.out.println("What is the ERF number?\n");
			String erfNum = input.nextLine();
			
			//The Scanner is restated as we are calling integers now.
			//This was suggested by a user in the discord server.
			
			input = new Scanner(System.in);
			System.out.println("What is the total fee?\n");
			Integer totalFee = input.nextInt();
			System.out.println("What is the amount paid so far?\n");
			Integer paidToDate = input.nextInt();
			
			//The scanner is then restated again as we are calling strings again.
			
			input = new Scanner(System.in);
			System.out.println("When is the project due?\n");
			String deadline = input.nextLine();
			
			//The user is then prompted to enter the Customers details.
			//It is then stored in a variable again with each detail.
			
			System.out.println("What is the customers name?\n");
			String custumrName = input.nextLine();
			System.out.println("What is the Customers phone number?\n");
			String custumrPhone = input.nextLine();
			System.out.println("What is the customers email?\n");
			String custumrEmail = input.nextLine();
			System.out.println("What is the customers physical address?\n");
			String custumrAddress = input.nextLine();
			
			//The customer object is then created and each needed information put in by the user is entered.
			
			Customer customer = new Customer(custumrName, custumrPhone, custumrEmail, custumrAddress, projectNum);
			
			//The user is then prompted to enter the Architects details.
			//It is then stored in a variable again with each detail.
			
			System.out.println("What is the Architects name?\n");
			String archiName = input.nextLine();
			System.out.println("What is the Architects phone number?\n");
			String archiPhone = input.nextLine();
			System.out.println("What is the Architects email?\n");
			String archiEmail = input.nextLine();
			System.out.println("What is the Architects physical address?\n");
			String archiAddress = input.nextLine();
			
			//The Architect object is then created and each needed information put in by the user is entered.
			
			Architect architect = new Architect(archiName, archiPhone, archiEmail, archiAddress, projectNum);
			
			//The user is then prompted to enter the Contracters details.
			//It is then stored in a variable again with each detail.
			
			System.out.println("What is the Contracters name?\n");
			String contrName = input.nextLine();
			System.out.println("What is the Contracters phone number?\n");
			String contrPhone = input.nextLine();
			System.out.println("What is the Contracters email?\n");
			String contrEmail = input.nextLine();
			System.out.println("What is the Contracters physical address?\n");
			String contrAddress = input.nextLine();
			//The Architect object is then created and each needed information put in by the user is entered.
			
			Contracter contracter = new Contracter(contrName, contrPhone, contrEmail, contrAddress, projectNum);
			
			//The building object is then created with each need information inputted by the user.
			
			Building building = new Building(projectNum, projectName, buildingType, projectAddress, erfNum, totalFee, paidToDate, deadline);
			
			//Each object is then stored within the building object.
			
			building.callCustomerObject(customer);
			building.callArchitectObject(architect);
			building.callContraObject(contracter);
			
			//The user is then asked whether they would like to the Due date.
			//Their answer is stored in a variable.
			
			System.out.println("Would you like to edit the Due date('Yes' or 'No')?");
			String answer = input.nextLine();
			
			//The following will happen if the user enters 'Yes'.
			
			if (answer.equals("Yes")) {
				
				//The function in building changeDueDate() is called
				
				building.changeDueDate();
			}
			
			//The user is asked whether they would like to change the amount paid.
			//The users answer is then stored in a variable.
			
			System.out.println("Would you like to edit the amount paid('Yes' or 'No')?");
			String answer2 = input.nextLine();
			
			//If the user enters 'Yes' the function changePaidToDate() will be called.
			if(answer.equals("Yes")) {
				building.changePaidToDate();
			}
			
			//The user is then prompted wether they would like to edit the contracters details and their answer is stored in a variable.
			
			System.out.println("Would you like to edit the Contracters details");
			String answer3 = input.nextLine();
			
			//If the user enters "Yes" the function editContr() in Contracter will be called.
			
			if(answer.equals("Yes")) {
				building.contrName.editContr();
			}
			//The user us then asked wether they would like to create an invoice and finalize the project.
			//The answer is stored in a variable
			//If the user enters yes the invoice will be displayed.
			
			String answer4 = "";
			System.out.println("Would you like to finalize the project and create an invoice('Yes' or 'No')?");
			answer4 = input.nextLine();
			
			if(answer4.equals("Yes")) {
				System.out.println(building.finalized());
			}
			
			//The user is then asks wether they would like to print all the buildings details.
			//The answer is then put in a variable.
			//If the user enters 'Yes' the Building projects information will be displayed.
			
			String answer5 = "";
			System.out.println("Would you like to print the projects information?('Yes' or 'No')");
			answer5 = input.nextLine();
			if(answer5.equals("Yes")) {
				System.out.println(building.toString());
			}
			
			input.close();
	}
}
}
