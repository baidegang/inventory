package action;

import java.sql.Date;
import java.util.List;

import DAO.ProductDAO;
import entity.Product;
import model.DataStock;

public class IssueAction {
	
	private int id;
	private int quantity;
	private int shipMounts;
	private String name;
	private String date;
	
	private List<Product> list;
	
	private List<DataStock> duaList;
	

	public String execute() {
		ProductDAO proDAO = new ProductDAO();
		
		setList(proDAO.selectAll());
		
		return "success";
	}
	
	
	public String preinputData() {
		ProductDAO proDAO = new ProductDAO();
		DataStock dataStock = new DataStock();
			
			
		try {
			Date sqlDate = Date.valueOf(date);
			setList(proDAO.selectAll());
			dataStock.setId(id);
			dataStock.setName(name);
			dataStock.setShipMounts(shipMounts);
			dataStock.setDate(sqlDate);
			
			duaList.add(dataStock);
		} catch (NullPointerException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {

			System.out.println(id+","+name+","+shipMounts + "," + date);
		}
		
		return "success";
	}
	
	
	
	
	
	

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}







	public List<DataStock> getDuaList() {
		return duaList;
	}







	public void setDuaList(List<DataStock> duaList) {
		this.duaList = duaList;
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







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
