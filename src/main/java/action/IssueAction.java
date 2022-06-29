package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.InventoryDAO;
import DAO.ProductDAO;
import entity.Product;
import model.DataStock;

public class IssueAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int id;
	private int quantity;
	private int shipMounts;
	private int index;
	private int errorFlg;
	private String name;
	private String date;
	private String note;
	private String message;

	private List<Product> list;

	private DataStock errorData;
	private List<DataStock> duaList;

	//top
	public String execute() throws Exception {
		session.remove("duaList");
		ProductDAO proDAO = new ProductDAO();

		setList(proDAO.selectAll());

		return "success";
	}

	//データストック格納メソッド
	@SuppressWarnings("unchecked")
	public String preinputData() throws Exception {
		ProductDAO proDAO = new ProductDAO();
		DataStock dataStock = new DataStock();
		setList(proDAO.selectAll());

		try {
			dataStock.setId(id);
			dataStock.setName(name);
			dataStock.setShipMounts(shipMounts);
			dataStock.setDate(date);
			dataStock.setNote(note);

			if (session.isEmpty()) {
				duaList = new ArrayList<>();
				duaList.add(dataStock);
				session.put("duaList", duaList);
			} else {
				duaList = new ArrayList<>();
				duaList = (List<DataStock>) session.get("duaList");
				duaList.add(dataStock);
				session.put("duaList", duaList);
			}

		} catch (NullPointerException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}

	
	//選択項目削除メソッド
	
	
	@SuppressWarnings("unchecked")

	public String delete() {
		ProductDAO proDAO = new ProductDAO();
		setList(proDAO.selectAll());

		duaList = new ArrayList<>();
		duaList = (List<DataStock>) session.get("duaList");

		try {
			duaList.remove(index - 1);
			session.put("duaList", duaList);
		} catch (IndexOutOfBoundsException e) {
			// TODO 自動生成された catch ブロック
			return "outOfbounds";
		}

		return "success";
	}

//全クリアメソッド
	public String clear() {
		ProductDAO proDAO = new ProductDAO();
		setList(proDAO.selectAll());
		session.remove("duaList");

		return "success";
	}

	
	
//DB登録メソッド
	@SuppressWarnings("unchecked")
	public String submitAll() {
		ProductDAO proDAO = new ProductDAO();
		InventoryDAO invDAO = new InventoryDAO();
		setList(proDAO.selectAll());

		duaList = new ArrayList<>();
		duaList = (List<DataStock>) session.get("duaList");
		
		if (duaList.isEmpty() || duaList == null) {
			setMessage("error:エラーが発生");
			return "noQuantity";
		}
		
		int results; 
		int sults;
		int errorIndex=0;
		
		for (DataStock stock : duaList) {
			sults = list.get(stock.getId() - 1).getQuantity();
			list.get(stock.getId()-1).setQuantity(sults - stock.getShipMounts());
			results = list.get(stock.getId() - 1).getQuantity();
			System.out.println("getQuantity:" + sults);
			System.out.println("afterQuantity:" + results);
			
			if (results < 0) {
				errorData = stock;
				errorFlg = 1;
				break;
			}
			errorIndex++;
		}
		
		if (errorFlg == 1) {
			setMessage("error:エラーが発生。errorIndex:" + errorIndex);
			return "noQuantity";
		}
		
			
		for (DataStock dataStock : duaList) {
			dataStock.setFlg(2);
			invDAO.insertRecord(dataStock);
		}
			
		setMessage("success");
		session.remove("duaList");
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getErrorFlg() {
		return errorFlg;
	}

	public void setErrorFlg(int errorFlg) {
		this.errorFlg = errorFlg;
	}

	public DataStock getErrorData() {
		return errorData;
	}

	public void setErrorData(DataStock errorData) {
		this.errorData = errorData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
