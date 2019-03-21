package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Survey;

public interface SurveyDAO {
	
	public void insertSurvey(Survey survey);
	public List<Survey> getAllSurveys();
	public void insertSurveyTest(Survey survey);

}
