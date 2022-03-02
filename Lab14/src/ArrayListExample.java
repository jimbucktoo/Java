import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num;
		int index;
		ArrayList<Integer> rateList = new ArrayList<Integer>();

		System.out.println("Enter four integer values: ");
		for (int i = 0; i < 4; i++) {
			num = scnr.nextInt();
			rateList.add(num);
		}

		System.out.println("List values: " + rateList);

		System.out.print("Enter number to add: ");
		num = scnr.nextInt();
		rateList.add(num);

		System.out.println("List values: " + rateList);

		System.out.print("Enter a number to check: ");
		num = scnr.nextInt();
		containsValue(rateList, num);

		System.out.print("Enter number and the index to check: ");
		num = scnr.nextInt();
		index = scnr.nextInt();
		containsValue(rateList, num, index);
	}

	public static void containsValue(ArrayList<Integer> rateList, int value) {
		boolean located = false;

		for (int i = 0; i < rateList.size(); i++) {
			if (rateList.get(i) == value) {
				located = true;
			}
		}

		if (!located) {
			System.out.println("The number " + value + " is not in the list");
		} else {
			System.out.println("The number " + value + " is in the list");
		}
	}

	public static void containsValue(ArrayList<Integer> rateList, int value, int index) {
		if (rateList.get(index) == value) {
			System.out.println("The value "+value+" is at index "+index);
		} else {
			System.out.println("The value "+value+" is not at index "+index);
		}
	}
}
