package com.briup.crm.service.Imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.Contribution;
import com.briup.crm.service.ConstituteService;
import com.briup.crm.service.CustomerService;

@Service
public class ConstituteServiceImpl implements ConstituteService {

	@Autowired
	private CustomerService custService;
	
	@Override
	public List<Contribution> findCustMarkup(int condition) {
		// 创建List用于保存Contribution
		List<Contribution> conlist = new ArrayList<Contribution>();
		// 所有顾客的人数
		int count = custService.findAllCustomer().size();
		if (condition == 0) { // 按等级
			// 获得所有的等级
			Set<String> levels = custService.findAllLevel();
			for (String level: levels) {
				// 获得不同等级对应的顾客数
				int size = custService.getCustByLevel(level);
				// 获得每个等级所占百分比
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(level);
				con.setY(percent);
				conlist.add(con);
			}
		} else if (condition == 1) { // 按信用度
			Set<Integer> credits = custService.findAllCredit();
			for (Integer credit: credits) {
				int size = custService.getCustByCredit(credit);
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(""+credit);
				con.setY(percent);
				conlist.add(con);
			}
		} else if (condition == 2) { // 按满意度
			Set<Integer> satisfys = custService.findAllSatisfy();
			for (Integer satisfy: satisfys) {
				int size = custService.getCustBySatisfy(satisfy);
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(""+satisfys);
				con.setY(percent);
				conlist.add(con);
			}
		}
		return conlist;
	}

}
