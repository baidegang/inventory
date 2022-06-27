package entity;

public class Inventory {
	private int product_id;
	private int quantity;
	private int final_log;
	private String note;
	private String name;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFinal_log() {
		return final_log;
	}
	public void setFinal_log(int final_log) {
		this.final_log = final_log;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
