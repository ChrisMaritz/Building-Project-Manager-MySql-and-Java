import java.io.FileWriter;
import java.util.Formatter;

/**
*Creating Architect class
*The purpose of this class is to create Architect object as well as all the needed methods for except that which is for editing text files
*which is in editProjectFiles object.
*/

public class Architect {

	/*
	*Attributes
	*/
	
	private String name;
	private String phoneNum;
	private String email;
	private String physiAddress;
	private String projectNum;

	/*
	*Methods
	*/
	
	/**
	 * Object constructer of the Architect object
	 * <p>
	 * @param name, this is the architects name.
	 * @param phoneNum, this is the architects phone number.
	 * @param email, this is the architects email.
	 * @param physiAddress, this is the architects physical address.
	 * @param projectNum, this is the project number.
	 */
	
	public Architect(String name, String phoneNum, String email, String physiAddress, String projectNum) {
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}

	/**
	 * Getter for architects name.
	 * @return returns the name of the architect.
	 */
	
	String getName() {
		return name;
	}

	/**
	 * Getter for architects phone number.
	 * @return returns the phone number of the architects.
	 */
	
	String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Getter for architects email.
	 * @return returns the email of the architects.
	 */
	
	String getEmail() {
		return email;
	}

	/**
	 * Getter for architects physical address.
	 * @return returns the physical address of the architects.
	 */
	
	String getPhysiAddress() {
		return physiAddress;
	}

	/**
	 * Getter for the project number.
	 * @return returns the project number.
	 */
	
	String getProjectNum() {
		return projectNum;
	}
	
}
