package record;

import java.util.ArrayList;
import java.util.List;

import entity.Product;
import util.DbUtil;

public class IndexAction {
	private List<Product> products = new ArrayList<>();

	
	public String execute() {
		
		DbUtil util = new DbUtil();
		// 全商品の取得		
		List<Product> products = util.getProducts();
		for(Product s :products) {
			this.products.add(s);
		}
		return "success";
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}



}
