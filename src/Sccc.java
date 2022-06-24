
public class Sccc {

	private static final String Studentid = null;

	public static void main(String[] args) {
		String age = "1";
		String name = "Sccc";
		String sex = "f";
		String classid = "1";
		int id=1;
		String password ="22222";
// TODO Auto-generated method stub
		System.out.println("update student set age =" + age + ",name='" + name + "',sex='" + sex + "',classid="
				+ classid + " where id=" + Studentid);

		System.out.println("update student set age =" + age + ",name='" + name + "',sex='" + sex + "',classid=" + classid
				+ " where id=" +Studentid);
		
		System.out.println("insert into student(id,name,sex,age,classid)values("+id+",'"+name+"','"+sex+"',"+age+","+classid+")");


}
}

