package com.techelevator;


	import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

	import org.junit.After;
	import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.JDBCParkDAO;
import com.techelevator.dao.JDBCSurveyDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Survey;

public class JDBCSurveyDAOTest {
	
		private JDBCSurveyDAO surveyDao;
		private JDBCParkDAO parkDao;
		private Survey survey;
		private JdbcTemplate jdbc;
		private static SingleConnectionDataSource dataSource;
		private Park testPark;
		
		
		
		private static final String PARK_CODE = "TMNT";
		private static final String EMAIL_ADDRESS = "email@gmail.com";
		private static final String STATE = "OH";
		private static final String ACTIVITY_LEVEL = "none";
		private static final String PARK_NAME = "Test Park";
		
		
		
;
		private static final int ACREAGE = 1234;
		private static final int ELEVATION_IN_FEET = 4567;
		private static final float MILES_OF_TRAIL = 7777f;
		private static final int NUMER_OF_CAMPSITES = 41;
		private static final String CLIMATE = "Climate";
		private static final int YEAR_FOUNDED = 1994;
		private static final int ANNUAL_VISITOR_COUNT = 123098;
		private static final String INSPIRATIONAL_QUOTE = "test quote";
		private static final String INSPIRATIONAL_QUOTE_SOURCE = "Test Quote Source";
		private static final String PARK_DESCRIPTION = "good park";
		private static final int ENTRY_FEE = 67;
		private static final int NUMBER_OF_ANIMAL_SPECIES = 2;

		
		/* Before any tests are run, this method initializes the datasource for testing. */
		@BeforeClass
		public static void setupDataSource() {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");
			/* The following line disables autocommit for connections 
			 * returned by this DataSource. This allows us to rollback
			 * any changes after each test */
			dataSource.setAutoCommit(false);
		}
		
		@Before
		public  void setup() {
			parkDao = new JDBCParkDAO(dataSource);
			surveyDao = new JDBCSurveyDAO(dataSource);
			jdbc = new JdbcTemplate(dataSource);
			testPark = makePark( PARK_CODE ,
			 PARK_NAME ,
			 STATE ,
			 ACREAGE ,
			 ELEVATION_IN_FEET ,
			 MILES_OF_TRAIL ,
			 NUMER_OF_CAMPSITES ,
			 CLIMATE ,
			 YEAR_FOUNDED ,
			 ANNUAL_VISITOR_COUNT ,
			 INSPIRATIONAL_QUOTE ,
			 INSPIRATIONAL_QUOTE_SOURCE ,
			 PARK_DESCRIPTION ,
			 ENTRY_FEE  ,
			 NUMBER_OF_ANIMAL_SPECIES);
			insertPark(testPark);
			
			survey = makeSurvey(PARK_CODE, EMAIL_ADDRESS, STATE, ACTIVITY_LEVEL);
			surveyDao.insertSurveyTest(survey);
			
			
			
		}
		/* After all tests have finished running, this method will close the DataSource */
		@AfterClass
		public static void closeDataSource() throws SQLException {
			dataSource.destroy();
		}

		/* After each test, we rollback any changes that were made to the database so that
		 * everything is clean for the next test */
		@After
		public void rollback() throws SQLException {
			dataSource.getConnection().rollback();
		}
		@Test
		public void insertSurveyInsertsASurvey() {
			
			List<Survey> surveyList = surveyDao.getAllSurveys();
			Assert.assertTrue(surveyList.contains(survey));
		}
		
		/* This method provides access to the DataSource for subclasses so that 
		 * they can instantiate a DAO for testing */
		public DataSource getDataSource() {
			return dataSource;
		}
		private Survey makeSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
			this.survey= new Survey();
			
			survey.setParkCode(parkCode);
			survey.setEmailAddress(emailAddress);
			survey.setState(state);
			survey.setActivityLevel(activityLevel);
			
			
			
			return survey;
			
			
		}

		private Park makePark(String parkCode, String parkName, String state, int acreage, int elevationInFeet,
				float milesOfTrail, int numberOfCampsites, String climate, int yearFounded, int annualVisitorCount,
				String inspirationalQuote, String quoteSource, String parkDescription, int entryFee, int numberOfSpecies) {
			this.testPark = new Park();

			testPark.setParkCode(parkCode);
			testPark.setParkName(parkName);
			testPark.setState(state);
			testPark.setAcreage(acreage);
			testPark.setElevationInFeet(elevationInFeet);
			testPark.setMilesOfTrail(milesOfTrail);
			testPark.setNumberOfCampsites(numberOfCampsites);
			testPark.setClimate(climate);
			testPark.setYearFounded(yearFounded);
			testPark.setAnnualVisitorCount(annualVisitorCount);
			testPark.setInspirationalQuote(inspirationalQuote);
			testPark.setQuoteSource(quoteSource);
			testPark.setParkDescription(parkDescription);
			testPark.setEntryFee(entryFee);
			testPark.setNumberOfSpecies(numberOfSpecies);
			return testPark;
		}
		private void insertPark(Park testPark) {
			String sqlMakeTestPark = "INSERT INTO park (parkcode, "+
					"parkname, " + 
					"state, " + 
					"acreage, " + 
					"elevationinfeet, " + 
					"milesoftrail, " + 
					"numberofcampsites, " + 
					"climate, " + 
					"yearfounded, " + 
					"annualvisitorcount, " + 
					"inspirationalquote, " + 
					"inspirationalquotesource, " + 
					"parkdescription, " + 
					"entryfee, " + 
					"numberofanimalspecies) VALUES (?, ?, ?, ?, ?, ?, ?, "
					+ "?, ? ,? ,? ,? ,?, ?, ?)";
			jdbc.update(sqlMakeTestPark, testPark.getParkCode(), testPark.getParkName(), testPark.getState(), testPark.getAcreage(),
					testPark.getElevationInFeet(), testPark.getMilesOfTrail(), testPark.getNumberOfCampsites(), testPark.getClimate(), testPark.getYearFounded(),
					testPark.getAnnualVisitorCount(), testPark.getInspirationalQuote(), testPark.getQuoteSource(), testPark.getParkDescription(),
					testPark.getEntryFee(), testPark.getNumberOfSpecies());
			
//			testPark.setParkCode(results.getString("parkcode"));
			
		}
	
	}


