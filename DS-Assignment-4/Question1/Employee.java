package Question1;

/**
 * Employee contains details of employees
 * 
 * @author Arjita
 *
 */
public class Employee {
	private int empId;// unique id of employee
	private String name;// name of employee
	private String address;// address of employee

	/**
	 * constructor of class
	 * 
	 * @param empId
	 *            id of employee
	 * @param name
	 *            of employee
	 * @param address
	 *            of employee
	 * @throws InvalidInput if input is invalid
	 */
	public Employee(int empId, String name, String address) throws InvalidInput {
		if(empId<0 || name==null || address==  null)
		{
			throw new InvalidInput("enter valid input");
		}
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
