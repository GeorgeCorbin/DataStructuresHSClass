package SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingAlgorithms {

	public static void mergeSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		} 
		int middle = (arr.length) / 2;
		int left[] = Arrays.copyOfRange(arr, 0, middle);
		int right[] = Arrays.copyOfRange(arr, middle, arr.length);
		mergeSort(left);
		mergeSort(right);
		// Merge left and right array
		int lai = 0;
		int rai = 0;
		for (int i = 0; i < arr.length; i++) {
			if (lai >= left.length) {		// if nothing remains in the left array
				arr[i] = right[rai++];
			} else if (rai >= right.length) {	// if nothing remains in the right array
				arr[i] = left[lai++];
			} else if (left[lai] < right[rai]) {
				arr[i] = left[lai++];
			} else {
				arr[i] = right[rai++];
			}
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (right <= left) {
			return;
		}

		int pivot = right;

		int i = left;
		for (int j = left; j <= right; j++) {
			if (arr[j] <= arr[pivot]) {
				int tmp = arr[i]; 
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		}
		pivot = i - 1;
		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}


	public static void bubbleSort(int[] arr) {
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i+1]) {
					int tmp = arr[i]; 
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int j = i - 1;
				int val = arr[i];
				while (j >= 0 && arr[j] > val) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = val;
			}

		}
	}

	public static void selectionSort(int[] arr) {
		int min;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int tmp = arr[i]; 
			arr[i] = arr[min];
			arr[min] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] arr = {70, 5, 1, 7, 8, 2, 5, 9, 3, 7, 9, 10, 41, 64, 69, 41, 10, 10, 6, 7, 50, 65, 0};
		
		int[] clone = arr.clone();
		System.out.println("Merge Sort");
		System.out.println(Arrays.toString(arr));
		mergeSort(clone);
		System.out.println(Arrays.toString(clone));
		
		clone = arr.clone();
		System.out.println("\nQuick Sort");
		System.out.println(Arrays.toString(arr));
		quickSort(clone, 0, arr.length - 1);
		System.out.println(Arrays.toString(clone));
		
		clone = arr.clone();
		System.out.println("\nBubble Sort");
		System.out.println(Arrays.toString(arr));
		bubbleSort(clone);
		System.out.println(Arrays.toString(clone));
		
		clone = arr.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arr));
		insertionSort(clone);
		System.out.println(Arrays.toString(clone));
		
		clone = arr.clone();
		System.out.println("\nSelection Sort");
		System.out.println(Arrays.toString(arr));
		selectionSort(clone);
		System.out.println(Arrays.toString(clone));
	}

}
