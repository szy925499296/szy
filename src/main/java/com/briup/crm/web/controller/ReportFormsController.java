package com.briup.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.Contribution;
import com.briup.crm.service.ConstituteService;
import com.briup.crm.service.ContributionService;

@Controller
@RequestMapping("/reportForms")
public class ReportFormsController {
	
	@Autowired
	private ContributionService conService;
	
	@Autowired
	private ConstituteService consService;

	@RequestMapping("/toContribution")
	public String toContribution() {
		return "reportForms/customerContribution";
	}
	
	@RequestMapping("/getContribution")
	@ResponseBody
	public List<Contribution> getContribution() {
		List<Contribution> conlist = conService.findContribution();
		return conlist;
	}
	
	@RequestMapping("/getContributionByRegion")
	@ResponseBody
	public List<Contribution> getContributionByRegion(String region) {
		List<Contribution> conlist = conService.findContributionByRegion(region);
		return conlist;
	}
	
	@RequestMapping("/toConstitute")
	public String toConstitute() {
		return "reportForms/customerConstitute";
	}
	
//	@RequestMapping("/getConstitute")
//	@ResponseBody
//	public List<Contribution> getConstitute() {
//		List<Contribution> conlist = conService.findConstitute();
//		return conlist;
//	}
	
	@RequestMapping("/getConstitute")
	@ResponseBody
	public List<Contribution> getConstitute(int condition) {
		List<Contribution> conlist = consService.findCustMarkup(condition);
		return conlist;
	}
	
}
