package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class MenuItem {
	private Long id;
	@NotBlank(message = "Title is required")
	@Size(min = 5,max = 65,message = "Title should have 2 to 65 characters")
	private String name;// "Title is required,Title should have 2 to 65 characters"
	

	@NotBlank(message = "Price is required")
	@Digits(integer = 4,fraction = 2,message = "Price has to be a number")
	private String price;// "Price is required,Price has to be a number"
	private Boolean active;
	@NotNull(message = "Launch Date required")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfLaunch;// "Launch Date required"
	private String category;
	private Boolean freeDelivery;

	public MenuItem() {
		super();
	}

	public MenuItem(Long id, String name, String price, Boolean active, @DateTimeFormat(pattern = "dd/MM/yyyy")Date dateOfLaunch, String category,
			Boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(Boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	public boolean equals(Long id) {
		return getId() == id;
	}

}
