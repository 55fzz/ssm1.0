package com.entor.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Property;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;


@Controller
public class PropertyController {

	@Resource
	private PropertyService propertyService;
	
	@RequestMapping("/admin_property_add")
	public String add(HttpServletRequest request) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		Property p = new Property();
		Category c = new Category();
		c.setId(cid);
		p.setCategory(c);
		p.setName(name);
		propertyService.add(p);
		return "redirect:/admin_property_list/"+cid+"/1";
	}
	
	
	@RequestMapping("/admin_property_delete")
	public String delete(int id,int cid) {
		propertyService.deleteById(Property.class, id);
		return "redirect:/admin_property_list/"+cid+"/1";
	}
	
	@RequestMapping("/admin_property_update")
	public String update(String name,int id,int cid) {
		Property p = new Property();
		p.setId(id);
		p.setName(name);
		propertyService.update(p);
		return "redirect:/admin_property_list/"+cid+"/1";
	}
}
