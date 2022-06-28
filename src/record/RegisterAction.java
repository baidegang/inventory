package record;

import java.util.ArrayList;
import java.util.List;

import util.DbUtil;

public class RegisterAction {
	private int[] id;
	private int[] number;
	private String[] today;
	private String[] note;
	private List<Record> recode = new ArrayList<>();
	
	public String execute() {

		String change = "IndexAction";
		if(id!=null) {
			int i = 0;
			while(i < id.length) {
				// 登録商品の確認コンソール
				System.out.println("商品ID：" + id[i] + "入庫数："+ number[0]+"入庫日："+ today[i]+"備考："+ note[i]);
				DbUtil dbutil = new DbUtil();
				dbutil.insertRecord(id[i]+1,number[i],today[i],note[i]);
				i++;
			}
			change = "success";
		}
		// データ無しならば登録画面にもどる
		return change;
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public List<Record> getRecode() {
		return recode;
	}

	public void setRecode(List<Record> recode) {
		this.recode = recode;
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
