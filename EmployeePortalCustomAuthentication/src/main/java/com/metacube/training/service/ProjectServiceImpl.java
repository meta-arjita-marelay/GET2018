package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	/*
	 * @Autowired private ProjectDAO projectDAO;
	 */

	@Autowired
	private ProjectRepository<Project> projectRepository;

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteProject(int id) {
		try {
			projectRepository.delete((long) id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean createProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
