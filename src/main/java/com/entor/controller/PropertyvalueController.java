package com.entor.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Propertyvalue;
import com.entor.service.PropertyvalueService;

@Controller
public class PropertyvalueController {
	
	
	@Resource
	private PropertyvalueService propertyvalueService;
	
	
	@RequestMapping("/admin_propertyValue_update")
	public void update(HttpServletRequest request,HttpServletResponse response) {
		Propertyvalue pt = new Propertyvalue();
		pt.setId(Integer.parseInt(request.getParameter("id")));
		pt.setValue(request.getParameter("value"));
		propertyvalueService.update(pt);
		try {
			response.getWriter().write("成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
