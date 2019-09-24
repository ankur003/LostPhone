package com.school.portal.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.bridge.builtin.IntegerBridge;

@Entity
@Indexed
public class ProductEntity {

	@Id
	private String id;

	@Field
	private String name;

	@Field
	private BigDecimal pricePerUom;

	private Integer quantity;

	@Field
	private String uom;

	@Field
	@FieldBridge(impl = IntegerBridge.class)
	private int manufacturedYear;

	private Instant createdOn;

	public ProductEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPricePerUom() {
		return pricePerUom;
	}

	public void setPricePerUom(BigDecimal pricePerUom) {
		this.pricePerUom = pricePerUom;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getManufacturedYear() {
		return manufacturedYear;
	}

	public void setManufacturedYear(int manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

}
