public class Implement_LinkedList {
	private class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	private Node head;
	private int size;

	public Implement_LinkedList(Node head, int size) {
		head = null;
		size = 0;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}

	public void removeLast() {
		Node tmp = head;
		if (size == 0 || size == 1) {
			head = null;
			return;
		}
		while (tmp.next.next != null) {
			tmp = tmp.next;
		}
		tmp.next = null;
		size--;
	}

	public Node removeAll(int target) {
		Node tmp = head;
		Node dummy = new Node(-1);
		Node pre = dummy;

		while (tmp != null) {
			while (tmp != null && tmp.val > target) {
				tmp = tmp.next;
				size--;
			}
			pre.next = tmp;
			pre = tmp;
			if (tmp != null)
				tmp = tmp.next;
		}
		head = dummy.next;
		return head;
	}
}
