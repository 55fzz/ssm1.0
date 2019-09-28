package com.entor.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.User;
import com.entor.service.UserService;
@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	@Autowired
    HttpServletRequest request;
	
	
	@RequestMapping("/forelogin")
	public String forelogin(User u) {
		String url= "";
		User user = null;
		user = userService.login(User.class, u);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			url="redirect:/home";
		}else {
			url="redirect:/loginPage";
		}
		return url;
	}
	
	@RequestMapping("/forelogout")
	public String forelogout() {
		request.getSession().invalidate();
		return "redirect:/home";
	}
	@RequestMapping("/foreregister")
	public String add(User u) {
		userService.add(u);
		return "redirect:/loginPage";
	}
	
	
	@ResponseBody
	@RequestMapping("/ajaxLogin")
	public void ajaxLogin(String name,String password) {
		System.out.println(name);
		System.out.println(password);
	}
}
