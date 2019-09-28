package com.entor.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.service.ProductService;


@Controller
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	@RequestMapping("/admin_product_add")
	public String add(Product p,int cid) {
		Category c = new Category();
		c.setId(cid);
		p.setCategory(c);
		productService.add(p);
		return "redirect:/admin_product_list/"+cid+"/1";
	}
	
	
	@RequestMapping("/admin_product_update")
	public String adminProductUpdate(Product p,int cid) {
		productService.update(p);
		return "redirect:/admin_product_list/"+cid+"/1";
	}
}
