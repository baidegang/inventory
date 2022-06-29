package test;

import java.util.ArrayList;
import java.util.List;

import DAO.InventoryDAO;
import DAO.ProductDAO;
import entity.Product;
import model.DataStock;

public class PreperenceList {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ProductDAO proDAO = new ProductDAO();
		List<Product> list = new ArrayList<>();
		list = proDAO.selectAll();
		
		DataStock dataStock = new DataStock();
		dataStock.setId(2);
		dataStock.setName("30インチテレビ");
		dataStock.setShipMounts(3);
		dataStock.setDate("2022-06-29");
		dataStock.setNote(null);
		
		DataStock dataStock2 = new DataStock();
		dataStock2.setId(2);
		dataStock2.setName("30インチテレビ");
		dataStock2.setShipMounts(2);
		dataStock2.setDate("2022-06-29");
		dataStock2.setNote(null);
		
		DataStock dataStock3 = new DataStock();
		dataStock3.setId(3);
		dataStock3.setName("30インチテレビ");
		dataStock3.setShipMounts(2);
		dataStock3.setDate("2022-06-29");
		dataStock3.setNote(null);

	    List<DataStock> duaList = new ArrayList<>();
		duaList.add(dataStock);
		duaList.add(dataStock2);
		duaList.add(dataStock3);
		
		int num = list.size();
		System.out.println(num);
		
		int results = 0;
		int quantity=0;
		DataStock errordata = new DataStock();
		int errorIndex=0;
		
		for (DataStock stock : duaList) {
			quantity = list.get(stock.getId() - 1).getQuantity();
			list.get(stock.getId()-1).setQuantity(quantity - stock.getShipMounts());
			results = list.get(stock.getId() - 1).getQuantity();
			System.out.println("getQuantity:" + quantity);
			System.out.println("afterQuantity:" + results);
			
			if (results < 0) {
				errordata = stock;
				break;
			}
			errorIndex++;
			
		}
		
//		System.out.println(errorIndex + "," + errordata.getId());
		
		InventoryDAO dao = new InventoryDAO();
		
		dataStock.setFlg(2);
		dao.insertRecord(dataStock);
		
//		dao.setLog(dataStock);
		System.out.println(dataStock.getLog());
		
		
		
		
//		int mounts = 0;
//		int id=0;
		
//		for(int i = 0;i<num;i++) {
//			
//			for (DataStock stock : duaList) {
//				if(stock.getId() == i + 1) {
//					id = stock.getId();
//					mounts = mounts + stock.getShipMounts();
//				}
//			}
//			System.out.println("id:"+ id + " mounts:"+ mounts);
//		}
		
		
	}
}
