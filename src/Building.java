
import java.io.FileWriter;
import java.util.Formatter;

/**
 * Object that serves the purpose of creating a building object as well as all the needed methods relating to this object except editing 
 * text files which is done by the EditProjectFiles object.
 * <p>
 * @author Christiaan Rudolf Maritz
 *
 */

public class Building {
	
	/*
	*Attributes
	*/
	
	private String projectNum;
	private String projectName;
	private String buildingType;
	private String projectAddress;
	private int erfNum;
	private double totalFee;
	private double paidToDate;
	private String deadline;
	private String complete;
	Customer customrObject;
	Contracter contrObject;
	Architect architObject;
	
	/*
	*Methods
	*/
	
	/**
	 * Object constructer for the Building object.
	 * <p>
	 * @param projectNum, this is the number for the project.
	 * @param projectName, this is the project name.
	 * @param buildingType, this is the type of building.
	 * @param projectAddress, this is the address of the project.
	 * @param erfNum, this is the erf number of the project.
	 * @param totalFee, this is the total fee for the project.
	 * @param paidToDate, this is the amount that must still be paid.
	 * @param deadline, this is the deadline of the project.
	 */
	
	public Building(String projectNum, String projectName, String buildingType, String projectAddress, int erfNum, double totalFee, double paidToDate, String deadline) {
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.setErfNum(erfNum);
		this.totalFee = totalFee;
		this.setPaidToDate(paidToDate);
		this.setDeadline(deadline);
		this.complete = "incomplete";
	}
	
	/**
	 * Function that will name the project name with the surname and type of building of the customer if project is not entered
	 */
	
	public void surnameName() {
		if(this.projectName.equals("")) {
			this.projectName = this.customrObject.getSurname() + this.buildingType;
		}
	}

	/**
	*Method serves the purpose of creating a string if needed out of the building object
	*<p>
	*@return Returns the string output of the full object including all other objects with ToString methods.
	*/
	
	public String toString() {

		String output = "Project number: " + getProjectNum();
		output += "\nproject Name: " + getProjectName();
		output += "\nBuilding Type: " + getBuildingType(); 
		output += "\nProject Address: " + getProjectAddress();
		output+= "\nTotal fee: " + getTotalFee();
		output += "\nERF Number: " + erfNum;
		output+= "\nPaid so far: " + getPaidToDate();
		output += "\nDeadline: " + getDeadline() + "\n";
		
		output += customrObject.toString();
		output += contrObject.toString();
		output += architObject.toString();
		
		return output;
	}
	
	/**
	 * This method serves as a function to set the customer object within this class as it is needed to create the project name if it is not inputted subsituiting it 
	 * with the last name of the customer and the building type.
	 * @param object, This parameter will be a customer object serving for the purpose of setting a Customer object in this class.
	 */
	
	public void setCustomerObject(Customer object) {
		this.customrObject = object;
	}

	/**
	 * Getter for deadline
	 * <p>
	 * @return Returns the deadline.
	 */
	
	String getDeadline() {
		return deadline;
	}

	/**
	 * setter for deadline
	 */
	
	void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	/**
	 * Getter for the amount paid so far
	 * <p>
	 * @return Returns the amount paid so far.
	 */
	
	double getPaidToDate() {
		return paidToDate;
	}

	/**
	 * setter for amount paid so far.
	 */
	
	void setPaidToDate(double paidToDate) {
		this.paidToDate = paidToDate;
	}

	/**
	 * Getter for the total fee.
	 * <p>
	 * @return Returns the total fee.
	 */
	
	double getTotalFee() {
		return totalFee;
	}

	/**
	 * setter for the erf number.
	 */
	
	void setErfNum(int erfNum) {
		this.erfNum = erfNum;
	}
	
	/**
	 * Getter for the erf number.
	 * <p>
	 * @return Returns the erf number.
	 */
	
	int getErf() {
		return erfNum;
	}

	/**
	 * Getter for the project address.
	 * <p>
	 * @return Returns the project address.
	 */
	
	String getProjectAddress() {
		return projectAddress;
	}

	/**
	 * Getter for the building type.
	 * <p>
	 * @return Returns the building type.
	 */
	
	String getBuildingType() {
		return buildingType;
	}

	/**
	 * Getter for the projects name.
	 * <p>
	 * @return Returns the project name.
	 */
	
	String getProjectName() {
		return projectName;
	}

	/**
	 * Getter for the projects number.
	 * <p>
	 * @return Returns the project number.
	 */
	
	String getProjectNum() {
		return projectNum;
	}

	/**
	 * Getter for wether the project is finalized.
	 * <p>
	 * @return Returns wether the project is finalized.
	 */
	
	String getComplete() {
		return complete;
	}
	}