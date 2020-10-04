package BSTImplementationProject;

import java.util.LinkedList;

public class BST {

	private Node treeRoot;

	public BST(Node root) {
		this.treeRoot = root;
	}

	// O(n)
	public Node insertNode(Node root, Node newNode) {
		if (this.treeRoot == null) {
			this.treeRoot = newNode;
		} else if (root == null) {
			root = newNode;
		} else {
			if (newNode.getValue() > root.getValue()) {
				root.setRight(insertNode(root.getRight(), newNode));
				root.getRight().setParent(root);
			} else {
				root.setLeft(insertNode(root.getLeft(), newNode));
				root.getLeft().setParent(root);
			}
		}
		return root;
	}

	// O(n)
	public void deleteNode(Node delNode) {
		if(delNode.getRight() == null && delNode.getLeft() == null) {
			updateParentOf(delNode, null);
		} else if (delNode.getLeft() == null) {
			updateParentOf(delNode, delNode.getRight());	
			delNode.getRight().setParent(delNode.getParent());
		} else if (delNode.getRight() == null) {
			updateParentOf(delNode, delNode.getLeft());
			delNode.getLeft().setParent(delNode.getParent());
		} else {			// if two children
			Node replacementNode = findNextNode(delNode.getRight());
			if (replacementNode == delNode.getRight()) {
				updateParentOf(delNode, replacementNode);	
				replacementNode.setParent(delNode.getParent());
				replacementNode.setLeft(delNode.getLeft());
				delNode.getLeft().setParent(replacementNode);
			} else {
				updateParentOf(replacementNode, replacementNode.getRight());
				replacementNode.getRight().setParent(replacementNode.getParent());
				updateParentOf(delNode, replacementNode);
				replacementNode.setParent(delNode.getParent());
				replacementNode.setLeft(delNode.getLeft());
				delNode.getLeft().setParent(replacementNode);
				replacementNode.setRight(delNode.getRight());
				delNode.getRight().setParent(replacementNode);
			}
		}
	}

	// O(n)
	private Node findNextNode(Node root) {
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	// O(1)
	private void updateParentOf(Node delNode, Node replacementNode) {
		if (delNode.getParent() == null) {
			treeRoot = replacementNode;
		} else if (delNode.getParent().getRight() == delNode) {
			delNode.getParent().setRight(replacementNode);
		} else {
			delNode.getParent().setLeft(replacementNode);
		}
	}

	// O(n)
	public Node search(Node root, int val) {
		if (root == null || root.getValue() == val) {
			return root;
		}
		if (root.getValue() > val) {
			return search (root.getLeft(), val);
		}
		return search (root.getRight(), val);
	}

	// O(n)
	public void preOrderPrint(Node root) {
		if (root != null) {
			System.out.println(root.getValue()); 
			preOrderPrint(root.getLeft());
			preOrderPrint(root.getRight());
		}
	}

	// O(n)
	public void inOrderPrint(Node root) {
		if (root != null) {
			inOrderPrint(root.getLeft());
			System.out.println(root.getValue());
			inOrderPrint(root.getRight());
		}
	}

	// O(n)
	public void postOrderPrint(Node root) {
		if (root != null) {
			postOrderPrint(root.getLeft());
			postOrderPrint(root.getRight());
			System.out.println(root.getValue());
		}
	}

	// O(n)
	public int minVal() {
		Node currNode = treeRoot;
		Node smallest = treeRoot;

		while (currNode != null) {
			if (currNode.getValue() < smallest.getValue()) {		
				smallest = currNode;
			}
			currNode = currNode.getLeft();	

		}
		return smallest.getValue();
	}

	// O(n)
	public int maxVal() {
		Node currNode = treeRoot;
		Node largest = treeRoot;

		while (currNode != null) {
			if (currNode.getValue() > largest.getValue()) {		
				largest = currNode;
			}
			currNode = currNode.getRight();	

		}
		return largest.getValue();
	}

	// O(1)
	public Node getRoot() {
		return treeRoot;
	}

	// O(n)
	public void prettyPrint() {
		final int NODE_SIZE = 2;		// width of a printed node
		Node node = treeRoot;
		final LinkedList<Node> queue = new LinkedList<Node>();
		final int height = findHeight(node);
		int row = 1;
		int printColumn = 0;
		String dashLine = "";

		// seed the queue with the root and an End of Row marker
		if (node != null) {	
			node.setColumn((1 << height) / 2);
			queue.add(node);
			queue.add(null);		// end of row marker
		}

		while (!queue.isEmpty()) {
			node = queue.remove();
			if (node == null) { 	// if End of Row marker
				System.out.println();		// end the current line
				System.out.println(dashLine);	// print the "branches"
				if (!queue.isEmpty()) {		// if another row, reset everything
					dashLine = "";
					printColumn = 0;
					row++;
					queue.add(null);		// mark the end of the row
				}
			} else {		// a node to print
				final int width = 1 << (height - row);	// width of the branch connecting the children
				if (node.getLeft() != null) {					// if there is a left child
					node.getLeft().setColumn(node.getColumn() - width/2);		// offset it to the left
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {					// if there is a right child
					node.getRight().setColumn(node.getColumn() + width/2);		// offset it to the right
					queue.add(node.getRight());
				}
				// add space to where the left child will be
				for (int i = dashLine.length(); i < NODE_SIZE * (node.getColumn() - width/2); i++) {
					dashLine += " ";
				}
				// add dashes to where the right child will be (or use spaces if there are no children)
				for (int i = 2 * (node.getColumn() - width/2); i < NODE_SIZE * (node.getColumn() + width/2 + 1); i++) {
					dashLine += (node.getRight() == null && node.getLeft() == null ? " " : "-");
				}
				// space over to where the node should print
				while (printColumn++ < node.getColumn()) {
					System.out.print("            ".substring(0,NODE_SIZE));
				}
				System.out.print(String.format("%2d", node.getValue()));
				//			    System.out.print(String.format("%2d^%2d", node.getValue(), node.getParent() == null ? -1 : node.getParent().getValue()));
			}

		}
	}

	// O(n)
	private int findHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
		}
	}


}
