import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *This class function as a class to all methods etc that interact with the database 
 * @author Christiaan Rudolf Maritz
 *
 */

public class Database {

	/**
	 * This method serves the purpose of adding all the new data which is inputted by the user into tables into the mysql server.
	 * 
	 * @param customer this is a customer object
	 * @param architect this is an architect object
	 * @param contracter this is a contracter object
	 * @param building this is a building object
	 * @throws SQLException this is there for if there is any error with connecting to the server etc
	 * @throws ClassNotFoundException 
	 */
	
	public static void newInfoToData(Customer customer, Architect architect, Contracter contracter, Building building) throws SQLException, ClassNotFoundException {

		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//Inputting the needed values into all the needed tables
		
		rowsAffected = statement.executeUpdate("INSERT INTO customer VALUES ("
				+ customer.getProjectNum() + ", '"
				+ customer.getName() + "', '" 
				+ customer.getSurname() + "', "
				+ customer.getPhoneNum() + ", '"
				+ customer.getEmail() + "')");
		
		rowsAffected = statement.executeUpdate("INSERT INTO architect VALUES("
				+ architect.getProjectNum() + ", '"
				+ architect.getName() + "', " 
				+ architect.getPhoneNum() + ", '"
				+ architect.getEmail() + "'"
						+ ")");
		
		rowsAffected = statement.executeUpdate("INSERT INTO contracter VALUES("
				+ contracter.getProjectNum() + ", '"
				+ contracter.getName() + "', " 
				+ contracter.getPhoneNum() + ", '"
				+ contracter.getEmail() + "')");
		
		rowsAffected = statement.executeUpdate("INSERT INTO building_type_address VALUES("
				+ building.getProjectNum() + ", '"
				+ building.getBuildingType() + "', '" 
				+ building.getProjectAddress() + "')");
		
		rowsAffected = statement.executeUpdate("INSERT INTO deadline_complete VALUES("
				+ building.getProjectNum() + ", '"
				+ building.getDeadline() + "', '" 
				+ building.getComplete() + "',"
				+ "null)");
		
		rowsAffected = statement.executeUpdate("INSERT INTO erf_fee VALUES("
				+ building.getProjectNum() + ", "
				+ building.getErf() + "," 
				+ building.getTotalFee() + ",'"
				+ building.getPaidToDate() + "')");
		
	}
	
	/**
	 * This method functions to be able to update any coloumn in any table in the poise database
	 * @throws SQLException, this is there incase there are any issues with the mysql commands
	 */
	
