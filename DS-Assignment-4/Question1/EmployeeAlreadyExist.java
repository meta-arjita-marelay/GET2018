package Question1;

/**
 * EmployeeAlreadyExist is error class and will be called if employee id already
 * exist in list
 * 
 * @author Arjita
 *
 */
@SuppressWarnings("serial")
public class EmployeeAlreadyExist extends Exception {
	public EmployeeAlreadyExist(String message) {
		super(message);
	}
}
