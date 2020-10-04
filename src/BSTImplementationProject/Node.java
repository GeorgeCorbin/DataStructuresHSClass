package BSTImplementationProject;

public class Node {
	private Node right = null;
	private Node left = null;
	private Node parent = null;
	private int value;
	private int column = -1;
	
	Node(int n) {
		value = n;
	}

	public Node getRight() {
		return right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getParent() {
		return parent;
	}

	public int getValue() {
		return value;
	}

	public int getColumn() {
	    return column;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setColumn(int column) {
	    this.column = column;
	}

	public String toString() {
		return value + " ";
	}
}
