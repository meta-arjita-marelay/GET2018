package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		try {
			empRepo.delete((long) id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateInfo(Employee employee) {
		try {
			empRepo.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean create(Employee employee) {
		try {
			empRepo.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Employee getInfoByEmail(String email) {
		try {
			return empRepo.findByEmailId(email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Employee> searchBy(String filter, String attributeName) {
		if (filter.equals("name")) {
			return empRepo.findByFirstName(attributeName);
		}
		return null;
	}

	public Boolean validateLogin(String email, String password) {
		Employee employee = getInfoByEmail(email);
		if (employee != null && employee.getEmailId().equalsIgnoreCase(email)
				&& employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		return true;
	}
}
