package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.SysUser;
import com.briup.crm.service.ServeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private ServeService serveService;
	
	@RequestMapping("/findServiceByUserName/{curPage}")
	public String findServiceByUserName(@PathVariable int curPage, HttpSession session) {
		SysUser user = (SysUser) session.getAttribute("user");
		PageInfo<CstService> serviceInfo = serveService.findServiceByUserName(curPage, 5, user.getUsrName());
		session.setAttribute("serviceInfo", serviceInfo);
		return "service/service";
	}
	
	@RequestMapping("/findServiceLike/{curPage}")
	public String findServiceLike(@PathVariable int curPage, String custName, String svrType, HttpSession session) {
		SysUser user = (SysUser) session.getAttribute("user");
		PageInfo<CstService> serviceInfo = serveService.findServiceLike(curPage, 5, custName, svrType, user.getUsrName());
		session.setAttribute("serviceInfo", serviceInfo);
		return "service/serviceLike";
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(CstService service) {
		serveService.saveOrUpdate(service);
		return "保存成功";
	}
	
	@RequestMapping("/findServiceBySvrId/{svrId}")
	@ResponseBody
	public CstService findServiceBySvrId(@PathVariable long svrId) {
		CstService service = serveService.findServiceBySvrId(svrId);
		return service;
	}
	
	@RequestMapping("/toServiceDetails2/{svrId}")
	public String toServiceDetails2(@PathVariable long svrId, HttpSession session) {
		CstService service = serveService.findServiceBySvrId(svrId);
		session.setAttribute("service", service);
		return "service/serviceDetails2";
	}
	
	@RequestMapping("/findAllService/{curPage}")
	public String findAllService(@PathVariable int curPage, HttpSession session) {
		PageInfo<CstService> serviceInfo = serveService.findAllService(curPage, 5);
		session.setAttribute("serviceInfo", serviceInfo);
		return "service/feedback";
	}
	
	@RequestMapping("/toServiceDetails/{svrId}")
	public String toServiceDetails(@PathVariable long svrId, HttpSession session) {
		CstService service = serveService.findServiceBySvrId(svrId);
		session.setAttribute("service", service);
		return "service/serviceDetails";
	}
	
	@RequestMapping("/findFeedBackLike/{curPage}")
	public String findFeedBackLike(@PathVariable int curPage, String svrType, String svrStatus, HttpSession session) {
		PageInfo<CstService> serviceInfo = serveService.findFeedBackLike(curPage, 5, svrType, svrStatus);
		session.setAttribute("serviceInfo", serviceInfo);
		return "service/serviceLike";
	}
}
