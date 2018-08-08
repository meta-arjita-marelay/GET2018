package Question1;

import java.util.Comparator;

/**
 * EmployeeSortingByName will sort the list of employees according to their name
 * using comparator package
 * 
 * @author Arjita
 *
 */
public class EmployeeSortingByName {

	public static Comparator<Employee> sortByEname = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {

			return emp1.getName().compareToIgnoreCase(emp2.getName());
		}
	};
}