	public static void updateInfo() throws SQLException {
		
		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true&useSSL=false",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		String answerString = "";
		int projectNumber = 0;
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//The user is prompted with which table they would like to update
		
		System.out.println("Which table would you like to edit from?\n1 - customer\n2 - contracter\n3 - architect\n4 - building_type_address\n5 - deadline_complete\n6 - erf_fee");
		int answerInt = inputInt.nextInt();
		
		//If the user selected 1 customer will be chosen to update
		
		if(answerInt == 1) {
			
			//The user is prompted with which project they would like edit and shown a list of all the coloumns in the customer tables
			
			System.out.println("Which item would you like to edit, choose by project number (first item)");
			results = statement.executeQuery("Select * FROM customer");
			printAllFromCustomer(statement, "customer", "person");
			projectNumber = inputInt.nextInt();
			
			//the user is prompted with which coloumn they would like to 
			
			System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - first_name\n3 - surname\n4 - phonenum\n5 - email\n6 - street address");
			answerInt = inputInt.nextInt();
			
			//This is the choice for project_num
			
			if(answerInt == 1) {
				
				// a loop is created where if tOrF is true the loop will exit
				
				boolean tOrF = false;
				while(tOrF == false) {
					
					//within the try block,
					//the user is prompted with what the new project number is
					//tOrF is set to True
					
					try {
						System.out.println("What is the new project number?");
						answerInt = inputInt.nextInt();
						tOrF = true;
						
					//If there is an error the user will be asked if they only entered digits as well as tOrF being set to false allowing the loop to run again
					
					}catch(InputMismatchException e) {
						System.out.println("Are you sure you only typed in digits");
						tOrF = false;
					}
				}
				
				//the project_num is updated to the new number
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET project_num = " + answerInt + "WHERE project_num = " + projectNumber);
				
			//Choice for updating the first name
				
			}else if(answerInt == 2) {
				
				//The user is prompted with what the new first name is
				
				System.out.println("What is the new first name?");
				answerString = inputString.nextLine();
				
				// the first name is updated in the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET first_name = '" + answerString + "' WHERE project_num = " + projectNumber);
				
			//Choice for updating the surname
				
			}else if(answerInt == 3) {
				
				//The user is prompted with what the new surname is
				
				System.out.println("What is the new surname?");
				answerString = inputString.nextLine();
				
				// the surname is updated in the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET surname = '" + answerString + "' WHERE project_num = " + projectNumber);
				
			//Choice for updating the new phonenum
				
			}else if(answerInt == 4) {
				
				//The user is prompted with what the new phonenum is
				
				System.out.println("What is the new phonenum?");
				answerString = inputString.nextLine();
				
				// the phonenum is updated in the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET phonenum = '" + answerString + "' WHERE project_num = " + projectNumber);
				
			//Choice for updating the new email
				
			}else if(answerInt == 5) {
				
				//The user is prompted with what the new email is
				
				System.out.println("What is the new email?");
				answerString = inputString.nextLine();
				
				// the email is updated in the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET email = '" + answerString + "' WHERE project_num = " + projectNumber);
				
			//here it goes back to choosing which table being the contracter table
			//It does the same as the customer table
				
			}else if(answerInt == 6) {
				
				//The user is prompted with what the new street address is
				
				System.out.println("What is the new street address?");
				answerString = inputString.nextLine();
				
				//The new street address is added to the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET street_address = '" + answerString + "' WHERE project_num = " + projectNumber);
			}
			
			//here it goes back to choosing which table being the contracter table
			//It does the same as the customer table
			
			}else if(answerInt == 2) {
				System.out.println("Which item would you like to edit, choose by project number (first item)");
				results = statement.executeQuery("Select * FROM contracter");
				printAllFromCustomer(statement, "contracter", "person");
				projectNumber = inputInt.nextInt();
				
				System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - first_name\n3 - phonenum\n4 - email\n5 - street_address");
				answerInt = inputInt.nextInt();
				
				if(answerInt == 1) {
					boolean tOrF = false;
					while(tOrF == false) {
						try {
							System.out.println("What is the new project number?");
							answerInt = inputInt.nextInt();
							tOrF = true;
						}catch(InputMismatchException e) {
							System.out.println("Are you sure you only typed in digits");
							tOrF = false;
						}
					}
					rowsAffected = statement.executeUpdate("UPDATE contracter SET project_num = " + answerInt + "WHERE project_num = " + projectNumber);
				}else if(answerInt == 2) {
					System.out.println("What is the new first name?");
					answerString = inputString.nextLine();
					rowsAffected = statement.executeUpdate("UPDATE contracter SET first_name = '" + answerString + "' WHERE project_num = " + projectNumber);
				}else if(answerInt == 3) {
					System.out.println("What is the new phonenum?");
					answerString = inputString.nextLine();
					rowsAffected = statement.executeUpdate("UPDATE contracter SET phonenum = '" + answerString + "' WHERE project_num = " + projectNumber);
				}else if(answerInt == 4) {
					System.out.println("What is the new email?");
					answerString = inputString.nextLine();
					rowsAffected = statement.executeUpdate("UPDATE contracter SET email = '" + answerString + "' WHERE project_num = " + projectNumber);
				}else if(answerInt == 5) {
					
					//The user is prompted with what the new street address is
					
					System.out.println("What is the new street address?");
					answerString = inputString.nextLine();
					
					//The new street address is added to the table
					
					rowsAffected = statement.executeUpdate("UPDATE customer SET street_address = '" + answerString + "' WHERE project_num = " + projectNumber);
				}
				
		//here it goes back to choosing which table being the architect table
		//It does the same as the customer and contracter table
			
		}else if(answerInt == 3) {
			System.out.println("Which item would you like to edit, choose by project number (first item)");
			results = statement.executeQuery("Select * FROM architect");
			printAllFromCustomer(statement, "architect", "person");
			projectNumber = inputInt.nextInt();
			
			System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - first_name\n3 - phonenum\n4 - email\n5 - street address");
			answerInt = inputInt.nextInt();
			
			if(answerInt == 1) {
				boolean tOrF = false;
				while(tOrF == false) {
					try {
						System.out.println("What is the new project number?");
						answerInt = inputInt.nextInt();
						tOrF = true;
					}catch(InputMismatchException e) {
						System.out.println("Are you sure you only typed in digits");
						tOrF = false;
					}
				}
				rowsAffected = statement.executeUpdate("UPDATE architect SET project_num = " + answerInt + "WHERE project_num = " + projectNumber);
			}else if(answerInt == 2) {
				System.out.println("What is the new first name?");
				answerString = inputString.nextLine();
				rowsAffected = statement.executeUpdate("UPDATE architect SET first_name = '" + answerString + "' WHERE project_num = " + projectNumber);
			}else if(answerInt == 3) {
				System.out.println("What is the new phonenum?");
				answerString = inputString.nextLine();
				rowsAffected = statement.executeUpdate("UPDATE architect SET phonenum = '" + answerString + "' WHERE project_num = " + projectNumber);
			}else if(answerInt == 4) {
				System.out.println("What is the new email?");
				answerString = inputString.nextLine();
				rowsAffected = statement.executeUpdate("UPDATE architect SET email = '" + answerString + "' WHERE project_num = " + projectNumber);
			}else if(answerInt == 5) {
				
				//The user is prompted with what the new street address is
				
				System.out.println("What is the new street address?");
				answerString = inputString.nextLine();
				
				//The new street address is added to the table
				
				rowsAffected = statement.executeUpdate("UPDATE customer SET street_address = '" + answerString + "' WHERE project_num = " + projectNumber);
			}
			
	//Here it goes back to choosing a different table this being building_type
	//this conditional it does the same as the other and it will be mentioned if does something different.
			
	}else if(answerInt == 4) {
		
		System.out.println("Which item would you like to edit, choose by project number (first item)");
		results = statement.executeQuery("Select * FROM building_type_address");
		printAllFromCustomer(statement, "", "building_type_address");
		projectNumber = inputInt.nextInt();
		
		System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - building_type\n3 - address");
		answerInt = inputInt.nextInt();
		
		if(answerInt == 1) {
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new project number?");
					answerInt = inputInt.nextInt();
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE building_type_address SET project_num = " + answerInt + " WHERE project_num = " + projectNumber);
			
		//Here the building type is updated
			
		}else if(answerInt == 2) {
			System.out.println("What is the new building_type?");
			answerString = inputString.nextLine();
			rowsAffected = statement.executeUpdate("UPDATE building_type_address SET building_type =' " + answerString + "' WHERE project_num = " + projectNumber);
			
		//Here the new address is updated.
			
		}else if(answerInt == 3) {
			System.out.println("What is the new address?");
			answerString = inputString.nextLine();
			rowsAffected = statement.executeUpdate("UPDATE building_type_address SET address = '" + answerString + "' WHERE project_num = " + projectNumber);
		}
		
		//Here it goes back to choosing a different table this being building_type
		//this conditional it does the same as the other and it will be mentioned if does something different.
		
	}else if(answerInt == 5) {
		System.out.println("Which item would you like to edit, choose by project number (first item)");
		results = statement.executeQuery("Select * FROM deadline_complete");
		printAllFromCustomer(statement, "", "deadline_complete");
		projectNumber = inputInt.nextInt();
		
		System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - deadline\n3 - complete\n4 - completed_on");
		answerInt = inputInt.nextInt();
		
		if(answerInt == 1) {
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new project number?");
					answerInt = inputInt.nextInt();
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE deadline_complete SET project_num = " + answerInt + " WHERE project_num = " + projectNumber);
			
		//Here the new deadline is updated
			
		}else if(answerInt == 2) {
			
			//Here a loop is created the same as the project number one except it is for a date object 
			
			boolean tOrF = false;
			//while(tOrF == false) {
				//try {
					System.out.println("What is the new deadline?");
					answerString = inputString.nextLine();
					rowsAffected = statement.executeUpdate("UPDATE deadline_complete SET deadline = '" + answerString + "' WHERE project_num = " + projectNumber);
					tOrF = true;
				//}catch(SQLException e) {
					System.out.println("Are you sure you typed in a date format");
					tOrF = false;
				//}
			//}
			
		//Here the new address is updated
			
		}else if(answerInt == 3) {
			System.out.println("what is the new complete?");
			answerString = inputString.nextLine();
			rowsAffected = statement.executeUpdate("UPDATE deadline_complete SET complete = '" + answerString + "' WHERE project_num = " + projectNumber);
		}else if(answerInt == 4) {
			
			//Here a loop is created the same as the project number one except it is for a date object 
			
			boolean tOrF = false;
			while(tOrF == false) {
			try {
				System.out.println("What is the new completed on date? ");
				answerString = inputString.nextLine();
				rowsAffected = statement.executeUpdate("UPDATE deadline_complete SET completed_on = '" + answerString + "' WHERE project_num = " + projectNumber);
				tOrF = true;
			}catch(SQLException e) {
				System.out.println("Are you sure you typed in a date format?");
				tOrF = false;
			}
			}
			
		}
		
	//Here it goes back to choosing a different table this being erf_fee
	//this conditional it does the same as the other and it will be mentioned if does something different.
		
	}else if(answerInt == 6) {
		System.out.println("Which item would you like to edit, choose by project number (first item)");
		results = statement.executeQuery("Select * FROM erf_fee");
		printAllFromCustomer(statement, "", "erf_fee");
		projectNumber = inputInt.nextInt();
		
		System.out.println("Which coloumn would you like to edit?\n1 - project_num\n2 - erf\n3 - toal_fee\n4 - paid_to_date");
		answerInt = inputInt.nextInt();
		
		if(answerInt == 1) {	
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new project number?");
					answerInt = inputInt.nextInt();
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE erf_fee SET project_num = " + answerInt + " WHERE project_num = " + projectNumber);
		}else if(answerInt == 2) {
			
			//Here a loop is created the same as the project number one except it is updating the erf 
			
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new erf?");
					answerInt = inputInt.nextInt();	
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE erf_fee SET erf = " + answerInt + " WHERE project_num = " + projectNumber);
		}else if(answerInt == 3) {
			
			//Here a loop is created the same as the project number one except it is for the total fee
			
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new total fee?");
					answerInt = inputInt.nextInt();	
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE erf_fee SET total_fee = " + answerInt + " WHERE project_num = " + projectNumber);
		}else if(answerInt == 4) {
			
			//Here a loop is created the same as the project number one except it is for a new paid to date
			
			boolean tOrF = false;
			while(tOrF == false) {
				try {
					System.out.println("What is the new paid to date?");
					answerInt = inputInt.nextInt();	
					tOrF = true;
				}catch(InputMismatchException e) {
					System.out.println("Are you sure you only typed in digits");
					tOrF = false;
				}
			}
			rowsAffected = statement.executeUpdate("UPDATE erf_fee SET paid_to_date = " + answerInt + " WHERE project_num = " + projectNumber);
		}
	}
	}
	
