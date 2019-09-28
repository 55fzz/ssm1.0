package com.entor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Order;
import com.entor.entity.Orderitem;
import com.entor.entity.Product;
import com.entor.entity.User;
import com.entor.service.OrderService;
import com.entor.service.OrderitemService;
import com.entor.service.ProductService;

@Controller
public class OrderController {
	@Autowired
	HttpServletRequest request;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderitemService orderitemService;
	
	@Resource
	private ProductService productService;
	
	
	//生成订单等待支付
	@RequestMapping("/forecreateOrder")
	public String add(Order o,int total) {
		Date date=new Date();
		long timestamp=date.getTime();
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMMddkkmmssSSS"); //设置格式
		String timeText=format.format(timestamp); 
		Random r = new Random(1);
		int ran1 = r.nextInt(100);
		o.setOrderCode(timeText+ran1);
		User u = (User) request.getSession().getAttribute("user");
		o.setUser(u);
		o.setStatus("notPay");
		orderService.add(o);
		int num = 0;
		List<Orderitem> oi = orderitemService.queryByUid(Orderitem.class, o.getUser().getId());
		Product p = new Product();
		for (Orderitem orderitem : oi) {
			orderitem.setOrder(o);
			orderitemService.update(orderitem);
			p = orderitem.getProduct();
			num = p.getStock();
			num -= orderitem.getNumber();
			p.setStock(num);
			productService.update(p);
		}
		return "redirect:/goalipay?oid="+o.getId()+"&total="+total;
	}
	
	//付款
	@RequestMapping("/forepayed")
	public String forepayed(int oid,int total) {
		Order o = new Order();
		o.setId(oid);
		o.setPayDate(new Timestamp(System.currentTimeMillis()));
		o.setStatus("waitDelivery");
		orderService.update(o);
		return "redirect:/orderConfirmed?oid="+o.getId()+"&total="+total;
	}
	
	//发货
	@RequestMapping("/admin_order_delivery/{oid}")
	public String admin_order_delivery(@PathVariable int oid) {
		Order o = new Order();
		o.setId(oid);
		o.setDeliveryDate(new Timestamp(System.currentTimeMillis()));
		o.setStatus("waitConfirm");
		orderService.update(o);
		return "redirect:/admin_order_list/1";
	}
	
	//收货
	@RequestMapping("/foreconfirmPay")
	public String foreconfirmPay(int oid) {
		Order o = new Order();
		o.setId(oid);
		o.setConfirmDate(new Timestamp(System.currentTimeMillis()));
		o.setStatus("waitReview");
		orderService.update(o);
		return "redirect:/forebought";
	}
}
