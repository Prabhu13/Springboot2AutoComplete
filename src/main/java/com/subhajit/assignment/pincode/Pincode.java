package com.subhajit.assignment.pincode;

import com.opencsv.bean.CsvBindByName;

/**
 * @author Subhajit
 * @since Jul-2019
 *
 */
public class Pincode {

	@CsvBindByName(column = "Circle Name")
	private String circleName;
	@CsvBindByName(column = "Region Name")
	private String regionName;
	@CsvBindByName(column = "Division Name")
	private String divisionName;
	@CsvBindByName(column = "Pincode")
	private int pincode;
	@CsvBindByName(column = "OfficeType")
	private String officeType;
	@CsvBindByName(column = "Delivery")
	private String delivery;
	@CsvBindByName(column = "District")
	private String district;
	@CsvBindByName(column = "StateName")
	private String stateName;

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}