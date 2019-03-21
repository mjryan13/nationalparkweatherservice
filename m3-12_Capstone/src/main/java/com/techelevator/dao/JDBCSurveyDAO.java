package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;
import com.techelevator.model.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertSurvey(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel)" + 
		"VALUES (?, ?, ?, ?)";
		jdbc.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlGetAllSurveys = "SELECT park.parkname, COUNT(survey_result.parkcode), park.parkcode FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode "+ 
				"WHERE park.parkcode IS NOT NULL "+
				"GROUP BY  park.parkname , park.parkcode "+
				"ORDER BY count DESC";
		SqlRowSet results = jdbc.queryForRowSet(sqlGetAllSurveys);
		while (results.next()) {
			Survey p = mapRowToSurvey(results);
			allSurveys.add(p);
		}
		return allSurveys;
	}
	private Survey mapRowToSurvey(SqlRowSet results) {
		
		Survey survey = new Survey();
		survey.setParkCode(results.getString("parkcode"));
		survey.setParkName(results.getString("parkname"));
		survey.setSurveyCount(results.getInt("count"));
		
		
		
		return survey;
	
		
	}

	@Override
	public void insertSurveyTest(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel)" + 
		"VALUES (?, ?, ?, ?) RETURNING surveyid";
		SqlRowSet results = jdbc.queryForRowSet(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		results.next();
		survey.setSurveyId(results.getInt("surveyid"));
	}
	
}
