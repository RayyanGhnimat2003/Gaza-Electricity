package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
public class MonthCircularList {
	private MonthNodeData first, last;
	int count;

	public MonthCircularList() {
		first = last = null;
		count = 0;
	}

	public MonthNodeData getFirst() {
		return first;
	}

	public void setFirst(MonthNodeData first) {
		this.first = first;
	}

	public MonthNodeData getNodeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		MonthNodeData current = first;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
	}

	public MonthNodeData getLast() {
		return last;
	}

	public void setLast(MonthNodeData last) {
		this.last = last;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private void addFirst(MonthNodeData nodes) {
		if (count == 0) {
			first = last = nodes;
			nodes.setNext(first);
		} else {
			nodes.setNext(first);
			first = nodes;
			last.setNext(first);
		}
		count++;
	}

	private void addLast(MonthNodeData nodes) {
		if (count == 0) {
			first = last = nodes;
			nodes.setNext(first);
		} else {
			nodes.setNext(first);
			last.setNext(nodes);
			last = nodes;
		}
		count++;
	}

	public void addMonth(int month) {
		MonthNodeData months = new MonthNodeData(month);
		addLast(months);
	}

	public void addMonth(DaySingleList days) {
		int months;

		if (days.getCount() > 0 && days.getFirst() != null && days.getFirst().getRecords() != null) {
			months = days.getFirst().getRecords().getDate().getMonthValue();
		} else {
			months = 1;
		}

		MonthNodeData newMonth = new MonthNodeData(months);
		if (first == null || months < first.getMonth()) {

			newMonth.setNext(first);
			first = newMonth;
		} else {
			MonthNodeData nodese = first;
			while (nodese.getNext() != null && months > nodese.getNext().getMonth()) {
				nodese = nodese.getNext();
			}
			newMonth.setNext(nodese.getNext());
			nodese.setNext(newMonth);
		}

		count++;

		newMonth.setDays(days);
	}

	public void print() {
		if (first == null) {
			System.out.println("MonthCircularList is empty.");
			return;
		}

		MonthNodeData months = first;

		do {
			System.out.println("Month: " + months.getMonth());
			DaySingleList dayList = months.getDays();

			if (dayList != null) {
				dayList.print();
			} else {
				System.out.println("No days available for the month " + months.getMonth());
			}

			months = months.getNext();
		} while (months != first);
	}
	/*
	 * public class linkedList { Node first, last; int count;
	 * 
	 * public Student getFirst() { if (count == 0) return null; else return
	 * first.element;
	 * 
	 * }
	 * 
	 * public Student getLast() { if (count == 0) return null; else return
	 * last.element;
	 * 
	 * }
	 * 
	 * public void remove(int index) { if (index < 0 || index >= count) { return; }
	 * else if (index == 0) { removeFirst(); } else if (index == count - 1) {
	 * removeLast(); } else { Node current = first; for (int i = 0; i < index - 1;
	 * i++) { current = current.next; } current.next = current.next.next; count--; }
	 * }
	 * 
	 * public void addFirst(Student element) {
	 * 
	 * Node newnode = new Node(element); newnode.next = first; first = newnode;
	 * count++; if (last == null) last = first; }
	 * 
	 * public void addLast(Student element) {
	 * 
	 * Node newnode = new Node(element); if (last == null) last = first = newnode;
	 * 
	 * else { last.next = newnode; last = newnode; count++;
	 * 
	 * } }
	 * 
	 * public void add(Student element, int index) { if (index <= 0)
	 * addFirst(element); else if (index > count) addLast(element); else { Node
	 * current = first; for (int i = 0; i < index - 1; i++) current = current.next;
	 * Node temp = current.next; Node newNode = new Node(element); current.next =
	 * newNode; newNode.next = temp; count++; } }
	 * 
	 * public void removeFirst() { if (count == 0) { return; } else if (count == 1)
	 * { first = last = null; } else { first = first.next; } count--; }
	 * 
	 * public void removeLast() { if (count == 0) { return; } else if (count == 1) {
	 * first = last = null; } else { Node current = first; while (current.next !=
	 * last) { current = current.next; } last = current; last.next = null; }
	 * count--; }
	 * 
	 * public void print() { Node current = first; while (current != null) {
	 * System.out.println(current.element); current = current.next; } }
	 * 
	 * public Student search(int item) { Node current = first; while (current !=
	 * null) { if (current.element.getStuNumber() == item) { return current.element;
	 * } current = current.next; } return null; }
	 */

}
