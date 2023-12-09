package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################
public class Statistics {

	private String type;
	private  double totals;
	private  double averages;
	private  double maximums;
	private  double minimums;

	public Statistics(String type, double totals, double averages, double maximums, double minimums) {
		super();
		this.type = type;
		this.totals = totals;
		this.averages = averages;
		this.maximums = maximums;
		this.minimums = minimums;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotal() {
		return totals;
	}

	public double getAverage() {
		return averages;
	}

	public double getMaximum() {
		return maximums;
	}

	public double getMinimum() {
		return minimums;
	}

	public Statistics(double total, double average, double maximum, double minimum) {
		super();
		this.totals = total;
		this.averages = average;
		this.maximums = maximum;
		this.minimums = minimum;
	}

	@Override
	public String toString() {
		return "Statistics [type=" + type + ", total=" + totals + ", average=" + averages + ", maximum=" + maximums
				+ ", minimum=" + minimums + "]";
	}
}
