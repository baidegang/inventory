package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.ProductDAO;
import entity.Product;
import model.DataStock;

public class IssueAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private int id;
	private int quantity;
	private int shipMounts;
	private int index;
	private String name;
	private String date;
	private String note;

	private List<Product> list;

	private List<DataStock> duaList;

	public String execute() throws Exception {
		session.remove("duaList");
		ProductDAO proDAO = new ProductDAO();

		setList(proDAO.selectAll());

		return "success";
	}

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
		} finally {
			System.out.println(id + "," + name + "," + shipMounts + "," + date);
		}

		return "success";
	}

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

	public String clear() {
		ProductDAO proDAO = new ProductDAO();
		setList(proDAO.selectAll());
		session.remove("duaList");

		return "success";
	}

	public String submitAll() {
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

}
