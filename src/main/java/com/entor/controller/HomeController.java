package com.entor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.entor.service.ReviewService;
import com.entor.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
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
	private ReviewService reviewService;
	
	@Resource
	private ProducTimageService producTimageService;
	
	@Resource
	private PropertyvalueService propertyvalueService;
	
	
	//主页
	@RequestMapping("/home")
	public String Home(Map<String,Object> map) {
		List<Category> cs =getCategoryList();
		for (Category c : cs) {
			for (Product p : c.getProduct()) {
				p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
			}
		}
		int cartTotalItemNumber = getCartTotalItemNumberByUid();
		map.put("cartTotalItemNumber", cartTotalItemNumber);
		map.put("cs", cs);
		return "fore/home";
	}
	
	
	//搜索界面
	@RequestMapping("/foresearch")
	public String foresearch(String keyword,Map<String,Object> map) {
		Map<String,Object> m = new HashMap<>();
		m.put("keyword", keyword);
		List<Product> list = productService.queryByKeyword(Product.class, m);
		for (Product p : list) {
			p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
			p.setReviewCount(reviewService.getReviewCount(Review.class, p.getId()));
			p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
		}
		List<Category> cs =getCategoryList();
		int cartTotalItemNumber = getCartTotalItemNumberByUid();
		map.put("cartTotalItemNumber", cartTotalItemNumber);
		map.put("cs", cs);
		map.put("ps", list);
		return "fore/searchResult";
	}
	
	//商品界面
	@RequestMapping("/foreproduct")
	public String foreProduct(int pid,Map<String,Object> map) {
		Product p = productService.queryById(Product.class, pid);
		p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
		p.setReviewCount(reviewService.getReviewCount(Review.class, p.getId()));
		p.setProductSingleImages(producTimageService.querySingleByPid(ProducTimage.class, p.getId()));
		p.setProductDetailImages(producTimageService.queryDetailByPid(ProducTimage.class, p.getId()));
		p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
		p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
		p.setReviewCount(reviewService.getReviewCount(Review.class, p.getId()));
		List<Category> cs =getCategoryList();
		List<Review> reviews = reviewService.queryByPid(Review.class, p.getId());
		List<Propertyvalue> pvs = propertyvalueService.queryByPid(Propertyvalue.class, p.getId());
		int cartTotalItemNumber = getCartTotalItemNumberByUid();
		map.put("cartTotalItemNumber", cartTotalItemNumber);
		map.put("pvs", pvs);
		map.put("reviews", reviews);
		map.put("cs", cs);
		map.put("p", p);
		return "/fore/product";
	}
	
	
	//分类查询
	@RequestMapping("/forecategory")
	public String foreCategory(int cid,Map<String,Object> map) {
		Category c = categoryService.queryById(Category.class, cid);
		List<Product> ps = productService.queryByCid(Product.class, cid);
		for (Product p : ps) {
			p.setSaleCount(orderitemService.getSaleCount(Orderitem.class, p.getId()));
			p.setReviewCount(reviewService.getReviewCount(Review.class, p.getId()));
			p.setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, p.getId()));
		}
		c.setProduct(ps);
		List<Category> cs =getCategoryList();
		int cartTotalItemNumber = getCartTotalItemNumberByUid();
		map.put("cartTotalItemNumber", cartTotalItemNumber);
		map.put("c", c);
		map.put("cs", cs);
		return "/fore/category";
	}
	
	
	//登录界面
	@RequestMapping("/loginPage")
	public  String loginPage() {
		return "/fore/login";
	}
	
	//注册界面
	@RequestMapping("registerPage")
	public String registerPage(Map<String,Object> map) {
		List<Category> cs =getCategoryList();
		map.put("cs", cs);
		return "/fore/register";
	}
	
	//查看购物车
	@RequestMapping("/forecart")
	public String forecart(Map<String,Object> map) {
		User user= null;
		user = (User) request.getSession().getAttribute("user");
		List<Orderitem> ois = orderitemService.queryByUid(Orderitem.class, user.getId());
		for (Orderitem o : ois) {
			o.getProduct().setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, o.getProduct().getId()));
		}
		List<Category> cs =getCategoryList();
		int cartTotalItemNumber = getCartTotalItemNumberByUid();
		map.put("ois", ois);
		map.put("cartTotalItemNumber", cartTotalItemNumber);
		map.put("cs", cs);
		return "/fore/cart";
	}
	
	//结算界面
	@RequestMapping("/forebuy")
	public String forebuy(int[] oiid,Map<String,Object> map) {
		List<Orderitem> ois = new ArrayList<Orderitem>();
		for (int id : oiid) {
			ois.add(orderitemService.queryById(Orderitem.class, id));
		}
		int total = 0;
		for (Orderitem orderitem : ois) {
			total += (orderitem.getNumber())*(orderitem.getProduct().getPromotePrice());
			orderitem.getProduct().setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, orderitem.getProduct().getId()));
		}
		map.put("total", total);
		map.put("ois", ois);
		map.put("cartTotalItemNumber", getCartTotalItemNumberByUid());
		return "/fore/buy";
	}
	
	//支付界面
	@RequestMapping("goalipay")
	public String forecreateOrder(int oid,int total,Map<String,Object> map) {
		map.put("oid", oid);
		map.put("total", total);
		return "/fore/alipay";
	}
	
	//支付成功
	@RequestMapping("payed")
	public String goPayed(int oid,int total,Map<String,Object> map) {
		map.put("oid", oid);
		map.put("total", total);
		return "/fore/payed";
	}
	
	
	//我的订单
	@RequestMapping("forebought")
	public String forebought (Map<String,Object> map) {
		User user= null;
		user = (User) request.getSession().getAttribute("user");
		List<Order> os = orderService.queryByUid(Order.class, user.getId());
		for (Order order : os) {
			order.setOrderItems(orderitemService.queryByOid(Orderitem.class, order.getId()));
			for (Orderitem oi : order.getOrderItems()) {
				oi.getProduct().setFirstProductImage(producTimageService.queryByPidOne(ProducTimage.class, oi.getProduct().getId()));
			}
		}
		map.put("os", os);
		return "/fore/bought";
	}
	
	
	
	
	
	
	//购买单件
	@RequestMapping("forebuyone/{pid}")
	public String foreBuyOne(@PathVariable int pid,Map<String,Object> map) {
		
		return "/fore/buy";
	}
	
	
	
	
	
	
	
	//校验登录
	@ResponseBody
	@RequestMapping("/forecheckLogin")
	public String forecheckLogin() {
		User user= null;
		user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			return "failure";
		}else {
			return  "success";
		}
	}
	
	//获得分类集合
	public List<Category> getCategoryList(){
		List<Category> cs =  categoryService.queryAll(Category.class);
		for (Category c : cs) {
			c.setProduct(productService.queryByCid(Product.class, c.getId()));
		}
		return cs;
	}
	
	//获取购物车内总件数
	public int getCartTotalItemNumberByUid() {
		User user= null;
		user = (User) request.getSession().getAttribute("user");
		int cartTotalItemNumber = 0;
		if(user!=null) {
			cartTotalItemNumber = orderitemService.getCartTotalItemNumberByUid(Orderitem.class,user.getId());
		}
		return cartTotalItemNumber;
	}
	
	
	
	
}
