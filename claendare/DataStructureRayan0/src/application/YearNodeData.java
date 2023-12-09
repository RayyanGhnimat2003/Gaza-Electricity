package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
import java.util.Date;

public class YearNodeData {
	int year;
	MonthCircularList monthList;
	YearNodeData next, prev;

	public YearNodeData(int year) {
		super();
		this.year = year;

	}

	public YearNodeData() {
		super();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public MonthCircularList getMonthList() {
		return monthList;
	}

	public void setMonthList(MonthCircularList monthList) {
		this.monthList = monthList;
	}

	public YearNodeData getNext() {
		return next;
	}

	public void setNext(YearNodeData next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "YearNodeData [year=" + year + ", monthList=" + monthList + "]";
	}

}
