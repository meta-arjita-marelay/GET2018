package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeRole;
import com.metacube.training.repository.EmployeeRolesRepository;

@Service
public class EmployeeRolesService {

	@Autowired
	private EmployeeRolesRepository<Employee> empRolesRepo;

	public List<EmployeeRole> getInfoByEmail(String email) {
		return empRolesRepo.findByEmail(email);
	}

}
