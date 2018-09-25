package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;

public interface EmployeeRepository<E> extends JpaRepository<Employee, Long> {
	Employee findByCode(int code);

	Employee findByEmailId(String email);
	
	List<Employee> findByFirstName(String firstName);
	
	/*
	@Modifying
	@Query("select e from JobDetails j,Employee e "
			+ "where e.id=j.employeeId AND j.projectId=:projectId")
	List<Employee> getByProjectId(@Param("projectId") int projectId);*/

}
