package org.mfms.reports.controller;

import org.mfms.reports.command.FilterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportsController {
	
    @RequestMapping("/dbtchart")
	public String plotChart(Model m){
    	m.addAttribute("command", new FilterDTO());
        return "dbtchart"; //JSP - /WEB-INF/view/dbtchart.jsp				
	
	}
}
