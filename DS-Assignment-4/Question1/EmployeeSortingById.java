package Question1;

import java.util.Comparator;

/**
 * EmployeeSortingById will sort the list of employees according to their id
 * using comparator package
 * 
 * @author Arjita
 *
 */
public class EmployeeSortingById {
	public static Comparator<Employee> sortByEId = new Comparator<Employee>() {
		public int compare(Employee emp1, Employee emp2) {
			return (emp1.getEmpId() < emp2.getEmpId()) ? -1
					: (emp1.getEmpId() == emp2.getEmpId() ? 0 : 1);
		}
	};
}
