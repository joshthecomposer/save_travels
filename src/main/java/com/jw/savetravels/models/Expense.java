package com.jw.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=1, max=255)
	private String name;
	@NotNull
	@Size(min=1, max=255)
	private String vendor;
	@NotNull
	@Range(min=0, max=9999)
	private double amount;
	@NotNull
	@Size(min=1, max=1000, message=" must be between 1 and 1000 characters.")
	private String description;

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	
	public Expense() {}

	public Expense(String name,String vendor,double amount,String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	public Expense(Long id, @NotNull @Size(min = 1, max = 255) String name,
			@NotNull @Size(min = 1, max = 255) String vendor, @NotNull @Range(min = 0, max = 9999) double amount,
			@NotNull @Size(min = 1, max = 755) String description, Date created_at, Date updated_at) {
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	
	
}
