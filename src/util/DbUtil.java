package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Inventory;
import entity.Product;
public class DbUtil implements Serializable  {
	
	
	public static Connection getDbConnection() {
		Connection conn = null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record?serverTimezone=JST", "root",
					"ericbbcn10");
		//table 4
//		java <->
//		
//		entity class
//		//class  table
//			1      1
//		
//      Student getStudent(int id)
//      void    updateStudent(id, age.....)
//      void    deleteStudent(id)
//	  void    insertStudent(id,..)
//	  List<Student> getStudentListByClassId(classid)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 在庫管理用メソッド
	
	public List<Product> getProducts() {
		List<Product>list = new ArrayList<>();
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from product where is_delete = 0");
		
			while(rset.next()) {
				Product product = new Product();
				product.setId(rset.getInt("id"));
				product.setName(rset.getString("name"));
				product.setInventory(getInventory(rset.getInt("id")));
//			     student.setClassinfo(getClassinfo(rset.getInt("class_id")));
//			     if(rset.getString("birthday")==null){
//			    	 student.setBirthday(Date.valueOf(2022-student.getAge()+"-01"+"-01"));
//			     }else {
//			    	 Date date =Date.valueOf(rset.getString("birthday"));
//			    	 student.setBirthday(date);
//			     }
			     list.add(product);
		}
			
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	
	}
	
	public Inventory getInventory(int product_id) {
		Inventory inventory = null;
			try {
				Connection conn = getDbConnection();
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select * from inventory where PRODUCT_ID="+ product_id );		
				if(rset.next()) {
					inventory = new Inventory();
					inventory.setProduct_id(rset.getInt("PRODUCT_ID"));
					inventory.setQuantity(rset.getInt("QUANTITY"));
					inventory.setFinal_log(rset.getInt("FINAL_LOG"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return inventory;
		}

	public boolean insertRecord(int product_id,int quantity,String date,String note) {
		boolean insert = false;

		try {

			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
		    // 履歴の追加
			insert = stmt.execute("insert into record(PRODUCT_ID,QUANTITY,DATE,FLAG,NOTE) values("+product_id+","+quantity+",'"+date+"','"+0+"','" + note + "' )");
		    ResultSet rset = stmt.executeQuery("SELECT LAST_INSERT_ID() AS LAST");

		    // 在庫の更新
		    if(rset != null && rset.next()) {
			    int last = rset.getInt("LAST");
			    updateInventory(product_id,quantity,last);
		    }
		}catch(Exception e) {
		e.printStackTrace();
		}
			return insert;
			
	}
	
	public int updateInventory(int product_id,int quantity,int final_log) {
		 int ret=0;
		 try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ret= stmt.executeUpdate("UPDATE inventory SET QUANTITY =QUANTITY+"+quantity+",FINAL_LOG="+ final_log +" where PRODUCT_ID="+ product_id );
		 }catch (Exception e) {
			 e.printStackTrace();			 
		}
		return ret;
	}	
	
	
//	public String getStudentName(int Studentid) {
//	 String studentName = null;
//		try {
//			Connection conn = getDbConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rset = stmt.executeQuery("select id,name,sex from student where id="+ Studentid );		
//
//			if(rset.next()) {
//				studentName = rset.getString("name");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return studentName;
//	}
//
//	public String getStudentPassword(int Studentid) {
//		 String studentPassword = null;
//			try {
//				Connection conn = getDbConnection();
//				Statement stmt = conn.createStatement();
//				ResultSet rset = stmt.executeQuery("select password from student where id="+ Studentid );		
//
//				if(rset.next()) {
//					studentPassword = rset.getString("password");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return studentPassword;
//		}
//	
//	
//	public Student getStudent(int Studentid) {
//		 Student student = null;
//			try {
//				Connection conn = getDbConnection();
//				Statement stmt = conn.createStatement();
//				ResultSet rset = stmt.executeQuery("select id,name,sex,age,classid from tbl_student where id="+ Studentid );		
//				if(rset.next()) {
//					student = new Student();
//					student.setId(rset.getInt("id"));
//					student.setName(rset.getString("name"));
//					student.setSex(rset.getString("sex"));
//					student.setAge(rset.getInt("age"));
//					student.setClass_id(rset.getInt("classid"));
//			    	Date date =Date.valueOf(rset.getString("birthday"));
//			    	student.setBirthday(date);
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return student;
//		}
//
//	public int updateStudentById(int Studentid,int age,String name,String sex,int class_id,String password,String birthday) {
//		 int ret=0;
//		 try {
//			System.out.println("誕生日は"+birthday);
//			Connection conn = getDbConnection();
//			Statement stmt = conn.createStatement();
//			ret= stmt.executeUpdate("update student set age ="+age+",name='"+name+"',sex='"+sex+"',class_id='"+class_id+"',password='"+password+"',birthday='"+birthday+"' where id="+ Studentid );
//		 }catch (Exception e) {
//			 e.printStackTrace();
//			 
//		}
//		return ret;
//	}
//	public boolean deleteStudentById(int Studentid) {
//		boolean de = false;
//		try {
//			Connection conn = getDbConnection();
//			Statement stmt = conn.createStatement();
//			 de= stmt.execute("delete from tbl_student where id="+Studentid);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return de;
//	}
//	
//	public boolean insertStudent(int id,String name,String sex,int age,int classid) {
//		boolean insert = false;
//		
//			try {
//				Connection conn = getDbConnection();
//				Statement stmt = conn.createStatement();
//			  insert = stmt.execute("insert into tbl_student(id,name,sex,age,classid)values("+id+",'"+name+"','"+sex+"',"+age+","+classid+")");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//			return insert;
//			
//	}
//	
//	public List<Student>getStudentByClassid(int class_id){
//		List<Student>list = new ArrayList<Student>();
//		try {
//			Connection conn = getDbConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rset = stmt.executeQuery("select * from student" + " where class_id="+ class_id );
//		
//			while(rset.next()) {
//				Student student = new Student();
//				student.setId(rset.getInt("id"));
//			     student.setName(rset.getString("name"));
//			     student.setSex(rset.getString("sex"));
//			     student.setAge(rset.getInt("age"));
//			     student.setClass_id(rset.getInt("class_id"));
////			     student.setClassinfo(getClassinfo(rset.getInt("class_id")));
//			     if(rset.getString("birthday")==null){
//			    	 student.setBirthday(Date.valueOf(2022-student.getAge()+"-01"+"-01"));
//			     }else {
//			    	 Date date =Date.valueOf(rset.getString("birthday"));
//			    	 student.setBirthday(date);
//			     }
//			     list.add(student);
//			}
//					
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//			return list;
//	}
//	public Product getProduct(int id) {
//		Product product = null;
//		try {
//			Connection conn = getDbConnection();
//			Statement stmt = conn.createStatement();
//            ResultSet rset = stmt.executeQuery("select * from product where id=" + id);
//            if(rset.next()) {
//            	product = new Product();
//            	product.setId(rset.getInt("id"));
//            	product.setName(rset.getString("name"));
//            }
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return product;
//	}
	


}