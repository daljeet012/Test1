package org.mfms.reports.main;

import org.mfms.reports.dto.FilterDTO;
import org.mfms.reports.serviceImpl.GetData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static ApplicationContext context;
	
	public static void main(String[] args){

		context = new ClassPathXmlApplicationContext("spring.xml");
		FilterDTO filter = (FilterDTO) context.getBean("filterDTO");
			
	//	GetData.getRetailerDataForDateRange(filter);	
		GetData.getBlockDataForDateRange(filter);	
	}	
}
