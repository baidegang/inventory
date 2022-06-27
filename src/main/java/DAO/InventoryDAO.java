package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Inventory;

public class InventoryDAO {

	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	
	public List<Inventory> selectAll(){
		List<Inventory> list = new ArrayList<Inventory>();
		
		try {
			this.getConnection();
			
			pstmt = con.prepareStatement("SELECT * FROM inventory;");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Inventory inv = new Inventory();
				inv.setProduct_id(rs.getInt("PRODUCT_ID"));
				inv.setQuantity(rs.getInt("QUANTITY"));
				inv.setFinal_log(rs.getInt("FINAL_LOG"));
				inv.setNote(rs.getString("NOTE"));
				inv.setName(rs.getString("MODIFIED_NAME"));
				
				list.add(inv);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		
		return list;
	}
	
	
	public Inventory selectOne(int product_id) {
		Inventory inv = new Inventory();
		
		try {
			this.getConnection();
			
			pstmt = con.prepareStatement("SELECT * FROM inventory WHERE PRODUCT_ID = ?;");
			
			pstmt.setInt(1, product_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				inv.setProduct_id(rs.getInt("PRODUCT_ID"));
				inv.setQuantity(rs.getInt("QUANTITY"));
				inv.setFinal_log(rs.getInt("FINAL_LOG"));
				inv.setNote(rs.getString("NOTE"));
				inv.setName(rs.getString("MODIFIED_NAME"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		
		return inv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void getConnection() throws SQLException,ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/zaikosys","root","Lazycrazy0512");
		
	}
	private void close() {
		//接続を閉じる
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

