package application;
//////Name:Rayan Ghnimat.

//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3

public class DayNodeData {
	int day;

	ProjectRecord records;
	DayNodeData next;

	public DayNodeData() {
		super();
	}

	public DayNodeData(ProjectRecord records) {
		super();

		this.records = records;
		this.next = next;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public ProjectRecord getRecords() {
		return records;
	}

	public void setRecords(ProjectRecord records) {
		this.records = records;
	}

	public DayNodeData getNext() {
		return next;
	}

	public void setNext(DayNodeData next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DayNodeData [day=" + day + ", records=" + records + ", next=" + next + "]";
	}

}
