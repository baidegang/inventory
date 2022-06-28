package product;


import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import utli.DbUtil;

public class DeleteAction extends ActionSupport implements SessionAware {

	private int id;
	private String name;
	
	private int ret;
	
	private String message;
	private String msg;

	// 商品情報のマッピング
	private Map<Integer,String> map = null;
	
	// ログイン情報の取得
	private Map<String, Object> session;

	@Override
	public String execute() {
		DbUtil dbutil = new DbUtil();
		map = new HashMap<>();
		map = dbutil.getMapProducts();
		ret = dbutil.deleteProduct(this.id, this.name, getUserName());
		if (ret == 1) {
			msg = "商品の削除に成功しました。" + "<br>"
				+ "・商品ID：" + this.id + "<br>"
				+ "・商品名：" + this.name;
			this.setMessage(msg);
			return ActionSupport.SUCCESS;
		} else {
			// 商品名重複時のエラーを予定
			msg = "商品がすでに削除されているか、存在しない商品のため" + "<br>"
				+ "商品の削除に失敗しました。";
			this.setMessage(msg);
			return ActionSupport.ERROR;
		}
	}
	
	// ログイン情報の取得
    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
    
    // idのgetter/setter
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
    // nameのgetter/setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
    // userNameのsessionを用いたgetter
	public String getUserName() { return (String)session.get("userName"); }
	
    // messageのgetter/setter
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
    // mapを用いた商品情報のgetter/setter
	public Map<Integer, String> getMap() { return map; }
	public void setMap(Map<Integer, String> map) { this.map = map; }
}
