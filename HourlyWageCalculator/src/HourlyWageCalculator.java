import java.util.InputMismatchException;
import java.util.Scanner;

public class HourlyWageCalculator {

	static final double HOUR_RATE = 15.0;
	static final double BONUS_RATE = 2.0;
	static final double OVERLOAD_PERCENT = 1.5;
	static final double REGULAR_HOURS = 40.0;
	static boolean highDemand = false;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int weekNum;
		char answer = 'y';
		double[] weekHours;

		while (answer == 'y') {
			while (true) {
				System.out.print("Enter week worked: ");
				weekNum = Integer.parseInt(scnr.nextLine());

				if (weekNum == -1) {
					System.exit(0);
				} else if (weekNum < 1 || weekNum > 52) {
					System.out.println("Week must be between 1 and 52, please try again.");
				} else {
					if (weekNum <= 2 || weekNum >= 44) {
						highDemand = true;
					} else {
						highDemand = false;
					}
					break;
				}
			}

			weekHours = getInputFromUser(scnr, weekNum);
			calculatePayForWeek(weekNum, weekHours);

			System.out.print("Would you like to calculate pay for another week? y/n: ");
			answer = scnr.nextLine().charAt(0);
			System.out.println();
		}
		System.out.println("Thanks for using the wage calculator tool.");
	}

	public static double[] getInputFromUser(Scanner scnr, int weekNum) {
		boolean valid = false;
		String[] hours = null;
		while (!valid) {
			System.out.print("Enter hours for week " + weekNum + ": ");
			hours = scnr.nextLine().split(" ");
			valid = validateInput(hours);
		}
		return convertStringArrayToDouble(hours);
	}

	public static boolean validateInput(String[] input) {
		for (int i = 0; i < input.length; i++) {
			try {
				Double.valueOf(input[i]);
				if (input.length != 7) {
					throw new InputMismatchException();
				} else if (Double.parseDouble(input[i]) < 0 || Double.parseDouble(input[i]) > 15) {
					throw new IllegalArgumentException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Input included invalid numbers. Try again please.");
				return false;
			} catch (InputMismatchException e) {
				System.out.println("Input must have seven numbers.");
				return false;
			} catch (IllegalArgumentException e) {
				System.out.println("Worked hours must have values between 0 and 15.");
				return false;
			}
		}
		return true;
	}

	public static double[] convertStringArrayToDouble(String[] hours) {
		int n = hours.length;
		double[] newHours = new double[n];
		for (int i = 0; i < n; i++) {
			newHours[i] = Double.parseDouble(hours[i]);
		}
		return newHours;
	}

	public static void calculatePayForWeek(int weekNum, double[] weekHours) {
		double totalHours = getTotalHours(weekHours);
		double totalPay;
		double rate = HOUR_RATE;
		double bonus = 0.0;
		double overtimeHours = 0.0;
		double overtimeRate = 0.0;

		if (highDemand) {
			rate = HOUR_RATE + BONUS_RATE;
			bonus = BONUS_RATE;
		}

		if (totalHours > 40) {
			System.out.printf("Week " + weekNum + " receives a bonus of $%.2f per hour\n", bonus);
			overtimeHours = totalHours - REGULAR_HOURS;
			overtimeRate = rate * OVERLOAD_PERCENT;
			totalPay = REGULAR_HOURS * (HOUR_RATE + bonus) + overtimeHours * (HOUR_RATE + bonus) * OVERLOAD_PERCENT;
		} else {
			totalPay = totalHours * (HOUR_RATE + bonus);
		}

		System.out.printf("Your total pay for week " + weekNum + " is: $%.2f\n", totalPay);
		System.out.printf("You worked a total of %.2f hours\n", totalHours);
		System.out.println("Here is your summary:");
		if (totalHours > 40) {
			System.out.printf("    Base hours worked: %.0f at $%.2f\n", REGULAR_HOURS, rate);
			System.out.printf("    Base pay: $%.2f\n", REGULAR_HOURS * rate);
			System.out.printf("    Overtime hours worked: %.0f at $%.2f\n", overtimeHours, overtimeRate);
			System.out.printf("    Overtime pay: $%.2f\n", overtimeHours * overtimeRate);
		} else {
			System.out.printf("    Base hours worked: %.0f at $%.2f\n", REGULAR_HOURS, rate);
			System.out.printf("    Base pay: $%.2f\n", REGULAR_HOURS * rate);
		}
		System.out.println();
	}

	public static double getTotalHours(double[] weekHours) {
		double totalHours = 0.0;
		for (int i = 0; i < weekHours.length; i++) {
			totalHours += weekHours[i];
		}
		return totalHours;
	}
}