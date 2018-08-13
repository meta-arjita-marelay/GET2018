package Question1;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * EmployeeCollection contains list of employee
 * 
 * @author Arjita
 *
 */
public class EmployeeCollection {
	// list of employees
	List<Employee> listOfEmployee = new ArrayList<Employee>();

	/**
	 * method to add employee in list
	 * 
	 * @param empId
	 *            employee id to be added
	 * @param name
	 *            name of employee to be added
	 * @param address
	 *            of employee to be added
	 * @throws EmployeeAlreadyExist
	 *             error if employee already exist
	 * @throws InvalidInput
	 *             error if employee details is invalid
	 */
	public void addEmployee(int empId, String name, String address)
			throws EmployeeAlreadyExist, InvalidInput {
		// check if employee id already exist
		if (employeeAlreadyExist(empId)) {
			throw new EmployeeAlreadyExist("this employee already exist");
		}
		// if employee doesn't exist then add it to the list
		listOfEmployee.add(new Employee(empId, name, address));
	}

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	/**
	 * private helper method to check if employee already exist
	 * 
	 * @param empId
	 *            id of employee which is to be checked
	 * @return true if employee id already exist
	 */
	private boolean employeeAlreadyExist(int empId) {
		for (Employee employee : listOfEmployee) {
			if (employee.getEmpId() == empId) {
				return true;
			}
		}
		return false;
	}

	/**
	 * sortingByName method will sort the employees list according to the name
	 */
	public void sortingByName() {
		Collections.sort(listOfEmployee, EmployeeSortingByName.sortByEname);
	}

	/**
	 * sortingById method will sort the employees list according to the id
	 */
	public void sortingById() {
		Collections.sort(listOfEmployee, EmployeeSortingById.sortByEId);
	}
}
