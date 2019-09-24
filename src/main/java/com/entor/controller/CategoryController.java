package com.entor.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.entor.entity.Category;
import com.entor.entity.SP;
import com.entor.service.CategoryService;

@Controller
public class CategoryController {

	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("/admin_category_add")
	public String add(HttpServletRequest request, MultipartFile image) {
		Category c = new Category();
		String name = request.getParameter("name");
		c.setName(name);
		categoryService.add(c);
		String path = request.getSession().getServletContext().getRealPath("/img/category");
		String fileName = c.getId()+".jpg";
		 try {
			image.transferTo(new File(path,fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin_category_list/1";
	}
	
	
	@RequestMapping("/admin_category_deleteMore")
	public String delete(String[] ids) {
		for (String id : ids) {
			categoryService.deleteById(Category.class, Integer.parseInt(id));
		}
		return "redirect:/admin_category_list/1";
	}
	@RequestMapping("/admin_category_delete")
	public String delete(int id) {
		categoryService.deleteById(Category.class, id);
		
		return "redirect:/admin_category_list/1";
	}
	
	
	@RequestMapping("/admin_category_update")
	public String update(HttpServletRequest request, MultipartFile image) {
		Category c = new Category();
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		c.setId(id);
		c.setName(name);
		categoryService.update(c);
		if(image.getOriginalFilename().length()>0) {
			String path = request.getSession().getServletContext().getRealPath("/img/category");
			String fileName = c.getId()+".jpg";
			try {
				image.transferTo(new File(path,fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin_category_list/1";
	}
	
	@RequestMapping("/admin_category_queryById")
	public Category queryById(int id) {
		return categoryService.queryById(Category.class, id);
	}
	
	
	
}
