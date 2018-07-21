package org.mfms.reports.command;

public class FilterDTO {
	private String DistrictName;
	private String BlockName;
	private String RetailerId;
	private String FromDate;
	private String ToDate;
	private String FromMonth;
	private String ToMonth;
	private boolean DateWise;
	private boolean MonthWise;

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
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getFromMonth() {
		return FromMonth;
	}
	public void setFromMonth(String fromMonth) {
		FromMonth = fromMonth;
	}
	public String getToMonth() {
		return ToMonth;
	}
	public void setToMonth(String toMonth) {
		ToMonth = toMonth;
	}
	public boolean isDateWise() {
		return DateWise;
	}
	public void setDateWise(boolean dateWise) {
		DateWise = dateWise;
	}
	public boolean isMonthWise() {
		return MonthWise;
	}
	public void setMonthWise(boolean monthWise) {
		MonthWise = monthWise;
	}
	
}
