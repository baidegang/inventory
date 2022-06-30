package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();

		try {
			this.getConnection();

			pstmt = con.prepareStatement("SELECT " + "p.id, " + "p.name, " + "p.note, " + "p.last_update_user, "
					+ "i.QUANTITY " + "FROM product p,inventory i " + "WHERE p.id = i.PRODUCT_ID AND p.is_delete = 0;");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setNote(rs.getString("note"));
				product.setLastuser(rs.getString("last_update_user"));
				product.setQuantity(rs.getInt("QUANTITY"));

				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}

		return list;

	}

	public Product selectOne(int id) {
		Product product = new Product();

		try {
			this.getConnection();

			pstmt = con.prepareStatement("SELECT " + "p.id, " + "p.name, " + "p.note, " + "p.last_update_user, "
					+ "i.QUANTITY " + "FROM product p,inventory i " + "WHERE p.id = i.PRODUCT_ID AND p.is_delete = 0;");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setNote(rs.getString("note"));
				product.setLastuser(rs.getString("last_update_user"));
				product.setQuantity(rs.getInt("QUANTITY"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}

		return product;

	}

	private void getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zaikosys", "root", "Lazycrazy0512");

	}

	private void close() {
		// 接続を閉じる
		if (rs != null) {
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
