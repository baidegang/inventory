package entity;

public class Inventory {

	private int product_id;
	private Product product;
	private int quantity;
	private int final_log;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}
