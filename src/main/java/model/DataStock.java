package model;

import java.util.Date;

public class DataStock {
	private int id;
	private String name;
	private int shipMounts;
	private Date date;
	
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
	public int getShipMounts() {
		return shipMounts;
	}
	public void setShipMounts(int shipMounts) {
		this.shipMounts = shipMounts;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
