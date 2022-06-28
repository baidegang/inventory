package product;


import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import utli.DbUtil;

public class UpdateAction extends ActionSupport implements SessionAware {

	private int id;
	private String name;
	private String note;
	
	private int ret;
	
	private String message;
	private String msg;

	private Map<Integer,String> map = null;

	// ログイン情報の取得
	private Map<String, Object> session;
	
	@Override
	public String execute() {
		DbUtil dbutil = new DbUtil();
		map = new HashMap<>();
		map = dbutil.getMapProducts();
		ret = dbutil.updateProduct(this.id, this.name, this.note, getUserName());
		if (ret == 1) {
			msg = "商品情報の更新に成功しました。" + "<br>"
				+ "・商品名：" + this.name + "<br>"
				+ "・備考：" + this.note;
			this.setMessage(msg);
			return "success";
		} else {
			// 商品名重複時のエラー
			msg = "既に登録されている商品名のため" + "<br>"
				+ "商品情報の更新に失敗しました。";
			this.setMessage(msg);
			return "error";
		}
	}
	
	// ログイン情報の取得
    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
    
    // idのgetter/setter
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	
    // nameのgetter/setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
    // noteのgetter/setter
	public String getNote() { return note; }
	public void setNote(String note) { this.note = note; }
	
    // userNameのsessionを用いたgetter
	public String getUserName() { return (String)session.get("userName"); }
	
    // messageのgetter/setter
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
    // mapを用いた商品情報のgetter/setter
	public Map<Integer, String> getMap() { return map; }
	public void setMap(Map<Integer, String> map) { this.map = map; }
}
