package com.training.spring.model;

public class Country {
	private String countryCode;
	private String countryName;

	public Country() {
		super();
	}

	public Country(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [countryCode=");
		builder.append(countryCode);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append("]");
		return builder.toString();
	}

}
