package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

//daty single list to put the days in it 
public class DaySingleList {
	private DayNodeData first, last;
	private int count;
	private DayNodeData head;
	private DayNodeData next;

	public DayNodeData getHead() {
		return head;
	}

	public DayNodeData getNodeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		DayNodeData current = head;

		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}

		return current;
	}

	public DayNodeData getNext() {
		return next;
	}

	public void setHead(DayNodeData head) {
		this.head = head;
	}

	public DaySingleList() {

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

//*************************************************************************************************************
	public void removeDay(DayNodeData nodes) {
		DayNodeData nodecurrent = first;
		DayNodeData nodeprevious = null;

		while (nodecurrent != null && nodecurrent != nodes) {
			nodeprevious = nodecurrent;
			nodecurrent = nodecurrent.getNext();
		}

		if (nodecurrent != null) {
			// Remove the node
			if (nodeprevious != null) {
				nodeprevious.setNext(nodecurrent.getNext());
			} else {
				first = nodecurrent.getNext();
			}
		}
	}

//*********************************************************************************************************************
	public void setFirst(DayNodeData first) {
		this.first = first;
	}
//*********************************************************************************************************************

	public void setLast(DayNodeData last) {
		this.last = last;
	}
	// *********************************************************************************************************************

	public DayNodeData getFirst() {
		return first;
	}
	// *********************************************************************************************************************

	public DayNodeData getLast() {
		return last;
	}
	// *********************************************************************************************************************

	public void removeFirst() {
		if (count == 0) {
			return; // List is empty, nothing to remove
		}

		if (count == 1) {
			// Only one element in the list
			first = last = null;
		} else {
			// More than one element, remove the first node
			first = first.next;
		}

		count--;
	}
	// *********************************************************************************************************************

	public void remove(int index) {
		if (index < 0 || index >= count) {
			return;
		} else if (index == 0) {
			removeFirst();
		} else if (index == count - 1) {
			removeLast();
		} else {
			DayNodeData current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			count--;
		}
	}
	// *********************************************************************************************************************

	public void removeLast() {
		if (count == 0) {
			return; // List is empty, nothing to remove
		}

		if (count == 1) {
			// Only one element in the list
			first = last = null;
		} else {
			// More than one element, find the second-to-last node and update its next
			// reference
			DayNodeData nodecurrent = first;
			while (nodecurrent.next != last) {
				nodecurrent = nodecurrent.next;
			}
			nodecurrent.next = null;
			last = nodecurrent;
		}

		count--;
	}
	// *********************************************************************************************************************

	public void addDay(ProjectRecord projects, TextField texts) {
		LocalDate locales = projects.getDate();

		// Check if a record with the same date already exists
		DayNodeData nodecurrent = head;
		while (nodecurrent != null) {
			if (nodecurrent.getRecords().getDate().equals(locales)) {
				texts.setText("Record with the same date already exists. Not adding a new one.");
				return;
			}
			nodecurrent = nodecurrent.getNext();
		}

		// If no record with the same date exists, add the new record
		DayNodeData newday = new DayNodeData(projects);
		if (head == null || locales.isBefore(head.getRecords().getDate())) {
			// If the list is empty or the new record's date is before the head, insert at
			// the beginning
			newday.setNext(head);
			head = newday;
		} else {
			nodecurrent = head;
			while (nodecurrent.getNext() != null && locales.isAfter(nodecurrent.getNext().getRecords().getDate())) {
				// Traverse the list to find the correct position to insert the new record
				nodecurrent = nodecurrent.getNext();
			}
			newday.setNext(nodecurrent.getNext());
			nodecurrent.setNext(newday);
		}

		// Clear the status message if the record is successfully added
		texts.clear();
	}
	// *********************************************************************************************************************

	public void addDay(ProjectRecord projects) {
		LocalDate locals = projects.getDate();

		// Check if a record with the same date already exists
		DayNodeData nodecurrent = head;
		while (nodecurrent != null) {
			if (nodecurrent.getRecords().getDate().equals(locals)) {
				System.out.println("Record with the same date already exists. Not adding a new one.");
				return;
			}
			nodecurrent = nodecurrent.getNext();
		}

		// If no record with the same date exists, add the new record
		DayNodeData days = new DayNodeData(projects);
		if (head == null || locals.isBefore(head.getRecords().getDate())) {
			// If the list is empty or the new record's date is before the head, insert at
			// the beginning
			days.setNext(head);
			head = days;
		} else {
			nodecurrent = head;
			while (nodecurrent.getNext() != null && locals.isAfter(nodecurrent.getNext().getRecords().getDate())) {
				// Traverse the list to find the correct position to insert the new record
				nodecurrent = nodecurrent.getNext();
			}
			days.setNext(nodecurrent.getNext());
			nodecurrent.setNext(days);
		}
	}
	// *********************************************************************************************************************

	public ObservableList<ProjectRecord> getAllRecords() {
		ObservableList<ProjectRecord> allRecords = FXCollections.observableArrayList();

		DayNodeData nodecurrent = head; // Assuming head is the starting node of your list

		while (nodecurrent != null) {
			allRecords.add(nodecurrent.getRecords());
			nodecurrent = nodecurrent.getNext();
		}

		return allRecords;
	}
	// *********************************************************************************************************************

	public ProjectRecord searchByDate(int day) {
		DayNodeData nodecurrent = first;
		while (nodecurrent != null) {
			if (nodecurrent.records.getDate().getDayOfMonth() == day) {
				return nodecurrent.records;
			}
			nodecurrent = nodecurrent.next;
		}
		return null;
	}
	// *********************************************************************************************************************

	@Override
	public String toString() {
		return "DaySingleList [first=" + first + ", last=" + last + ", count=" + count + ", head=" + head + ", next="
				+ next + "]";
	}

	public void print() {
		DayNodeData nodecurrent = head;
		while (nodecurrent != null) {
			System.out.println(nodecurrent.records);
			nodecurrent = nodecurrent.next;
		}
	}
	// *********************************************************************************************************************

	public boolean deleteByDate(LocalDate date) {
		DayNodeData nodecurrent = head;
		DayNodeData nodeprevious = null;

		while (nodecurrent != null && !nodecurrent.records.getDate().equals(date)) {
			nodeprevious = nodecurrent;
			nodecurrent = nodecurrent.getNext();
		}

		if (nodecurrent != null) {
			// Remove the node
			if (nodeprevious != null) {
				nodeprevious.setNext(nodecurrent.getNext());
			} else {
				head = nodecurrent.getNext();
			}

			// Update the count
			count--;

			return true; // Record found and deleted
		} else {
			return false; // Record not found
		}
	}
	// *********************************************************************************************************************

	public ProjectRecord searchByDate(LocalDate locals) {
		DayNodeData nodecurrent = head;

		while (nodecurrent != null) {
			if (nodecurrent.records.getDate().equals(locals)) {
				return nodecurrent.records;
			}
			nodecurrent = nodecurrent.next;
		}

		return null;
	}

	// *********************************************************************************************************************

	// If the method hasn't returned by this point, the record with the specified
	// date was not found.
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

// public int compareTo(DaySingleList dayList) {
// return thiscompareTo(dayList);
// }
