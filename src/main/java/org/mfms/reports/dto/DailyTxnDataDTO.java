package org.mfms.reports.dto;

public class DailyTxnDataDTO {
	private String DistrictName;
	private String BlockName;
	private String RetailerId;
	private String dateOfTxn;
	private int noOfBills;
	private int noOfTxn;
	private double quantitySold;
	
	
	public String getDistrictName() {
		return DistrictName;
	}
	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}
	public String getBlockName() {
		return BlockName;
	}
	public void setBlockName(String blockName) {
		BlockName = blockName;
	}
	public String getRetailerId() {
		return RetailerId;
	}
	public void setRetailerId(String retailerId) {
		RetailerId = retailerId;
	}
	public String getDateOfTxn() {
		return dateOfTxn;
	}
	public void setDateOfTxn(String dateOfTxn) {
		this.dateOfTxn = dateOfTxn;
	}
	public int getNoOfBills() {
		return noOfBills;
	}
	public void setNoOfBills(int noOfBills) {
		this.noOfBills = noOfBills;
	}
	public int getNoOfTxn() {
		return noOfTxn;
	}
	public void setNoOfTxn(int noOfTxn) {
		this.noOfTxn = noOfTxn;
	}
	public double getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(double quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	public String toString(){
		System.out.println(getDistrictName());		
		System.out.println(getBlockName());		
		System.out.println(getDateOfTxn());			
		System.out.println(getNoOfBills());
		System.out.println(getNoOfTxn());	
		System.out.println(getQuantitySold());
		return null;
	}


}
