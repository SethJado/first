package com.Employee.EmployeeBack.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gazorder {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String uuid;
	private int quantity;
	private Date orderdate;
	@Enumerated(EnumType.STRING)
	private Orderstatus orderstatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Orderstatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	
}
