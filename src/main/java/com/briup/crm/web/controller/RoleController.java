package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.SysRole;
import com.briup.crm.service.RoleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/toRole/{curPage}")
	public String toRole(@PathVariable int curPage, HttpSession session) {
		PageInfo<SysRole> roleInfo = roleService.findSysRole(curPage, 5);
		session.setAttribute("roleInfo", roleInfo);
		return "system/role";
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(SysRole role) {
		roleService.saveOrUpdate(role);
		return "保存成功";
	}
	
	@RequestMapping("/deleteRoleById/{roleId}")
	@ResponseBody
	public String deleteRoleById(@PathVariable long roleId) {
		roleService.deleteRoleById(roleId);
		return "删除成功";
	}
	
	@RequestMapping("/findRoleById/{roleId}")
	@ResponseBody
	public SysRole findRoleById(@PathVariable long roleId) {
		SysRole role = roleService.findRoleById(roleId);
		return role;
	}
}
