package test;

import java.util.ArrayList;
import java.util.List;

import DAO.InventoryDAO;
import entity.Inventory;

public class SelectTest {
	public static void main(String[] args) {
		InventoryDAO dao = new InventoryDAO();
		List<Inventory> list = new ArrayList<Inventory>();
		
		list = dao.selectAll();
		
		System.out.println(list.get(0).getProduct_id());
		
		
		Inventory inventory = new Inventory();
		
		inventory = dao.selectOne(2);
		
		System.out.println(inventory.getProduct_id());
	}
}
