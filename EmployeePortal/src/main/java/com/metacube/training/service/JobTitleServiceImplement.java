package com.metacube.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobTitleDAO;
import com.metacube.training.model.JobTitle;

@Service
public class JobTitleServiceImplement implements ServiceInterface<JobTitle> {

	@Autowired
	private JobTitleDAO jobTitleDAO;

	@Override
	public JobTitle getInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTitle> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateInfo(JobTitle object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(JobTitle jobTitle) {
		return jobTitleDAO.create(jobTitle);
	}

}