	/**
	 * This method functions to finalize a project and mark it as complete
	 * @throws SQLException, this is there incase there is an issue with mysql commands
	 */
	
	public static void finalizer() throws SQLException {
		
		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true&useSSL=false",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		String answerString = "";
		int answerInt = 0;
		int projectNumber = 0;
		String project_num = "";
		double total_fee = 0;
		double paid_to_date = 0;
		String first_name = "";
		String surname = "";
		String phoneNum = "";
		String email = "";
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//The user is asked which project the would like to print a invoice for 
		
		System.out.println("Which customer would you like to print a invoice for ?(choose by project number)");
		
		//The customer table is printed
		
		results = statement.executeQuery("Select * from customer");
		printAllFromCustomer(statement, "customer", "person");
		answerInt = inputInt.nextInt();
		
		//The needed information is selected from the customer table.
		
		results = statement.executeQuery("SELECT project_num, first_name, surname, phonenum, email FROM customer where project_num = " + answerInt);
		
		//All the information from the table is saved to the needed variables
		
		while(results.next()) {
					project_num = String.valueOf(results.getInt("project_num"));
					first_name = results.getString("first_name");
					surname =   results.getString("surname");
					phoneNum = results.getString("phonenum");
					email = results.getString("email");
		}
		
		//All the information is selected from paid_to_date and saved to the needed variables.
		
		results = statement.executeQuery("SELECT total_fee, paid_to_date FROM erf_fee where project_num = " + answerInt);
		while(results.next()) {
					total_fee = results.getInt("total_fee");
					paid_to_date = results.getInt("paid_to_date");	
		}
		
		//The total fee and amount paid so far is minused from each other and saved to to_pay.
		
		double to_pay = total_fee - paid_to_date;
		
		//If to pay is larger than zero an invoice will be printed
		
		if (to_pay > 0) {
			System.out.println("Invoice\nfirst name - " + first_name + "\nsurname - " + surname + "\nphone number - " + phoneNum + "\nemail - " + email + "\namount to be paid - " + to_pay);
		
		//IF it is 0 it will be said that no invoice is needed
			
		}else {
			System.out.println("No invoice needed");
		}
		
		//the project is marked as complete in the deadline_complete table. 
		
		rowsAffected = statement.executeUpdate("UPDATE deadline_complete set complete = 'complete' WHERE project_num = " + answerInt);
		
		rowsAffected = statement.executeUpdate("UPDATE deadline_complete set completed_on = current_date() WHERE project_num = " + answerInt);
		
		//For the current_date() function this a function I had found online. I was using date time objects previously with the text files but
		//now i needed another way which was this current_date() function. it is from https://www.w3schools.com/sql/func_mysql_curdate.asp in the form
		// i used it in I found it in this line "Note: This function equals the CURRENT_DATE() function."
	}	
	
