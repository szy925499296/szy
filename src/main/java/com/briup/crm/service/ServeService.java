package com.briup.crm.service;

import java.util.List;

import com.briup.crm.bean.CstService;
import com.github.pagehelper.PageInfo;

public interface ServeService {
	
	public PageInfo<CstService> findServiceByUserName(int curPage, int size, String userName);
	
	public PageInfo<CstService> findServiceLike(int curPage, int size, String custName, String svrType, String userName);
	
	public void saveOrUpdate(CstService service);
	
	public CstService findServiceBySvrId(long svrId);
	
	public PageInfo<CstService> findAllService(int curPage, int size);
	
	public PageInfo<CstService> findFeedBackLike(int curPage, int size, String svrType, String svrStatus);
	
}
