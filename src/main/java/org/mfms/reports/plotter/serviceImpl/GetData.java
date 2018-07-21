package org.mfms.reports.serviceImpl;

import java.util.List;

import org.mfms.reports.daoImpl.GetDataFromDB;
import org.mfms.reports.dto.DailyTxnDataDTO;
import org.mfms.reports.dto.FilterDTO;
import org.mfms.reports.plotter.MyPlotter;
import org.mfms.reports.service.GetDataItr;

public class GetData implements GetDataItr {

	//@Override
	public static void getRetailerDataForDateRange(FilterDTO filterDTO) {
		String chartTitle;
		List<DailyTxnDataDTO> dailyTxnDataDTOs = GetDataFromDB.getRetailerDataForDateRange(filterDTO);
		chartTitle = "Transaction data for Retailer with id " + filterDTO.getRetailerId();
		
		MyPlotter.plotDateWiseChart(chartTitle, dailyTxnDataDTOs);		
	}
	
	
	//@Override
	public static void getBlockDataForDateRange(FilterDTO filterDTO) {
		String chartTitle;
		List<DailyTxnDataDTO> dailyTxnDataDTOs = GetDataFromDB.getBlockDataForDateRange(filterDTO);
		chartTitle = "Transaction data for " + filterDTO.getBlockName() + " Block of " + filterDTO.getDistrictName() + " District" ;

		MyPlotter.plotDateWiseChart(chartTitle, dailyTxnDataDTOs);		
	}

}
