package com.graph.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController  {
	
	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		
		Map<String,Integer> surveyMap = new HashMap<>();
		surveyMap.put("Java",40);
		surveyMap.put(".Net",15);
		surveyMap.put("Dev oops",25);
		surveyMap.put("Python",20);
		model.addAttribute("surveyMap",surveyMap);
		
		
		return "barGraph";
		
	}
	
	@GetMapping("displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass",70);
		model.addAttribute("fail",30);
		return "PieChart";
	}

}
