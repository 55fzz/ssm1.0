package com.entor.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.Orderitem;
import com.entor.entity.Product;
import com.entor.entity.User;
import com.entor.service.OrderitemService;

@Controller
public class OrderitemController {
	
	@Resource
	private OrderitemService orderitemService;
	
	@ResponseBody
	@RequestMapping("/foreaddCart")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int num = Integer.parseInt(request.getParameter("num"));
		User user = (User) request.getSession().getAttribute("user");
		Product p = new Product();
		p.setId(pid);
		Orderitem orderitem = new Orderitem();
		orderitem.setProduct(p);
		orderitem.setNumber(num);
		orderitem.setUser(user);
		Orderitem o = null;
		o = orderitemService.queryByUidAndPid(orderitem);
		if(o == null) {
			orderitemService.add(orderitem);
			return "success";
		}else {
			orderitemService.update(orderitem);
			return "success";
		}
	}
	
	
}
