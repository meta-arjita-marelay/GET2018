package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillsDao;
import com.metacube.training.model.SkillsMaster;

@Service
public class SkillServiceImplement implements ServiceInterface<SkillsMaster> {

	@Autowired
	private SkillsDao skillDAO;

	@Override
	public SkillsMaster getInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillsMaster> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInfo(SkillsMaster object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(SkillsMaster skillsMaster) {
		return skillDAO.create(skillsMaster);
	}

}
