package com.entor.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.entor.entity.ProducTimage;
import com.entor.entity.Product;
import com.entor.service.ProducTimageService;

@Controller
public class ProducTimageController {
	
	@Resource
	private ProducTimageService producTimageService;
	
	@RequestMapping("/admin_productImage_add")
	public String admin_productImage_add(int pid,String type, HttpServletRequest request,MultipartFile image) {
		ProducTimage pt = new ProducTimage();
		Product p = new Product();
		p.setId(pid);
		pt.setProduct(p);
		pt.setType(type);
		producTimageService.add(pt);
		String path = "";
		if(type.equals("type_single")) {
			path = request.getSession().getServletContext().getRealPath("/img/productSingle");
		}else {
			path = request.getSession().getServletContext().getRealPath("/img/productDetail");
		}
		
		String fileName = pt.getId()+".jpg";
		 try {
			image.transferTo(new File(path,fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "redirect:/admin_productImage_list/"+pid;
	}
}
