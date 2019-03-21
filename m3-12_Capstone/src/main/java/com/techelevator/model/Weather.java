package com.techelevator.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Weather {
	private String dayOfWeek;
	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private int lowC;
	private int highC;
	private boolean isCelcius = true;
	
	public boolean getIsCelcius() {
		return isCelcius;
	}
	public void setCelcius(boolean isCelcius) {
		this.isCelcius = isCelcius;
	}
	public int getLowC() {
		return (low - 32) * 5 /9;
	}
	public void setLowC(int lowC) {
		this.lowC = lowC;
	}
	public int getHighC() {
		return (high -32) * 5 /9;
	}
	public void setHighC(int highC) {
		this.highC = highC;
	}
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public String getDayOfWeek() {
		
		if(fiveDayForecastValue == 1) {
			return LocalDateTime.now().getDayOfWeek().toString();
		}
		if(fiveDayForecastValue == 2) {
			return LocalDateTime.now().plusDays(1).getDayOfWeek().toString();
		}
		if(fiveDayForecastValue == 3) {
			return LocalDateTime.now().plusDays(2).getDayOfWeek().toString();
		}
		if(fiveDayForecastValue == 4) {
			return LocalDateTime.now().plusDays(3).getDayOfWeek().toString();
		}
		if(fiveDayForecastValue == 5) {
			return LocalDateTime.now().plusDays(4).getDayOfWeek().toString();
		}
		return dayOfWeek;
	}
	
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fiveDayForecastValue;
		result = prime * result + ((forecast == null) ? 0 : forecast.hashCode());
		result = prime * result + high;
		result = prime * result + low;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (fiveDayForecastValue != other.fiveDayForecastValue)
			return false;
		if (forecast == null) {
			if (other.forecast != null)
				return false;
		} else if (!forecast.equals(other.forecast))
			return false;
		if (high != other.high)
			return false;
		if (low != other.low)
			return false;
		return true;
	}



}
