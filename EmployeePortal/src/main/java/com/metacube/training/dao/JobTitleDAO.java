package com.metacube.training.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.training.model.JobTitle;
import com.metacube.training.util.ConnectionFactory;
import com.metacube.training.util.Status;

public class JobTitleDAO {
	private final static String SQL_INSERT_JOBTITLE = " INSERT INTO job_title(job_title) "
			+ "VALUES " + "(?)";

	public static Boolean create(JobTitle jobTitle) {
		try (Connection conn = ConnectionFactory.getconnection();
				PreparedStatement statement = conn
						.prepareStatement(SQL_INSERT_JOBTITLE);) {
			try {
				int result = statement.executeUpdate();
				if(result == 1)
				{
					return true;
				}
				else{
					return false;
				}

			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}

	}
}
