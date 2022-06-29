package model;

public class DataStock {
	private int id;
	private String name;
	private int shipMounts;
	private String date;
	private String note;
	private int flg;
	private int log;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getFlg() {
		return flg;
	}
	public void setFlg(int flg) {
		this.flg = flg;
	}
	public int getLog() {
		return log;
	}
	public void setLog(int log) {
		this.log = log;
	}
	
}
