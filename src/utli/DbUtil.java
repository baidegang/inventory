package utli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DbUtil {
	
	static final String URL = "jdbc:mysql://localhost:3306/zaiko_kanri?serverTimezone=JST";
	static final String user = "root";
	static final String password = "password";

	public Connection getDbConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// sys?のところがtest?かもしれない, "root", "パスワード"
			conn = DriverManager.getConnection(URL,user, password);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 商品を登録
	public int insertProduct(String name,String note, String userName) {
		System.out.println("insert query:" + userName);
		 int ret = 0;
			try {
				Connection conn = getDbConnection();
				Statement stmt = conn.createStatement();
				ret = stmt.executeUpdate(
						"insert into product(name,note,create_user,last_update_user)"
						+ "values('" + name + "','" + note + "','" + userName + "','" + userName + "')");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 成功すれば1が返る
			return ret;
		}
	
	// 全Product情報を取得 zaiko_updateで利用
	public Map<Integer,String> getMapProducts() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from product");

			while(rset.next()) {
//				Product product = new Product();
				map.put(rset.getInt("id"), rset.getString("name"));
//				product.setProductName(rset.getString("name"));
//				product.setNote(rset.getString("note"));
//				product.setCreateDate(rset.getDate("create_date"));
//				product.setCreateUser(rset.getString("create_user"));
//				product.setUpdateDate(rset.getDate("update_date"));
//				product.setUpdateUser(rset.getString("update_user"));
//				list.add(product);
			}
			System.out.println(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/*
	 * // 全Product情報を取得 zaiko_updateで利用 public List<String> getListProducts() {
	 * Map<Integer,String> map = new HashMap<>(); //
	 * Listを宣言し、valuesメソッドを使用してMapの値を取得する List<String> list = null; try { Connection
	 * conn = getDbConnection(); Statement stmt = conn.createStatement(); ResultSet
	 * rset = stmt.executeQuery("select * from product");
	 * 
	 * while(rset.next()) { // Product product = new Product();
	 * map.put(rset.getInt("id"), rset.getString("name")); //
	 * product.setProductName(rset.getString("name")); //
	 * product.setNote(rset.getString("note")); //
	 * product.setCreateDate(rset.getDate("create_date")); //
	 * product.setCreateUser(rset.getString("create_user")); //
	 * product.setUpdateDate(rset.getDate("update_date")); //
	 * product.setUpdateUser(rset.getString("update_user")); // list.add(product); }
	 * list = new ArrayList<>(map.values()); }catch(Exception e) {
	 * e.printStackTrace(); } return list; }
	 * 
	 * // 全Product情報を取得 zaiko_updateで利用 public List<Product> getProducts() {
	 * List<Product> list = new ArrayList<Product>(); try { Connection conn =
	 * getDbConnection(); Statement stmt = conn.createStatement(); ResultSet rset =
	 * stmt.executeQuery("select * from product");
	 * 
	 * while(rset.next()) { Product product = new Product();
	 * product.setId(rset.getInt("id"));
	 * product.setProductName(rset.getString("name"));
	 * product.setNote(rset.getString("note"));
	 * product.setUpdateUser(rset.getString("update_user")); list.add(product); }
	 * }catch(Exception e) { e.printStackTrace(); } return list; }
	 */
	
	// 商品情報を更新
	public int updateProduct(int id, String name, String note, String userName) {
		System.out.println("update query:" + userName);
		int ret = 0;
		String msg = "update product set "
				+ "name = '" + name + "', note = '" + note
				+ "', last_update_user = '" + userName
				+ "' where id = " + id;
		System.out.println("update引数idの値:" +id);
		System.out.println(msg);
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ret= stmt.executeUpdate("update product set "
					+ "name = '" + name + "', note = '" + note
					+ "', last_update_user = '" + userName
					+ "' where id = " + id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 成功すれば1が返る
		return ret;
	}
	
	// 商品情報を削除（更新）
	public int deleteProduct(int id, String name, String userName) {
		System.out.println("delete query:" + userName);
		int ret = 0;
		String msg = "update product set "
				+ "last_update_user = '" + userName
				+ "', is_delete = " + 1
				+ " where id = " + id
				+ " and is_delete = 0";
		System.out.println("delete引数idの値:" +id);
		System.out.println(msg);
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ret= stmt.executeUpdate("update product set "
					+ "last_update_user = '" + userName
					+ "', is_delete = " + 1
					+ " where id = " + id + " and is_delete = 0");
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 成功すれば1が返る
		return ret;
	}
}
