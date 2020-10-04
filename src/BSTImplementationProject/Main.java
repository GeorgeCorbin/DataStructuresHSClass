package BSTImplementationProject;

import stacksqueuesimplementationquizmakeup.LinkedListQueue;

public class Main {




	public static void main(String[] args) {
		
		BST list = new BST(null);
		
		
		list.insertNode(list.getRoot(), new Node(10));
		list.insertNode(list.getRoot(), new Node(5));
		list.insertNode(list.getRoot(), new Node(1));
		list.insertNode(list.getRoot(), new Node(8));
		list.insertNode(list.getRoot(), new Node(7));
		list.insertNode(list.getRoot(), new Node(20));
		list.insertNode(list.getRoot(), new Node(16));
		list.insertNode(list.getRoot(), new Node(12));
		list.insertNode(list.getRoot(), new Node(14));
		list.insertNode(list.getRoot(), new Node(13));
		list.insertNode(list.getRoot(), new Node(15));
		list.insertNode(list.getRoot(), new Node(18));
		list.insertNode(list.getRoot(), new Node(30));
		list.insertNode(list.getRoot(), new Node(22));
		list.insertNode(list.getRoot(), new Node(32));
		list.insertNode(list.getRoot(), new Node(35));

		System.out.println();
		System.out.println("Pre Order Print");		
		list.preOrderPrint(list.getRoot());
		System.out.println();

		System.out.println();
		System.out.println("Post Order Print");		
		list.postOrderPrint(list.getRoot());
		System.out.println();

		System.out.println();
		System.out.println("In Order Print");		
		list.inOrderPrint(list.getRoot());
		System.out.println();

		System.out.println();
		System.out.println("Max Value");		
		System.out.println(list.maxVal());

		System.out.println();
		System.out.println("Minimum Value");		
		System.out.println(list.minVal());

		System.out.println();
		System.out.println("Search for 14");		
		System.out.println("Found " + list.search(list.getRoot(), 14));
		
		System.out.println();
		System.out.println("Tree Print");				
		list.prettyPrint();

		System.out.println();
		System.out.println("Delete node 22 (no children)");				
		list.deleteNode(list.search(list.getRoot(), 22));
		list.prettyPrint();

		System.out.println();
		System.out.println("Delete node 8 (left child only)");				
		list.deleteNode(list.search(list.getRoot(), 8));
		list.prettyPrint();

		System.out.println();
		System.out.println("Delete node 32 (right child only)");				
		list.deleteNode(list.search(list.getRoot(), 32));
		list.prettyPrint();

		System.out.println();
		System.out.println("Delete node 20 (simple sucessor)");				
		list.deleteNode(list.search(list.getRoot(), 20));
		list.prettyPrint();

		System.out.println();
		System.out.println("Delete node 10 (deep sucessor)");				
		list.deleteNode(list.search(list.getRoot(), 10));
		list.prettyPrint();


		

	}

}
