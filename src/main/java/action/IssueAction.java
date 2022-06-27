package action;

import java.sql.Date;
import java.util.List;

import DAO.ProductDAO;
import entity.Product;
import model.DataStock;

public class IssueAction {
	
	private int id;
	private int shipMounts;
	private String name;
	private Date date;
	
	private List<Product> list;
	
	private List<DataStock> duaList;
	

	public String execute() {
		ProductDAO proDAO = new ProductDAO();
		
		setList(proDAO.selectAll());
		
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







	public Date getDate() {
		return date;
	}







	public void setDate(Date date) {
		this.date = date;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
