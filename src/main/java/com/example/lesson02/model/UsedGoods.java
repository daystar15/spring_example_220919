package com.example.lesson02.model;

import java.util.Date;

// 데이터를 담는 클래스를 model, DTO, VO, domain, entity이라고 함
// (각자 미세한 차이가 있으며 회사마다 다르게 부름)
public class UsedGoods {
	// 필드 null이 가능하면 Integer, null이 아니면 int
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String pictureUrl;
	private Date createdAt;
	private Date updatedAt;
	
	// getters, setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
