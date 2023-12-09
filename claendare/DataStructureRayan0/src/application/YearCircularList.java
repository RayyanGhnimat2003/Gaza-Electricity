package application;
////Name:Rayan Ghnimat.

//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3

import java.time.LocalDate;
import java.util.Date;

public class YearCircularList {
	YearNodeData first, last;
	int count;

	public YearCircularList() {
		first = last = null;
		count = 0;
	}

	public YearNodeData getFirst() {
		return first;
	}

	public void setFirst(YearNodeData first) {
		this.first = first;
	}

	public YearNodeData getLast() {
		return last;
	}

	public void setLast(YearNodeData last) {
		this.last = last;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addYear(int year) {
		YearNodeData years = new YearNodeData(year);
		if (first == null) {
			first = last = years;
			first.next = first;
			first.prev = first;
		} else {
			years.next = first;
			years.prev = last;
			last.next = years;
			first.prev = years;
			last = years;
		}
		count++;
	}

	public void print() {
		if (first == null) {
			System.out.println("YearCircularList is empty.");
			return;
		}

		YearNodeData currentYear = first;

		do {
			System.out.println("Year: " + currentYear.getYear());
			if (currentYear.getMonthList() != null) {
				currentYear.getMonthList().print(); // Print months for the current year
			}
			currentYear = currentYear.getNext();
		} while (currentYear != first);
	}

	public YearNodeData getNodeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		YearNodeData current = first;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
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
	 * 
	 * }
	 */
}