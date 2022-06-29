package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Inventory;
import model.DataStock;

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
	
	//recordテーブル挿入
	public void insertRecord(DataStock dataStock) {
		try {
			this.getConnection();
			
			pstmt = con.prepareStatement("INSERT INTO record(PRODUCT_ID,QUANTITY,DATE,FLAG,NOTE) "
					+ "VALUES(?,?,?,?,?);");
			
			pstmt.setInt(1, dataStock.getId());
			pstmt.setInt(2, dataStock.getShipMounts());
			pstmt.setString(3, dataStock.getDate());
			pstmt.setInt(4, dataStock.getFlg());
			pstmt.setString(5, dataStock.getNote());
			
			
			pstmt.executeUpdate();
			

			pstmt = con.prepareStatement("SELECT last_insert_id() AS LAST;");
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
			     dataStock.setLog(rs.getInt("LAST"));
		    }
			
			updateInventory(dataStock);
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
	}
	
	
	//inventory更新
	public void updateInventory(DataStock dataStock) {
		try {
			this.getConnection();
			
			pstmt = con.prepareStatement("UPDATE inventory SET "
					+ "QUANTITY = QUANTITY - ?,"
					+ "FINAL_LOG = ? "
					+ "WHERE PRODUCT_ID = ?;");
			
			pstmt.setInt(1, dataStock.getShipMounts());
			pstmt.setInt(2, dataStock.getLog());
			pstmt.setInt(3, dataStock.getId());
			
			
			pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
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

