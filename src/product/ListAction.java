package product;


import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import utli.DbUtil;

public class ListAction extends ActionSupport{

	private int id;
	private String name;
	private String userName;
	
	private Map<Integer,String> map = null;

	public String execute() {
		DbUtil dbutil = new DbUtil();
		map = new HashMap<>();
		map = dbutil.getMapProducts();
		if (map != null) {
			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.ERROR;
		}
	}
	
    // idのgetter/setter
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
    // nameのgetter/setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
    // userNameのgetter/setter
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
    // mapを用いた商品情報のgetter/setter
	public Map<Integer, String> getMap() { return map; }
	public void setMap(Map<Integer, String> map) { this.map = map; }
}
