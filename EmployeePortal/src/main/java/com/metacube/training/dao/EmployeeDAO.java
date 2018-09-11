package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.util.*;

public class EmployeeDAO {
	public static final String INSERT_EMPLOYEE = "INSERT INTO Employee('emp_code' , 'first_name' "
			+ "'middle_name' , 'last_name' , 'dob' , 'gender' , 'primary_contact_no' "
			+ "'secondary_contact_no' , 'email' , 'skype_id' , 'profile_picture' , "
			+ "'password' , 'enabled') "
			+ "VALUES (? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ?)";
	
	public static final String UPDATE_EMPLOYEE_STATUS = "UPDATE Employee as e "
			+ "SET e.enabled = ? "
			+ "WHERE e.emp_code = ?";
	
	public static final String GET_PASSWORD = "SELECT e.password"
			+ "FROM Employee e"
			+ "WHERE e.emp_code = ?";
	
	public static final String GET_ALL_INFO ="SELECT * FROM Employee";
	
	public static final String GET_ALL_INFO_BY_ID = "SELECT * FROM Employee WHERE code = ?";
	
	public static final String GET_ALL_INFO_BY_EMAILID = "SELECT * FROM Employee WHERE email_id = ?";
	
	public static Boolean create(Employee employee) {
		String queryString = INSERT_EMPLOYEE;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getMiddleName());
				statement.setString(3, employee.getLastName());
				statement.setDate(4, employee.getDob());
				statement.setString(5, employee.getGender());
				statement.setString(6, employee.getContact());
				statement.setString(8, employee.getEmailId());
				statement.setString(9, employee.getSkypeId());
				statement.setString(10, employee.getProfilePicture());
				statement.setString(11, employee.getPassword());

				int result = statement.executeUpdate();
				if(result == 1){
					return true;
				}
				else{
					return false;
				}
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	/*public Status addProject(Project project) {
		String queryString = QueryFactory.addProject;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setInt(1, project.getProjectId());
				statement.setString(2, project.getDescription());
				statement.setDate(3, (Date) project.getStartDate());
				statement.setDate(4, (Date) project.getEndDate());
				statement.setString(5, project.getProjectLogo());
				statement.executeUpdate();
				
				return Status.SUCCESS;
			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}

	public Status updateProject(Project project) {
		String queryString = QueryFactory.updateProject;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, project.getDescription());
				statement.setDate(2, (Date) project.getStartDate());
				statement.setDate(3, (Date) project.getEndDate());
				statement.setString(4, project.getProjectLogo());
				statement.setInt(5, project.getProjectId());
				statement.executeUpdate();
				
				return Status.SUCCESS;
			} catch (SQLException ex) {
				return Status.FAILURE;
			}
		} catch (SQLException e) {
			return Status.FAILURE;
		}
	}
*/
	public static Boolean updateEmployeeStatus(String empCode , Boolean status){
		String queryString = UPDATE_EMPLOYEE_STATUS;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1,empCode);
				statement.setBoolean(2, status);
				int result = statement.executeUpdate();
				if(result == 1){
					return true;
				}
				else{
					return false;
				}
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
/*	public static String getPassword(String empCode){
		String queryString = GET_PASSWORD;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, empCode);
				ResultSet resultSet =  statement.executeQuery();
				resultSet.next();
				String password = resultSet.getString("password");
				return password;
				
			
			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}*/
	
	public static List<Employee> getAllInfo(){
		String queryString = GET_ALL_INFO;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				List<Employee> employees = new ArrayList<Employee>();
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()){
					Employee employee = new Employee();
					employee.setCode(resultSet.getInt("code"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setMiddleName(resultSet.getString("middle_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setGender(resultSet.getString("gender"));
					employee.setEmailId(resultSet.getString("email_id"));
					employee.setContact(resultSet.getString("contact"));
					employee.setSkypeId(resultSet.getString("skype_id"));
					employee.setProfilePicture(resultSet.getString("password"));
				}
				return employees;
			}catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static Employee getInfoById(int id){
		String queryString = GET_ALL_INFO_BY_ID;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
					Employee employee = new Employee();
					employee.setCode(resultSet.getInt("code"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setMiddleName(resultSet.getString("middle_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setGender(resultSet.getString("gender"));
					employee.setEmailId(resultSet.getString("email_id"));
					employee.setContact(resultSet.getString("contact"));
					employee.setSkypeId(resultSet.getString("skype_id"));
					employee.setProfilePicture(resultSet.getString("password"));
				return employee;
			}catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static Employee getInfoByEmail(String id){
		String queryString = GET_ALL_INFO_BY_ID;
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(queryString);) {
			try {
				statement.setString(1, id);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
					Employee employee = new Employee();
					employee.setCode(resultSet.getInt("code"));
					employee.setFirstName(resultSet.getString("first_name"));
					employee.setMiddleName(resultSet.getString("middle_name"));
					employee.setLastName(resultSet.getString("last_name"));
					employee.setGender(resultSet.getString("gender"));
					employee.setEmailId(resultSet.getString("email_id"));
					employee.setContact(resultSet.getString("contact"));
					employee.setSkypeId(resultSet.getString("skype_id"));
					employee.setProfilePicture(resultSet.getString("password"));
				return employee;
			}catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}