	/**
	 * This method functions to view all the projects that are still to be completed.
	 * @throws SQLException, this is there if there is a problem with the mysql commands
	 */
	
	public static void toBeComplete() throws SQLException {
		
		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true&useSSL=false",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		String answerString = "";
		int answerInt = 0;
		String complete = "";
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//All the needed information is selected specifically if complete = "complete"
		
		results = statement.executeQuery("SELECT project_num, complete, deadline FROM deadline_complete WHERE complete != 'complete'");
		
		//All the information is added to complete
		
		while(results.next()) {
			complete += "\nproject number - " + results.getInt("project_num") + " = " +  results.getString("complete");
		}
		
		//All the information is printed
		
		System.out.println("projects to be completed" + complete);
				
	}
	
	/**
	 * This method function to view all the past dye projects
	 * @throws SQLException, this is there in case there is a problem with mysql.
	 */
	
	public static void PastDue() throws SQLException{
		
		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true&useSSL=false",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		String answerString = "";
		int answerInt = 0;
		String complete = "";
		DateTimeFormatter formatThis = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = LocalDate.now().format(formatThis);
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//All the past due project are selected
		
		results = statement.executeQuery("SELECT * FROM deadline_complete WHERE current_date() > complete");
		
		//All the information for the past due projects are added to complete.
		
		while(results.next()) {
			complete += "\nproject number -" + results.getInt("project_num") 
			+ "\ncompleted on - " + String.valueOf(results.getDate("completed_on"))
			+ "\ndeadline - "+ String.valueOf(results.getDate("deadline"));
		}
		
		//all the past due projects are printed.
		
		System.out.println("projects past due" + complete);
		
	}
	
