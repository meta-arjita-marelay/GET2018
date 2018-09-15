package com.metacube.training.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_details")
public class JobDetails {
	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobDetailId;

	@Column(name = "employee_code")
	private int empCode;

	@Column(name = "date_of_joining")
	private Date joiningDate;

	@Column(name = "total_experience")
	private int experience;

	@Column(name = "job_code")
	private int jobCode;

	@Column(name = "reporting_manager")
	private int repManager;

	@Column(name = "team_lead")
	private int teamLead;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_code")
	@Column(name = "current_project_id")
	private int currentprojectId;

}
