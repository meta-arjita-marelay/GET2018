package com.metacube.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplement implements ServiceInterface<Employee> {

	@Autowired
	private EmployeeRepository<Employee> empRepo;

	@Override
	public Employee getInfoById(int id) {
		return empRepo.findByCode(id);
	}

	@Override
	public List<Employee> getAllInfo() {
		return empRepo.findAll();
	}

	@Override
	public boolean deleteInfo(int id) {
		 empRepo.delete((long) id);
		 return true;
	}

	@Override
	public boolean updateInfo(Employee employee) {
		empRepo.save(employee);
		return true;
//		return employeeDAO.updateInfo(employee);
	}

	@Override
	public boolean create(Employee employee) {
		empRepo.save(employee);
		return true;
//		return employeeDAO.create(employee);
	}

	public Employee getInfoByEmail(String email) {
		empRepo.findByEmailId(email);
		return null;
//		return ((EmployeeDAO) employeeDAO).getInfoByEmail(email);
	}

	public List<Employee> searchBy(String filter, String attributeName) {
		if (filter.equals("name")) {
			return empRepo.findByFirstName(attributeName);
		} 
//		else if (filter.equals("project")) {
//			return ((EmployeeDAO) employeeDAO).getInfoByProject(attributeName);
//		} else if (filter.equals("skills")) {
//			return ((EmployeeDAO) employeeDAO).getInfoBySkills(attributeName);
//		} else {
//			return ((EmployeeDAO) employeeDAO)
//					.getInfoByExperience(attributeName);
//		}
		return null;
	}

	public Boolean validateLogin(String email, String password) {
		Employee employee = getInfoByEmail(email);
		if (employee.getEmailId().equalsIgnoreCase(email)
				&& employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Boolean resetPassword(String email, String oldPassword,
			String newPassword) {
			return true;
//		return ((EmployeeDAO) employeeDAO).resetPassword(email, oldPassword,
//				newPassword);

	}
}
