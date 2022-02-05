import java.io.FileWriter;
import java.util.Formatter;

/**
*Creating customer class
*The purpose of this class is to create customer object as well as all the needed methods for except that which is for editing text files
*which is in editProjectFiles object.
*/

public class Customer {

	/*
	*Attributes
	*/
	
	private String name;
	private String surname;
	private String phoneNum;
	private String email;
	private String physiAddress;
	private String projectNum;
	
	/*
	*Methods
	*/
	
	/**
	 * Object constructer for the customer object
	 * <p>
	 * @param name, this is the customers first name.
	 * @param surname, this is the customers surname.
	 * @param phoneNum, this is the phone number of the customer.
	 * @param email, this is the customers email.
	 * @param physiAddress, the is the customers physical address.
	 * @param projectNum, this is the number of the project.
	 */
	
	public Customer(String name, String surname, String phoneNum, String email, String physiAddress, String projectNum) {
		
		this.name = name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}
	
	/**
	 * Getter for customers first name.
	 * @return returns the first name of the customer.
	 */
	
	String getName() {
		return name;
	}

	/**
	 * Getter for the customer phone number.
	 * @return returns the phone number of the customer.
	 */
	
	String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Getter for customers email.
	 * @return returns the email of the customer.
	 */
	
	String getEmail() {
		return email;
	}

	/**
	 * Getter for customers address.
	 * @return returns the address of the customer.
	 */
	
	String getPhysiAddress() {
		return physiAddress;
	}

	/**
	 * Getter for customers project number.
	 * @return returns the project number.
	 */
	
	String getProjectNum() {
		return projectNum;
	}

	/**
	 * Getter for customers last name.
	 * @return returns the last name of the customer.
	 */
	
	String getSurname() {
		return surname;
	}
}
