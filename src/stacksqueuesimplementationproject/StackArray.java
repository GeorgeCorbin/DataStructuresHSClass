package stacksqueuesimplementationproject;

public class StackArray {
	
	int top = -1;
	
	// O(1)
	public void push(int[] arr, int num) {
		arr[++top] = num;
	}
	
	// O(1)
	public int pop(int[] arr) {
		return arr[top--];
	}
	
	// O(1)
	public int peek(int[] arr) {
		return arr[top];
	}
	
	// O(1)
	public boolean isEmpty(int[] arr) {
		return top == -1;
	}
	
	// O(1)
	public boolean isFull(int[] arr) {
		return top == arr.length - 1;
	}

}
