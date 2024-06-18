package br.com.rappi.sp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT * FROM VI_RAPPI")
public class Rappi implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="STORE_ID", insertable=false, updatable=false)
	private String storeId;
	
	@Id
	@Column(name="ID", insertable=false, updatable=false)
	private String id;
	
	@Column(name="GTIN", insertable=false, updatable=false)
	private String gtin;
	
	@Column(name="NAME", insertable=false, updatable=false)
	private String name;
	
	@Column(name="DESCRIPTION", insertable=false, updatable=false)
	private String description;
	
	@Column(name="BRAND", insertable=false, updatable=false)
	private String brand;
	
	@Column(name="TRADEMARK", insertable=false, updatable=false)
	private String trademark;
	
	@Column(name="CATEGORY_FIRST_LEVEL", insertable=false, updatable=false)
	private String categoryFirstLevel;
	
	@Column(name="CATEGORY_SECOND_LEVEL", insertable=false, updatable=false)
	private String categorySecondLevel;
	
	@Column(name="PRICE", insertable=false, updatable=false)
	private BigDecimal price;
	
	@Column(name="DISCOUNT_PRICE", insertable=false, updatable=false)
	private BigDecimal discountPrice;
	
	@Column(name="DISCOUNT", insertable=false, updatable=false)
	private BigDecimal discount;
	
	@Column(name="DISCOUNT_START_AT", insertable=false, updatable=false)
	private String discountStartAt;
	
	@Column(name="DISCOUNT_END_AT", insertable=false, updatable=false)
	private String discountEndAt;
	
	@Column(name="STOCK", insertable=false, updatable=false)
	private BigDecimal stock;
	
	@Column(name="IS_AVAILABLE", insertable=false, updatable=false)
	private int isAvailable;
	
	@Column(name="IS_DISCONTINED", insertable=false, updatable=false)
	private String isDiscontined;
	
	@Column(name="SALE_TYPE", insertable=false, updatable=false)
	private String saleType;
	
	@Column(name="IMAGE_URL", insertable=false, updatable=false)
	private String imageUrl;
	
	
	public String getStoreId() {
		return storeId;
	}
	
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getGtin() {
		return gtin;
	}
	
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getTrademark() {
		return trademark;
	}
	
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	
	public String getCategoryFirstLevel() {
		return categoryFirstLevel;
	}
	
	public void setCategoryFirstLevel(String categoryFirstLevel) {
		this.categoryFirstLevel = categoryFirstLevel;
	}
	
	public String getCategorySecondLevel() {
		return categorySecondLevel;
	}
	
	public void setCategorySecondLevel(String categorySecondLevel) {
		this.categorySecondLevel = categorySecondLevel;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public String getDiscountStartAt() {
		return discountStartAt;
	}
	
	public void setDiscountStartAt(String discountStartAt) {
		this.discountStartAt = discountStartAt;
	}
	
	public String getDiscountEndAt() {
		return discountEndAt;
	}
	
	public void setDiscountEndAt(String discountEndAt) {
		this.discountEndAt = discountEndAt;
	}
	
	public BigDecimal getStock() {
		return stock;
	}
	
	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}
	
	public int getIsAvailable() {
		return isAvailable;
	}
	
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String getIsDiscontined() {
		return isDiscontined;
	}
	
	public void setIsDiscontined(String isDiscontined) {
		this.isDiscontined = isDiscontined;
	}
	
	public String getSaleType() {
		return saleType;
	}
	
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
