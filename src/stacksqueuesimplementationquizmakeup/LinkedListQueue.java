package stacksqueuesimplementationquizmakeup;

public class LinkedListQueue {
	
	private Node head = null;
	private Node tail = null;
	
	// O(1)
	public void enQueue(int num) {
		Node node = new Node();
		node.setValue(num);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
		}
		
		tail = node;
		tail.setNext(null);
	}
	
	// O(1)
	public int deQueue() {
		if (head == tail) {		// if only one item in the list
			tail = null;
		}
		int val = head.getValue();
		head = head.getNext();
		return val;
	}
	
	// O(1)
	public int peek() {
		return head.getValue();
	}
	
	// O(1)
	public boolean isEmpty() {
		return tail == null;
	}
	
	// O(n)
	public String toString() {
		String result = "";
		Node node = head;
		while (node != null) {
			result += String.valueOf(node.getValue()) + " -- " ;
			node = node.getNext();
		}
		return result;
	}

}
