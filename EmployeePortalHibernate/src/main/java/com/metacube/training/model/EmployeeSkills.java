package com.metacube.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkills {

	@Id
	@Column(name = "employee_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeSkillId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_code")
	private Employee employeeCode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_code")
	private SkillsMaster skillCode;

	public int getEmployeeSkillId() {
		return employeeSkillId;
	}

	public void setEmployeeSkillId(int employeeSkillId) {
		this.employeeSkillId = employeeSkillId;
	}

	public Employee getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Employee employeeCode) {
		this.employeeCode = employeeCode;
	}

	public SkillsMaster getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(SkillsMaster skillCode) {
		this.skillCode = skillCode;
	}

}
