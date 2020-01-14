package com.briup.crm.service;

import com.briup.crm.bean.SalPlan;
import com.github.pagehelper.PageInfo;

public interface PlanService {
	
	public void savePlan(SalPlan plan, long chanceId);
	
	public void saveOrUpdate(SalPlan plan);
	
	public SalPlan findPlanByPlaId(long plaId);
	
	public void deletePlanById(long plaId);
	
}