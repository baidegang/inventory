import utli.DbUtil;

public class Test {

	public static void main(String[] args) {
		DbUtil util = new DbUtil();
		
		String sutdentName = util.getStudentName(1);
		System.out.println(sutdentName);
	}

}
