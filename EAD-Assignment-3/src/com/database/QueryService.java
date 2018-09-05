package com.database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * QueryService is data access object class
 * 
 * @author Arjita
 *
 */
public class QueryService {
	/**
	 * insertEmployee method will insert employees in table
	 * 
	 * @param employee
	 *            employee which is to be inserted
	 * @throws SQLException
	 */
	public static void insertEmployee(Employee employee) throws SQLException {
		String queryString = QueryFactory.addEmployee;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, employee.getFname());
				statement.setString(2, employee.getLname());
				statement.setString(3, employee.getEmail());
				statement.setInt(4, employee.getAge());
				statement.addBatch();
				statement.executeBatch();
			} catch (SQLException ex) {
				throw new SQLException(ex);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	/**
	 * showEmployee will fetch details of employee from table
	 * 
	 * @return list of employees from employee table
	 * @throws SQLException
	 */
	public static List<Employee> showEmployee() throws SQLException {
		String queryString = QueryFactory.showEmployees;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			ResultSet resultSet = statement.executeQuery();
			List<Employee> employeeDetails = new ArrayList<Employee>();
			while (resultSet.next()) {
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String email = resultSet.getString("email_id");
				int age = resultSet.getInt("age");
				Employee employee = new Employee();
				employee.setFname(fname);
				employee.setLname(lname);
				employee.setEmail(email);
				employee.setAge(age);
				employeeDetails.add(employee);
			}
			return employeeDetails;
		} catch (SQLException ex) {
			return null;
		}
	}

	/**
	 * searchEmployee will search employee details through their first name and
	 * last name
	 * 
	 * @param name
	 *            name through which details of employee is to be searched
	 * @return list of employee which matches the name
	 * @throws SQLException
	 */
	public static List<Employee> searchEmployee(String name)
			throws SQLException {
		String queryString = QueryFactory.searchEmployee;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			statement.setString(1, name);
			statement.setString(2, name);
			ResultSet resultSet = statement.executeQuery();
			List<Employee> employeeDetails = new ArrayList<Employee>();
			while (resultSet.next()) {
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				String email = resultSet.getString("email_id");
				int age = resultSet.getInt("age");
				Employee employee = new Employee();
				employee.setFname(fname);
				employee.setLname(lname);
				employee.setEmail(email);
				employee.setAge(age);
				employeeDetails.add(employee);
			}
			return employeeDetails;
		} catch (SQLException ex) {
			return null;
		}
	}

	/**
	 * updateEmployee will update employee details according to email-id
	 * 
	 * @param employee
	 *            new details of employee
	 * @param oldemail
	 *            email-id of employee which is to be updated
	 * @throws SQLException
	 */
	public static void updateEmployee(Employee employee, String oldemail)
			throws SQLException {
		String queryString = QueryFactory.updateEmployee;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			statement.setString(1, employee.getFname());
			statement.setString(2, employee.getLname());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getAge());
			statement.setString(5, oldemail);
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}
}
