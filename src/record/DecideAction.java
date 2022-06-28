package record;

public class DecideAction {

	private String[] name;
	private int[] number;
	private String[] today;
	private String[] note;

	
	public String execute() {
		System.out.println("入庫");
		String change = "IndexAction";
		if(name!=null) {
			int i = 0;
			while(i < name.length) {
				System.out.println("商品名："+name[i]+"入庫数："+ number[0]+"入庫日："+ today[i]+"備考："+ note[i]);
				i++;
			}
			change = "success";
		}
		return change;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getNumber() {
		return number;
	}

	public void setNumber(int[] number) {
		this.number = number;
	}

	public String[] getToday() {
		return today;
	}

	public void setToday(String[] today) {
		this.today = today;
	}

	public String[] getNote() {
		return note;
	}

	public void setNote(String[] note) {
		this.note = note;
	}
	
}
