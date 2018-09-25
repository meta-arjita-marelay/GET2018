package com.metacube.training.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.SkillsMaster;
import com.metacube.training.repository.SkillsRepository;

@Service
public class SkillServiceImplement implements ServiceInterface<SkillsMaster> {

	@Autowired
	private SkillsRepository skillRepo;

	@Override
	public SkillsMaster getInfoById(int id) {
		return skillRepo.findBySkillId(id);
	}

	@Override
	public List<SkillsMaster> getAllInfo() {
		return skillRepo.findAll();
	}

	@Override
	public boolean deleteInfo(int id) {
		return false;
	}

	@Override
	public boolean updateInfo(SkillsMaster skill) {
		skillRepo.save(skill);
		return false;
	}

	@Override
	public boolean create(SkillsMaster skillsMaster) {
		skillRepo.save(skillsMaster);
		return true;
	}
}
