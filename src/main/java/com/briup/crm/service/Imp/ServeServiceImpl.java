package com.briup.crm.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.CstServiceExample;
import com.briup.crm.dao.CstServiceMapper;
import com.briup.crm.service.ServeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ServeServiceImpl implements ServeService {

	@Autowired
	private CstServiceMapper serviceMapper;
	
	@Override
	public PageInfo<CstService> findServiceByUserName(int curPage, int size, String userName) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrDisposeEqualTo(userName);
		List<CstService> servicelist = serviceMapper.selectByExample(example);
		PageInfo<CstService> serviceInfo = new PageInfo<CstService>(servicelist);
		return serviceInfo;
	}
	
	@Override
	public PageInfo<CstService> findServiceLike(int curPage, int size, String custName, String svrType, String userName) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrCustNameLike("%"+custName+"%").andSvrTypeEqualTo(svrType).andSvrDisposeEqualTo(userName);
		List<CstService> servicelist = serviceMapper.selectByExample(example);
		PageInfo<CstService> serviceInfo = new PageInfo<CstService>(servicelist);
		return serviceInfo;
	}

	@Override
	public void saveOrUpdate(CstService service) {
		if (service.getSvrId() == null) {
			serviceMapper.insertSelective(service);
		} else {
			serviceMapper.updateByPrimaryKeySelective(service);
		}
	}

	@Override
	public CstService findServiceBySvrId(long svrId) {
		CstService service = serviceMapper.selectByPrimaryKey(svrId);
		return service;
	}

	@Override
	public PageInfo<CstService> findAllService(int curPage, int size) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		List<CstService> servicelist = serviceMapper.selectByExample(example);
		PageInfo<CstService> serviceInfo = new PageInfo<CstService>(servicelist);
		return serviceInfo;
	}

	@Override
	public PageInfo<CstService> findFeedBackLike(int curPage, int size, String svrType, String svrStatus) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrTypeLike("%"+svrType+"%").andSvrStatusLike("%"+svrStatus+"%");
		List<CstService> servicelist = serviceMapper.selectByExample(example);
		PageInfo<CstService> serviceInfo = new PageInfo<CstService>(servicelist);
		return serviceInfo;
	}
	
}
