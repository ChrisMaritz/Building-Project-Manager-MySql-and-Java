import java.io.FileWriter;
import java.util.Formatter;

/**
*Creating Contracter class
*The purpose of this class is to create a Contracter object as well as all the needed methods for it except that which is for editing text files
*which is in editProjectFiles object.
*/

public class Contracter {

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
	 * Object constructer for the Contracter object
	 * <p>
	 * @param name, this is the contracters name.
	 * @param phoneNum, this is the contracters phone number.
	 * @param email, this is the contracters email.
	 * @param physiAddress, this is the contracter physical address.
	 * @param projectNum, this is the project number.
	 */
	
	public Contracter(String name, String phoneNum, String email, String physiAddress, String projectNum) {
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.physiAddress = physiAddress;
		this.projectNum = projectNum;
	}
	
	/**
	 * Getter for Contracters phone number.
	 * @return returns the phone number of the contracter.
	 */
	
	String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Getter for Contracters email.
	 * @return returns the name of the email.
	 */

	String getEmail() {
		return email;
	}

	/**
	 * Getter for Contracters name.
	 * @return returns the name of the contracter.
	 */
	
	String getName() {
		return name;
	}

	/**
	 * Getter for Contracters physical address.
	 * @return returns the physical address of the contracter.
	 */
	
	String getPhysiAddress() {
		return physiAddress;
	}

	/**
	 * Getter for Contracters project number.
	 * @return returns the project number of the contracter.
	 */
	
	String getProjectNum() {
		return projectNum;
	}
}
