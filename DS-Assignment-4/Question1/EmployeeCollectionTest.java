package Question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {

	@Test
	public void testSortingById() throws EmployeeAlreadyExist, InvalidInput {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.addEmployee(2, "arjita", "shahdol");
		employeeCollection.addEmployee(3, "richa", "jaipur");
		employeeCollection.addEmployee(1, "chirag", "udaipur");
		employeeCollection.addEmployee(4, "prakalpa", "alwar");
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(1, "chirag", "udaipur"));
		expectedResult.add(new Employee(2, "arjita", "shahdol"));
		expectedResult.add(new Employee(3, "richa", "jaipur"));
		expectedResult.add(new Employee(4, "prakalpa", "alwar"));
		employeeCollection.sortingById();
		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}

	@Test(expected = EmployeeAlreadyExist.class)
	public void testEmployeeAlreadyExist() throws EmployeeAlreadyExist,
			InvalidInput {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.addEmployee(2, "arjita", "shahdol");
		employeeCollection.addEmployee(3, "richa", "jaipur");
		employeeCollection.addEmployee(1, "chirag", "udaipur");
		employeeCollection.addEmployee(4, "prakalpa", "alwar");
		employeeCollection.addEmployee(4, "prakalpa", "alwar");
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(1, "chirag", "udaipur"));
		expectedResult.add(new Employee(2, "arjita", "shahdol"));
		expectedResult.add(new Employee(3, "richa", "jaipur"));
		expectedResult.add(new Employee(4, "prakalpa", "alwar"));
		employeeCollection.sortingById();
		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}

	@Test
	public void testSortingByName() throws EmployeeAlreadyExist, InvalidInput {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.addEmployee(2, "arjita", "shahdol");
		employeeCollection.addEmployee(3, "richa", "jaipur");
		employeeCollection.addEmployee(1, "chirag", "udaipur");
		employeeCollection.addEmployee(4, "prakalpa", "alwar");
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(2, "arjita", "shahdol"));
		expectedResult.add(new Employee(1, "chirag", "udaipur"));
		expectedResult.add(new Employee(4, "prakalpa", "alwar"));
		expectedResult.add(new Employee(3, "richa", "jaipur"));
		employeeCollection.sortingByName();
		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}

	@Test(expected = InvalidInput.class)
	public void testInvalidInput() throws EmployeeAlreadyExist, InvalidInput {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.addEmployee(2, "arjita", "shahdol");
		employeeCollection.addEmployee(-1, "richa", "jaipur");
		employeeCollection.addEmployee(1, "chirag", "udaipur");
		employeeCollection.addEmployee(4, "prakalpa", "alwar");
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(1, "chirag", "udaipur"));
		expectedResult.add(new Employee(2, "arjita", "shahdol"));
		expectedResult.add(new Employee(3, "richa", "jaipur"));
		expectedResult.add(new Employee(4, "prakalpa", "alwar"));
		employeeCollection.sortingById();
		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).getEmpId(), employeeCollection
					.getListOfEmployee().get(i).getEmpId());
			assertEquals(expectedResult.get(i).getName(), employeeCollection
					.getListOfEmployee().get(i).getName());
			assertEquals(expectedResult.get(i).getAddress(), employeeCollection
					.getListOfEmployee().get(i).getAddress());
		}
	}
}
