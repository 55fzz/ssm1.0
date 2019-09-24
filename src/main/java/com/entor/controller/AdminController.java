package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Property;
import com.entor.entity.SP;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;

@Controller
public class AdminController {

	@Resource
	private CategoryService categoryService;
	
	@Resource
	private PropertyService propertyService;
	
	
	@RequestMapping("/admin_category_list/{currentPage}")
	public String adminCategoryList(@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = categoryService.getTotals(Category.class);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			sp = 1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		SP s = new SP();
		s.setStart((sp-1)*pageSize);
		s.setPageSize(pageSize);
		List<Category> cs =  categoryService.queryByPage(Category.class, s);
		map.put("cs", cs);
		map.put("page", sp);
		map.put("pageCounts", pageCounts);
		map.put("   ", "/admin_category_list");
		return "/admin/listCategory";
	}
	
	
	
	@RequestMapping("admin_category_edit/{id}")
	public String adminCategoryEdit(@PathVariable int id,Map<String,Object> map) {
		Category c = categoryService.queryById(Category.class, id);
		map.put("c", c);
		return "/admin/editCategory";
	}
	
	
	
	@RequestMapping("admin_property_list/{cid}/{currentPage}")
	public String adminPropertyList(@PathVariable int cid,@PathVariable(required = false) String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = propertyService.getTotals(Property.class,cid);
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			sp = 1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		SP s = new SP();
		s.setStart((sp-1)*pageSize);
		s.setPageSize(pageSize);
		Map<String, Object> m = new HashMap();
		m.put("sp", s);
		m.put("id", cid);
		List<Property> list = propertyService.queryByPage(Property.class, m);
		Category c = categoryService.queryById(Category.class, cid);
		map.put("ps", list);
		map.put("c", c);
		map.put("page", sp);
		map.put("pageCounts", pageCounts);
		map.put("url", "/admin_property_list/"+cid);
		return "/admin/listProperty";
				
	}
	@RequestMapping("/admin_property_edit")
	public String adminPropertyEdit(int id,Map<String,Object> map) {
		Property p = propertyService.queryById(Property.class, id);
		map.put("p", p);
		return "/admin/editProperty";
	}
	
}