	/**
	 * This method functions to find a project in the database with its project number
	 * @throws SQLException
	 */
	
	public static void findProject() throws SQLException {
		
		//Connecting to the java database
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library_db?allowPublicKeyRetrieval=true&useSSL=false",
				"bob",
				"Bird"
				);
		
		//Creating needed variables
			
		Statement statement = connection.createStatement();
		ResultSet results;
		int rowsAffected;
		Scanner inputInt = new Scanner(System.in);
		int projNum = 0;
		
		//Using poise database
		
		rowsAffected = statement.executeUpdate("use PoisePMS");
		
		//A loop is created where if tOrF is true it will exit the loop
		
		boolean tOrF = false;
		while(tOrF == false) {
			
			//Within the try block the user is asked which project number they want to enter and thus their answer is saved in projNum
			//tOrf is also set to true 
			
			try {
				System.out.println("What is the project number?");
				projNum = inputInt.nextInt();
				tOrF = true;
				
				//If the catch block is run the user will be asked if they only entered digits and tOrF will be set to false thus running the while loop again
				
			}catch(InputMismatchException e) {
				System.out.println("Are you sure you only typed in digits");
				tOrF = false;
			}}
		
		//The information from the table is selected
		
		results = statement.executeQuery("SELECT * FROM building_type_address WHERE project_num = " + projNum);
		while(results.next()) {
			
			//All the needed information is printed
			
			System.out.println(results.getString("project_num") 
					+ "\n" + results.getString("building_type")
					+ "\n" + results.getString("address"));
		}
		
	}
		
	/**
	 * This Method functions as way to print information from any tables in the database if needed.
	 * @param statement, This parameter is to put in the statement object to implement sql commands.
	 * @param type, This parameter functions as to be there to state what type of tables you want in terms of all the tables that describe the persons.
	 * @param choice, This is to choose which type of tables you want for example like a person or deadline_complete etc
	 * @throws SQLException, This is there in case any thing goes wrong with the sql commands
	 */
	
	public static void printAllFromCustomer(Statement statement, String type, String choice) throws SQLException {
		
		//this is run if the person wishes to print the information from either the customer tables, architect or contracter
		//Notice that type is there for the sql commands
		
		if(choice == "person" && type == "customer") {
			
			//The information from the table is chosen
			
			ResultSet results = statement.executeQuery("SELECT project_num, first_name, surname, phonenum, email, street_address FROM " + type);
			while(results.next()) {
				System.out.println(
						
						//All the information is printed
						
						results.getInt("project_num") + ", "
						+ results.getString("first_name") + ", "
						+ results.getString("surname") + ", "
						+ results.getString("phonenum") + ", "
						+ results.getString("email") + ", "
						+ results.getString("street_address")
						);
			}
			
			//If the user wants to print information from contracter or architect the same will be done just with that table instead
			
		}else if(choice == "person" && type != "customer") {
			ResultSet results = statement.executeQuery("SELECT project_num, first_name, phonenum, email FROM " + type);
			while(results.next()) {
				System.out.println(
						
						//All the information is printed
						
						results.getInt("project_num") + ", "
						+ results.getString("first_name") + ", "
						+ results.getString("phonenum") + ", "
						+ results.getString("email") + ", "
						+ results.getString("street_address")
						);
			}
			
			//If the user wants to print information from building_type_address the same will be done just with that table instead
			
		}else if(choice == "building_type_address") {
			ResultSet results = statement.executeQuery("SELECT project_num, building_type, address FROM building_type_address");
			while(results.next()) {
				System.out.println(
						results.getInt("project_num") + ", "
						+ results.getString("building_type") + ", "
						+ results.getString("address")
						);
			}
			
			//If the user wants to print information from deadline_complete the same will be done just with that table instead
			
		}else if(choice == "deadline_complete") {
			ResultSet results = statement.executeQuery("SELECT project_num, deadline, complete, completed_on FROM deadline_complete");
			while(results.next()) {
				System.out.println(
						results.getInt("project_num") + ", "
						+ results.getString("deadline") + ", "
						+ results.getString("complete")  + ", "
						+ results.getString("completed_on")
						);
		}
			
			//If the user wants to print information from erf_fee the same will be done just with that table instead
			
		}else if(choice == "erf_fee") {
			ResultSet results = statement.executeQuery("SELECT project_num, erf, total_fee, paid_to_date FROM erf_fee");
			while(results.next()) {
				System.out.println(
						results.getInt("project_num") + ", "
						+ results.getString("erf") + ", "
						+ results.getString("total_fee") + ", "
						+ results.getString("paid_to_date")
						);
		}
		}
	}
}
