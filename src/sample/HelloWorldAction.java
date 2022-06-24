package sample;

import java.util.List;

import entity.Student;
import utli.DbUtil;

public class HelloWorldAction {
	private String username;
	private String password;
	private String message;
    private Student Data;
	private Student student;
	private String aaa;
	
	
	private List<Student> students;
	private int id;
	private String name;
	private String sex;
	private int age;
	private int classid;

	public String execute() {

		
//		if ("1".equals(aaa)) {
//			delete();
//			return "XXXX";
//		}
		DbUtil dbutil = new DbUtil();
		
		Student student = dbutil.getStudent(this.username, this.password);
		setStudents(dbutil.getStudents(""));

		if (student != null) {

			setId(student.getId());
			setName(student.getName());
			setAge(student.getAge());
			setSex(student.getSex() == "m" ? "男" : "女");
			setClassid(student.getClassid());
			return "success";
		} else {
			setMessage("username is error,please input the other user!");
			return "error";
		}

//				if("zhangsan".equals(username)&&"2260030375".equals(password)) {
//        	return "success";
//    	} else {
//    		setMessage("username is error ,please input the other user!");
//    		return "error";
//    	}

	}
	 
	public String update() {
		
		DbUtil dbutil = new DbUtil();
		dbutil.updateStudentById(this.id, this.age,this.name,this.sex,this.classid);
				Student student = dbutil.getStudent(this.id);

		setStudents(dbutil.getStudentByClassid(1));
		if (student != null) {
			setId(student.getId());
			setName(student.getName());
			setAge(student.getAge());
			setSex(student.getSex() == "m" ? "男" : "女");
			setClassid(student.getClassid());
			return "success";
		} else {
			setMessage("username is error,please input the other user!");
			return "error";
		}
		
	}
	
	public String insert() {
		DbUtil dbutil = new DbUtil();
		dbutil.insertStudent(this.id,this. name,this. sex,this. age,this. classid);
		return "success";
		
	}
		
	public String delete() {
		DbUtil dbutil = new DbUtil();
		dbutil.deleteStudentById(this.id);
		return "success";
	}
		//Student student =dbutil.getStudent(this.id);
		//		setStudents(dbutil.getStudentByClassid(this.classid));
//		if (student != null) {
//			setId(student.getId());
//			setName(student.getName());
//			setAge(student.getAge());
//			setSex(student.getSex() == "m" ? "男" : "女");
//			setClassid(student.getClassid());
	
//		} else {
//			setMessage("username is error,please input the other user!");
//			return "error";
//		}
		
		
	
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setData(Student data) {
		Data = data;
	}

	public Student getData() {
		return Data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {

		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	/**
	 * @return the aaa
	 */
	public String getAaa() {
		return aaa;
	}

	/**
	 * @param aaa the aaa to set
	 */
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

}
