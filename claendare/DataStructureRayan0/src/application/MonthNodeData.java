package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
public class MonthNodeData {
	int month;
	DaySingleList days;
	MonthNodeData next;

	public MonthNodeData() {
		super();
	}

	public MonthNodeData(int month) {
		super();
		this.month = month;

	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public DaySingleList getDays() {
		return days;
	}

	public void setDays(DaySingleList days) {
		this.days = days;
	}

	public MonthNodeData getNext() {
		return next;
	}

	public void setNext(MonthNodeData next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "MonthNodeData [month=" + month + ", days=" + days + ", next=" + next + "]";
	}
}