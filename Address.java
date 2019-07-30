package com.claim;

public class Address {
	private String streetName;
	private String cityName;
	private String stateName;
	private String zipCode;
	
	
	public Address(String streetName, String cityName, String stateName, String zipCode) {

		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}
	

	@Override
//	public String toString() {
//		return "Address [streetName=" + streetName + ", cityName=" + cityName
//				+ ", stateName=" + stateName + ", zipCode=" + zipCode + "]";
//	}
	
	public String toString() {
		return streetName + ","+ cityName +","
				+ stateName +","+ zipCode;
	}

	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
