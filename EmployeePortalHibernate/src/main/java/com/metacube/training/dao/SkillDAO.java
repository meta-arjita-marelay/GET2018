package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.SkillsMaster;

@Repository
@Transactional
public class SkillDAO implements DAOInterface<SkillsMaster> {

	@Autowired
	private SessionFactory sessionFactory;

	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_SKILLS = " INSERT INTO skill_master(skill_name) "
			+ "VALUES " + "(?)";

	@Override
	public SkillsMaster getInfoById(int id) {
		return null;
	}

	@Override
	public List<SkillsMaster> getAllInfo() {
		return null;
	}

	@Override
	public boolean deleteInfo(int id) {
		return false;
	}

	@Override
	public boolean updateInfo(SkillsMaster object) {
		return false;
	}

	@Override
	public boolean create(SkillsMaster skillsMaster) {

		sessionFactory.getCurrentSession().save(skillsMaster);
		return true;
	}

}