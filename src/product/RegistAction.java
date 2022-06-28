package product;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import utli.DbUtil;

public class RegistAction extends ActionSupport implements SessionAware {

	private String name;
	private String note;
	
	private int ret;

	private String message;
	private String msg = null;
	
	// ログイン情報の取得
	private Map<String, Object> session;
	
	public String init() {
		return ActionSupport.SUCCESS;
	}
	
	@Override
	public String execute() {
		DbUtil dbutil = new DbUtil();
		ret = dbutil.insertProduct(this.name, this.note, getUserName());
		if (ret == 1) {
			msg = "商品の登録に成功しました。" + "<br>"
				+ "・商品名：" + this.name + "<br>"
				+ "・備考：" + this.note;
			this.setMessage(msg);
			return ActionSupport.SUCCESS;
		} else {
			// 商品名重複時のエラーの予定
			msg = "既に登録されている商品名のため" + "<br>"
				+ "商品の登録に失敗しました。";
			this.setMessage(msg);
			return ActionSupport.ERROR;
		}
	}
	
//	@Override
//	public void validate() {
//		if (getName().length() == 0) {
//			this.addFieldError("name", "商品名を入力してください。");
//		}
//	}

	// ログイン情報の取得
    @Override
    public void setSession(Map<String, Object> session) { this.session = session; }
    
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
}
