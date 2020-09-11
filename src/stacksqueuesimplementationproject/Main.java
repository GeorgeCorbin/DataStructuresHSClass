package stacksqueuesimplementationproject;
import java.util.Arrays;

public class Main {
	static StackArray stack = new StackArray();
	static int testArray[] = new int[6];

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.isEmpty(testArray));
		System.out.println(Arrays.toString(testArray));		
		stack.push(testArray, 4);
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.isEmpty(testArray));
		System.out.println(Arrays.toString(testArray));		
		stack.push(testArray, 1);		
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.peek(testArray));
		System.out.println(Arrays.toString(testArray));		
		stack.push(testArray, 3);
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.isFull(testArray));
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.pop(testArray));
		System.out.println(Arrays.toString(testArray));
		System.out.println(stack.peek(testArray));
		System.out.println(Arrays.toString(testArray));
		stack.push(testArray, 8);		
		System.out.println(Arrays.toString(testArray));
		System.out.println(stack.pop(testArray));
		System.out.println(Arrays.toString(testArray));
		System.out.println(stack.isEmpty(testArray));
		System.out.println(Arrays.toString(testArray));		
		stack.push(testArray, 5);
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.peek(testArray));
		System.out.println(Arrays.toString(testArray));		
		System.out.println(stack.isFull(testArray));
		System.out.println(Arrays.toString(testArray));
		stack.push(testArray, 6);
		System.out.println(Arrays.toString(testArray));
		stack.push(testArray, 2);
		System.out.println(Arrays.toString(testArray));
		stack.push(testArray, 9);
		System.out.println(Arrays.toString(testArray));
		System.out.println(stack.isFull(testArray));
		System.out.println(Arrays.toString(testArray));	
	}

}
