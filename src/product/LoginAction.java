package product;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	
	private String userName;
	private String password;
	private Map<String, Object> session;

//	private String message;
//	private String msg = "IDまたはパスワードが間違っています。";

	public String execute() {
//		if (this.id == 0 || this.password.equals("")) {
//			this.setMessage(msg);
//			return "error";
//		} else {	
//			DbDAO dbDAO = new DbDAO();
//			Student student = dbDAO.getStudentInfo(this.id, this.password);
//			setInfo(student);
//			if (this.password.equals(student.getPassword())) {
//				return "success";
//			} else {
//				this.setMessage(msg);
//				return "error";
//			}
//		}
		// ログインユーザー名をセッションに保存する
		session.put("userName", userName);
		return ActionSupport.SUCCESS;
	}
	 
//	@Override
//	public void validate() {
//		if (getId() == 0) {
//			this.addFieldError("id", "IDを入力してください。");
//		}
//		if (getPassword().length() == 0) {
//			this.addFieldError("password", "パスワードを入力してください。");
//		}
//	}
	
	@Override
    public void setSession(Map<String, Object> session) { this.session = session; }
	
    // nameのgetter/setter
	public String getUserName() { return (String)session.get("userName"); }
	public void setUserName(String userName) { this.userName = userName; }

	// passwordのgetter/setter
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

}
