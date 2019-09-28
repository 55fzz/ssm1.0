package com.entor.entity;

import java.sql.Timestamp;
import java.util.List;


public class Product {
	
	private int id;
	private String name;
	private String subTitle;
	private float orignalPrice;
	private float promotePrice;
	private int stock;
	private Category category;
	//成交数量
	private int saleCount;
	//评论数量
	private int reviewCount;
	private Timestamp createTime;
	private ProducTimage firstProductImage;
	private List<ProducTimage> productSingleImages;
	private List<ProducTimage> productDetailImages;
	
	
	
	public List<ProducTimage> getProductDetailImages() {
		return productDetailImages;
	}
	public void setProductDetailImages(List<ProducTimage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}
	public List<ProducTimage> getProductSingleImages() {
		return productSingleImages;
	}
	public void setProductSingleImages(List<ProducTimage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}
	public ProducTimage getFirstProductImage() {
		return firstProductImage;
	}
	public void setFirstProductImage(ProducTimage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public float getOrignalPrice() {
		return orignalPrice;
	}
	public void setOrignalPrice(float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
