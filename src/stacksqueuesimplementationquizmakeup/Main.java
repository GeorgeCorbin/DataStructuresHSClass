package stacksqueuesimplementationquizmakeup;

public class Main {

	public static void main(String[] args) {
		
		LinkedListQueue q = new LinkedListQueue();
		
		System.out.println(q.toString());
		System.out.println(q.isEmpty());
		q.enQueue(4);
		System.out.println(q.toString());
		System.out.println(q.isEmpty());
		q.enQueue(8);
		System.out.println(q.toString());
		q.enQueue(6);
		System.out.println(q.toString());		
		System.out.println(q.peek());
		System.out.println(q.toString());		
		System.out.println(q.deQueue());
		System.out.println(q.toString());		
		System.out.println(q.peek());
		System.out.println(q.toString());
		q.enQueue(9);
		System.out.println(q.toString());
		System.out.println(q.deQueue());
		System.out.println(q.toString());
		System.out.println(q.deQueue());
		System.out.println(q.toString());
		System.out.println(q.deQueue());
		System.out.println(q.toString());
		System.out.println(q.isEmpty());
		q.enQueue(7);
		System.out.println(q.toString());
		
	}

}
