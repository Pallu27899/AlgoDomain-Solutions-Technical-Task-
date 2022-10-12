package com.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NegativeOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	private String productCategory;
	private Integer discount;
	private Integer GST;
	private Integer deliveryCharge;
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getGST() {
		return GST;
	}
	public void setGST(Integer gST) {
		GST = gST;
	}
	public Integer getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(Integer deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	

}
