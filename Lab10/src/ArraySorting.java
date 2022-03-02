import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
	private static void swapTwo(int[] numbers, int index1, int index2) {
		if ((index1 >= 0 && index1 < numbers.length) && (index2 >= 0 && index2 < numbers.length)) {
			int temp = numbers[index1];
			numbers[index1] = numbers[index2];
			numbers[index2] = temp;
			System.out.println(" ---Swap elements at index " + index1 + " and " + index2);
		} else {
			System.out.println("Index value(s) : " + index1 + "or/and" + index2 + " out of range");
		}
	}

	private static void improvedBubbleSort(int[] numbers4) {
		boolean needNextPass = true;
		int k;
		int i;
		int length = numbers4.length;

		for (k = 1; k < length && needNextPass; k++) {
			System.out.println("-  Starting at index " + k + " bubbling up highest numbers until index " + (length - 1));
			needNextPass = false;
			for (i = 0; i < length-k; i++) {
				if (numbers4[i] > numbers4[i + 1]) {
					swapTwo(numbers4, i, i+1);
					needNextPass = true;
				}
			}
			System.out.println("--Array after loop with i = " + k + ": [" + Arrays.toString(numbers4) + "].");
		}
	}

	private static void bubbleSort(int[] numbers2) {
		int k;
		int i;
		int length = numbers2.length;
		for (k = 1; k < length; k++) {
			System.out.println("-  Starting at index " + k + " bubbling up highest numbers until index " + (length - 1));
			for (i = 0; i < length - k; i++) {
				if (numbers2[i]>numbers2[i + 1]) {
					swapTwo(numbers2, i, i + 1);
				}
			}
			System.out.println("--Array after loop with i = " + k + ": " + Arrays.toString(numbers2) + ".");
		}
	}

	private static void insertionSort(int[] numbers2) {
		int i = 0;
		int j = 0;
		int length = numbers2.length;
		boolean x;
		for (i = 1; i < length; i++) {
			j = i;
			x = true;
			while (j > 0 && numbers2[j]<numbers2[j - 1]) {
				System.out.println("--Insert " + numbers2[j] + " into sorted number before " + numbers2[j]);
				swapTwo(numbers2, j, j - 1);
				--j;
				x = false;
			}
			if (x) {
				System.out.println("--Insert " + numbers2[j] + " into sorted number before " + numbers2[j]);
			}
			System.out.println("-  Array after loop where i = " + i + ": " + Arrays.toString(numbers2));
			x = false;
		}
	}

	private static void selectionSort(int[] numbers1) {
		int i = 0;
		int j = 0;
		int indexSmallest = 0;
		int length = numbers1.length;
		for (i = 0; i < length - 1; i++) {
			indexSmallest = i;
			for (j = i + 1; j < length; ++j) {
				if (numbers1[j] < numbers1[indexSmallest]) {
					indexSmallest = j;
				}
			}
			System.out.println(" --Found next smallest value: " + numbers1[indexSmallest] + " at index " + indexSmallest);
			swapTwo(numbers1, i, indexSmallest);
			System.out.println("-  Array after loop where i = " + i + ": " + Arrays.toString(numbers1));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] numbers1 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before selection sort: %s\n", Arrays.toString(numbers1));
		selectionSort(numbers1);
		System.out.printf("\n*  Array* after selection sort: %s\n", Arrays.toString(numbers1));
		System.out.println("Press <enter> key to continue");
		input.nextLine();

		int[] numbers2 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before insertion sort: %s\n", Arrays.toString(numbers2));
		insertionSort(numbers2);
		System.out.printf("\n*Array* after insertion sort: %s\n", Arrays.toString(numbers2));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
		
		int[] numbers3 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before bubble sort: %s\n", Arrays.toString(numbers3));
		bubbleSort(numbers3);
		System.out.printf("\n*  Array* after bubble sort: %s\n", Arrays.toString(numbers3));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
		
		int[] numbers4 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before improved bubble sort: %s\n", Arrays.toString(numbers4));
		improvedBubbleSort(numbers4);
		System.out.printf("\n*  Array* after improved bubble sort: %s\n", Arrays.toString(numbers4));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
	}
}