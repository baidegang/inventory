package utli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class DbUtil {
	
	
	public Connection getDbConnection() {
		Connection conn = null;
		try {
			System.out.println(11111);
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=JST", "root",
					"password");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public String getStudentName(int Studentid) {
	 String studentName = null;
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select id,name,sex from student where id="+ Studentid );		

			if(rset.next()) {
				studentName = rset.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentName;
	}

	public Student getStudent(int Studentid) {
		 Student student = null;
			try {
				Connection conn = getDbConnection();
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select id,name,sex,age,classid from tbl_student where id="+ Studentid );		
				if(rset.next()) {
					student = new Student();
					student.setId(rset.getInt("id"));
					student.setName(rset.getString("name"));
					student.setSex(rset.getString("sex"));
					student.setAge(rset.getInt("age"));
					student.setClassid(rset.getInt("classid"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return student;
		}

	public int updateStudentById(int Studentid,int age,String name,String sex,int classid ) {
		 int ret=0;
		 try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ret= stmt.executeUpdate("update tbl_student set age ="+age+",name='"+name+"',sex='"+sex+"',classid="+classid+" where id="+ Studentid );
		 }catch (Exception e) {
			 e.printStackTrace();
			 
		}
		return ret;
	}
	public boolean deleteStudentById(int Studentid) {
		boolean de = false;
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			 de= stmt.execute("delete from tbl_student where id="+Studentid);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return de;
	}
	public boolean insertStudent(int id,String name,String sex,int age,int classid) {
		boolean insert = false;
		
			try {
				Connection conn = getDbConnection();
				Statement stmt = conn.createStatement();
			  insert = stmt.execute("insert into tbl_student(id,name,sex,age,classid)values("+id+",'"+name+"','"+sex+"',"+age+","+classid+")");
		}catch(Exception e) {
			e.printStackTrace();
		}
			return insert;
			
	}
	
	public List<Student>getStudentByClassid(int classid){
		List<Student>list = new ArrayList<Student>();
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select id,name,sex,age,classid from tbl_student"
					+ " where classid="+ classid );
		
			
			System.out.println(2222);
			while(rset.next()) {
				Student student = new Student();
				student.setId(rset.getInt("id"));
			     student.setName(rset.getString("name"));
			     student.setSex(rset.getString("sex"));
			     student.setAge(rset.getInt("age"));
			     student.setClassid(rset.getInt("classid"));
			     list.add(student);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
			return list;
	}
	public Student getStudent(String studentName, String password) {
		Student student = null;
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select id,name,sex,age,classid from tbl_student where name='" + studentName + "' and password='" + password + "'");
            if(rset.next()) {
            	student = new Student();
            	student.setId(rset.getInt("id"));
            	student.setName(rset.getString("name"));
            	student.setSex(rset.getString("sex"));
            	student.setAge(rset.getInt("age"));
            	student.setClassid(rset.getInt("classid"));
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}


	
	
	
	public List<Student> getStudents(String p) {
		List<Student>list = new ArrayList<Student>();
		try {
			Connection conn = getDbConnection();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select id,name,sex,age,classid from tbl_student"
					+p );
		
			while(rset.next()) {
				Student student = new Student();
				student.setId(rset.getInt("id"));
			     student.setName(rset.getString("name"));
			     student.setSex(rset.getString("sex"));
			     student.setAge(rset.getInt("age"));
			     student.setClassid(rset.getInt("classid"));
			     list.add(student);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
	}
}