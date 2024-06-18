package br.com.rappi.sp.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "store_id", "id", "gtin", "name", "description", "brand", "trademark", "category_first_level", "category_second_level",
	"price", "discount_price", "discount", "discount_start_at", "discount_end_at", "stock", "is_available", "is_discontined", "sale_type", "image_url"  })
public class RappiDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("gtin")
	private String gtin;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("trademark")
	private String trademark;
	
	@JsonProperty("category_first_level")
	private String categoryFirstLevel;
	
	@JsonProperty("category_second_level")
	private String categorySecondLevel;

	@JsonProperty("price")
	private BigDecimal price;
	
	@JsonProperty("discount_price")
	private BigDecimal discountPrice;
	
	@JsonProperty("discount")
	private BigDecimal discount;
	
	@JsonProperty("discount_start_at")
	private String discountStartAt;
	
	@JsonProperty("discount_end_at")
	private String discountEndAt;
	
	@JsonProperty("stock")
	private BigDecimal stock;
	
	@JsonProperty("is_available")
	private boolean isAvailable;
	
	@JsonProperty("is_discontined")
	private String isDiscontined;
	
	@JsonProperty("sale_type")
	private String saleType;
	
	@JsonProperty("image_url")
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
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
