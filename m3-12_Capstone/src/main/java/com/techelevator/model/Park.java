package com.techelevator.model;

public class Park {
	
private String parkCode;
private String parkName;
private String state;
private int acreage;
private int elevationInFeet;
private float milesOfTrail;
private int numberOfCampsites;
private String climate;
private int yearFounded;
private int annualVisitorCount;
private String inspirationalQuote;
private String quoteSource; 
private String parkDescription;
private int entryFee;

public String getParkCode() {
	return parkCode;
}
public void setParkCode(String parkCode) {
	this.parkCode = parkCode;
}
public String getParkName() {
	return parkName;
}
public void setParkName(String parkName) {
	this.parkName = parkName;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getAcreage() {
	return acreage;
}
public void setAcreage(int acreage) {
	this.acreage = acreage;
}
public int getElevationInFeet() {
	return elevationInFeet;
}
public void setElevationInFeet(int elevationInFeet) {
	this.elevationInFeet = elevationInFeet;
}
public float getMilesOfTrail() {
	return milesOfTrail;
}
public void setMilesOfTrail(float milesOfTrail) {
	this.milesOfTrail = milesOfTrail;
}
public int getNumberOfCampsites() {
	return numberOfCampsites;
}
public void setNumberOfCampsites(int numberOfCampsites) {
	this.numberOfCampsites = numberOfCampsites;
}
public String getClimate() {
	return climate;
}
public void setClimate(String climate) {
	this.climate = climate;
}
public int getYearFounded() {
	return yearFounded;
}
public void setYearFounded(int yearFounded) {
	this.yearFounded = yearFounded;
}
public int getAnnualVisitorCount() {
	return annualVisitorCount;
}
public void setAnnualVisitorCount(int annualVisitorCount) {
	this.annualVisitorCount = annualVisitorCount;
}
public String getInspirationalQuote() {
	return inspirationalQuote;
}
public void setInspirationalQuote(String inspirationalQuote) {
	this.inspirationalQuote = inspirationalQuote;
}
public String getQuoteSource() {
	return quoteSource;
}
public void setQuoteSource(String quoteSource) {
	this.quoteSource = quoteSource;
}
public String getParkDescription() {
	return parkDescription;
}
public void setParkDescription(String parkDescription) {
	this.parkDescription = parkDescription;
}
public int getEntryFee() {
	return entryFee;
}
public void setEntryFee(int entryFee) {
	this.entryFee = entryFee;
}
public int getNumberOfSpecies() {
	return numberOfSpecies;
}
public void setNumberOfSpecies(int numberOfSpecies) {
	this.numberOfSpecies = numberOfSpecies;
}
private int numberOfSpecies;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((parkCode == null) ? 0 : parkCode.hashCode());
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
	Park other = (Park) obj;
	if (parkCode == null) {
		if (other.parkCode != null)
			return false;
	} else if (!parkCode.equals(other.parkCode))
		return false;
	return true;
}

}
