package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ServiceInterface<Project> {

	@Autowired
	private ProjectDAO projectDao;

	@Override
	public Project getInfoById(int id) {
		return projectDao.getProjectById(id);
	}

	@Override
	public List<Project> getAllInfo() {
		return projectDao.getAllProjects();
	}


	@Override
	public boolean updateInfo(Project project) {
		return projectDao.updateProject(project);
	}

	@Override
	public boolean create(Project project) {
		return projectDao.createProject(project);
	}

//	public boolean validateLogin(String email , String password) {
//		return projectDAOInterface.validateLogin(email,password);
//	}
}
