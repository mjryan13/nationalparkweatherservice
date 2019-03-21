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
import com.techelevator.dao.JDBCWeatherDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Weather;

public class JDBCWeatherDAOTest {

	





		private static SingleConnectionDataSource dataSource;
		private JDBCParkDAO parkDao;
		private JDBCWeatherDAO weatherDao;
		private JdbcTemplate jdbc;
		
		private Weather testWeather;

		private static final String PARK_CODE = "TMNT";
		private static final int FIVE_DAY_FORECAST_VALUE = 1;
		private static final int LOW = 2;
		private static final int HIGH = 89;
		private static final String FORECAST = "good";

		private Park testPark;

		
		private static final String PARK_NAME = "Test Park";
		private static final String STATE = "OH";
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
		
		
		@BeforeClass
		public static void setupDataSource() {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");

			dataSource.setAutoCommit(false);
		}

		@Before
		public void setup() {
			weatherDao = new JDBCWeatherDAO(dataSource);
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
			
			
			testWeather = makeWeather(PARK_CODE, FIVE_DAY_FORECAST_VALUE , LOW , HIGH , FORECAST);
			insertWeather(testWeather);
			
			parkDao = new JDBCParkDAO(dataSource);
			
			
			
		}

		
		@AfterClass
		public static void closeDataSource() throws SQLException {
			dataSource.destroy();
		}

		
		@After
		public void rollback() throws SQLException {
			dataSource.getConnection().rollback();
		}

		
		public DataSource getDataSource() {
			return dataSource;
		}
		@Test
		public void getWeatherByParkCodeGetsWeather() {
			List<Weather> weatherList = weatherDao.getWeatherByParkCode("TMNT");
			
			Assert.assertEquals(89, weatherList.get(0).getHigh());
			Assert.assertEquals("TMNT", weatherList.get(0).getParkCode());
			
		}
		@Test
		public void getWeatherByParkCodeFailsIfWrongCode() {
			List<Weather> weatherList = weatherDao.getWeatherByParkCode("TMNT");
			
			
			Assert.assertEquals("this test should fail", "FAIL", weatherList.get(0).getParkCode());
			
		}
		
		

		private Weather makeWeather(String parkCode, int fiveDayForecastValue, int low, int high, String forecast) {
			this.testWeather = new Weather();
			testWeather.setParkCode(parkCode);
			testWeather.setFiveDayForecastValue(fiveDayForecastValue);
			testWeather.setLow(low);
			testWeather.setHigh(high);
			testWeather.setForecast(forecast);
			
			return testWeather;
			
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
		private void insertWeather(Weather testWeather) {
			String sqlMakeTestWeather = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) VALUES(?, ?, ?, ?, ?)";
			jdbc.update(sqlMakeTestWeather, testWeather.getParkCode(), testWeather.getFiveDayForecastValue(), testWeather.getLow(), testWeather.getHigh(), testWeather.getForecast());
			
//			testPark.setParkCode(results.getString("parkcode"));
			
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

