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
import com.entor.entity.Order;
import com.entor.entity.Orderitem;
import com.entor.entity.ProducTimage;
import com.entor.entity.Product;
import com.entor.entity.Property;
import com.entor.entity.Propertyvalue;
import com.entor.entity.Review;
import com.entor.entity.SP;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.OrderService;
import com.entor.service.OrderitemService;
import com.entor.service.ProducTimageService;
import com.entor.service.ProductService;
import com.entor.service.PropertyService;
import com.entor.service.PropertyvalueService;
import com.entor.service.UserService;

@SuppressWarnings("unused")
@Controller
public class AdminController {

	@Resource
	private CategoryService categoryService;
	
	@Resource
	private PropertyService propertyService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private OrderService orderService;
	
	
	@Resource
	private OrderitemService orderitemService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private ProducTimageService producTimageService;
	
	@Resource
	private PropertyvalueService propertyvalueService;
	
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
		map.put("url", "/admin_category_list");
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
	
	
	@RequestMapping("/admin_user_list/{currentPage}")
	public String adminUserList(@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = userService.getTotals(User.class);
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
		List<User> list = userService.queryByPage(User.class, s);
		map.put("us", list);
		map.put("page", sp);
		map.put("pageCounts", pageCounts);
		map.put("url", "/admin_user_list");
		return "/admin/listUser";
	}
	
	@RequestMapping("/admin_order_list/{currentPage}")
	public String adminOrderList(@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = orderService.getTotals(Order.class);
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
		List<Order> os = orderService.queryByPage(Order.class, s);
		int total = 0;
		int totalNumber = 0;
		for (Order order : os) {
			order.setOrderItems(orderitemService.queryByOid(Orderitem.class,order.getId()));
			total = 0;
			totalNumber = 0;
			for (Orderitem oi : order.getOrderItems()) {
				oi.getProduct().setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class,oi.getProduct().getId()));
				totalNumber += oi.getNumber();
				total +=((oi.getNumber())*(oi.getProduct().getPromotePrice()));
			}
			order.setTotal(total);
			order.setTotalNumber(totalNumber);
		}
		map.put("os", os);
		map.put("page", sp);
		map.put("pageCounts", pageCounts);
		map.put("url", "/admin_order_list");
		return	"/admin/listOrder";
	}
	
	@RequestMapping("/admin_product_list/{cid}/{currentPage}")
	public String adminProductList(@PathVariable int cid,@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = productService.getTotals(Product.class,cid);
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
		Map<String,Object> m = new HashMap<>();
		m.put("sp", s);
		m.put("cid", cid);
		List<Product> ps = productService.queryByPage(Product.class,m);
		for (Product p : ps) {
			p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
		}
		Category c = categoryService.queryById(Category.class, cid);
		map.put("c", c);
		map.put("ps", ps);
		map.put("page", sp);
		map.put("pageCounts", pageCounts);
		map.put("url", "/admin_product_list/"+cid);
		return "/admin/listProduct";
	}
	
	@RequestMapping("/admin_product_edit")
	public String adminProductEdit(int id,int cid,Map<String,Object> map) {
		Product p = productService.queryById(Product.class, id);
		map.put("p", p);
		return "/admin/editProduct";
	}
	
	@RequestMapping("/admin_propertyValue_edit")
	public String admin_propertyValue_edit(int pid,Map<String,Object> map ) {
		List<Propertyvalue> pvs = propertyvalueService.queryByPid(Propertyvalue.class, pid);
		Product p = productService.queryById(Product.class, pid);
		int cid = productService.getCidById(Product.class, p.getId());
		map.put("p", p);
		map.put("pvs", pvs);
		return "/admin/editPropertyValue";
	}
	
	@RequestMapping("/admin_productImage_list/{pid}")
	public String adminProductImageList(@PathVariable int pid,Map<String,Object> map) {
		Product p = productService.queryById(Product.class, pid);
		p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
		p.setProductSingleImages(producTimageService.querySingleByPid(ProducTimage.class, p.getId()));
		p.setProductDetailImages(producTimageService.queryDetailByPid(ProducTimage.class, p.getId()));
		p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
		p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
		map.put("p", p);
		return "/admin/listProductImage";
	}
	
}
