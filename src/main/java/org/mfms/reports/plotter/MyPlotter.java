package org.mfms.reports.plotter;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.mfms.reports.dto.DailyTxnDataDTO;

public class MyPlotter {

	   public static void plotDateWiseChart(String chartTitle, List<DailyTxnDataDTO> dailyTxnDataDTOs) {
		      
		      Day currentDay; 
		      int year;
		      int month;
		      int date;
		      
		       TimeSeries noOfBills = new TimeSeries( "No. of Bills");
		       TimeSeries noOfTxn = new TimeSeries( "No. Of Transaction" );
		       TimeSeries quantitySold = new TimeSeries( "Quantity Sold (in MT)" );

		      for(DailyTxnDataDTO dto : dailyTxnDataDTOs){
		    	  year = Integer.parseInt((dto.getDateOfTxn()).substring(0,4));
		    	  month = Integer.parseInt((dto.getDateOfTxn()).substring(5,7));
		    	  date = Integer.parseInt((dto.getDateOfTxn()).substring(8));

		    	  currentDay = new Day(date,month,year);

		    	  noOfBills.add(currentDay, dto.getNoOfBills() );
		    	  noOfTxn.add(currentDay, dto.getNoOfTxn() );
		    	  quantitySold.add(currentDay, dto.getQuantitySold() );
		      }	  
		      
		      TimeSeriesCollection dataset = new TimeSeriesCollection( );
		      dataset.addSeries( noOfBills );
		      dataset.addSeries( noOfTxn );
		      dataset.addSeries( quantitySold );
		      
		      JFreeChart timechart = ChartFactory.createTimeSeriesChart(
		    	 chartTitle, 
		         "Date",
		         "Value", 
		         dataset,
		         false, 
		         false, 
		         false);
		     
		      int width = 1200;   // Width of the image 
		      int height = 700;  // Height of the image 
		      
		      try{
		          File timeChart = new File( "DailyTxnChart.jpeg" ); 
		          ChartUtilities.saveChartAsJPEG( timeChart, timechart, width, height );		 	
		      }catch(Exception Ex){
		    	  
		      }
		   }
}
