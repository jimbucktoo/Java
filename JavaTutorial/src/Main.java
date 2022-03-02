import java.io.*;
import java.util.Scanner;

public class Main {
    /*
    public static void fundamentals() {
        //Scanner
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter an integer: ");

        //Variable Declarations
        int num = scnr.nextInt();
        int tempVal = 0;
        final int MAX_SIZE = 10;
        final int num1 = 10;
        final float num2 = 13.31f;
        final double num3 = 13.31;
        double num4 = (double) num1;
        double num5 = Math.random();
        double num6 = Math.sqrt(num5);
        double num7 = Math.pow(num5, 2);
        double num8 = Math.abs(num5);

        char letter = 'a';
        String word = "apple";
        String phrase = "";
        char firstLetter = word.charAt(0);
        boolean bool = true;

        //Enumeration (Enum) Declarations
        LightColor lightVal = LightColor.RED;

        //Array Declarations
        String[] words = new String[3];
        words[0] = "apple";
        words[1] = "banana";
        words[2] = "cranberry";

        char[] arr = new char[MAX_SIZE];
        int[] numbers = new int[10];
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[][] table = new int[2][5];

        //If Else-If Else Statement
        if (firstLetter == 'a') {
            System.out.println("Success.");
        } else if (firstLetter == 'a') {
            System.out.println("Failure.");
        } else {
            System.out.println("Try Again.");
        }

        //Switch Statement
        switch (letter) {
            case 'a':
                System.out.print("Cut the red wire.");
                break;
            case 'b':
                System.out.print("Cut the green wire.");
                break;
            case 'c':
                System.out.print("Cut the blue wire.");
                break;
            default:
                break;
        }

        //While Loop
        while (num < 10) {
            phrase = "The machine is on.";
            System.out.println(phrase);
            num++;
        }

        //Do While Loop
        do {
            phrase = "The machine is off.";
            System.out.println(phrase);
            num++;
        } while (num < 10);

        //For Loop Using Break & Continue
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == 'l') {
                arr[i] = 'l';
                continue;
            } else if (word.charAt(i) == 'e') {
                arr[i] = 'e';
                break;
            } else {
                System.out.println(word.charAt(i));
            }
        }

        //For Loop
        for (int i = 0; i < numbers.length; ++i) {
            System.out.println("Numbers Array: " + i);
        }
        System.out.println("Number: " + numbers[3]);

        //For Loop
        for (int i = 0; i < digits.length; ++i) {
            System.out.println("Digit: " + i);
        }

        //Reverse Array by Swap
        for (int i = 0; i < (digits.length / 2); ++i) {
            tempVal = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = tempVal;
        }

        //Print Reverse Array Output
        System.out.print("Reverse Array: ");
        for (int i = 0; i < digits.length; ++i) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();

        //Assign & Print Two-Dimensional Arrays
        System.out.print("Two-Dimensional Array:");
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            System.out.println();
            for (int j = 0; j < table[i].length; j++) {
                counter++;
                table[i][j] = counter;
                System.out.print("[" + counter + "]");
            }
        }
        System.out.println();

        //Enhanced For Loop
        for (int i : digits) {
            System.out.println("Enhanced For Loop Digit: " + i);
        }
    }

    //Method
    public static double calcVolume(double depth, double area) {
        return depth * area;
    }

    //Method
    public static double calcArea(double width, double height) {
        return width * height;
    }

    //Void Method
    public static void output(double value) {
        System.out.println(value);
    }

    //Array Method
    public static double[] celsiusToFahrenheit(double[] temps) {
        double[] newTemps = new double[temps.length];
        if (temps.length > 0) {
            for (int i = 0; i < temps.length; i++) {
                double temp = (temps[i] * (9.0 / 5.0)) + 32;
                newTemps[i] = temp;
            }
        }
        return newTemps;
    }

    //Method Overloading
    public static int overload(int num1, int num2) {
        return num1 * num2;
    }

    public static int overload(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }

    //Scanner Method
    public static double getCalories(Scanner scnr) {
        double weight;
        double caloriesPerMg = 3.5;
        System.out.println("Enter Food Weight:");
        weight = scnr.nextDouble();
        return weight * caloriesPerMg;
    }

    //Add Element to Array
    public static int addElement(int[] arrayRef, int arraySize, int num) {
        if (arraySize == arrayRef.length) {
            System.out.println("Full Capacity.");
            return arraySize;
        }
        arrayRef[arraySize] = num;
        ++arraySize;
        return arraySize;
    }

    //Remove Element from Array
    public static int removeElement(int[] arrayRef, int arraySize, int num) {
        boolean targetFound = false;
        int index;

        for (index = 0; index < arraySize; ++index) {
            if (targetFound) {
                arrayRef[index - 1] = arrayRef[index];
            }

            if (arrayRef[index] == num) {
                targetFound = true;
            }
        }

        if (targetFound) {
            return arraySize - 1;
        }
        return arraySize;
    }

    //Fill Array with Incrementing Numbers
    public static int fill(int[] arrayRef, int arraySize) {
        int size = Math.min(arrayRef.length, arraySize);

        for (int index = 0; index < size; ++index) {
            arrayRef[index] = index;
        }
        return size;
    }

    //Fill Array with Custom Value
    public static int fill(int[] arrayRef, int arraySize, int customValue) {
        int size = Math.min(arrayRef.length, arraySize);

        for (int index = 0; index < size; ++index) {
            arrayRef[index] = customValue;
        }
        return size;
    }

    //Print Array
    public static void printOversizeArray(int[] arrayRef, int arraySize) {
        int index;

        System.out.print("[");
        for (index = 0; index < arraySize; ++index) {
            System.out.print(arrayRef[index]);
            if (index != arraySize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    */

    public static int getInput(Scanner scnr) throws Exception {
        int input;
        System.out.println("Enter Number:");
        input = scnr.nextInt();
        if (input > 10) {
            throw new Exception("Number too high.");
        }
        return input;
    }

    public static void closeOutFS(PrintWriter outFS) {
        try {
            if (outFS != null) {
                System.out.println("Closing File Stream Output.");
                outFS.close();
            } else {
                throw new IOException("File Not Closing.");
            }
        } catch (IOException except) {
            System.out.print("Error Closing File: " + except.getMessage());
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        /*
        double[] celc = {32.0, 100.0, 0.0};

        assert (calcVolume(3.0, calcArea(3.0, 5.0)) == 45.0) : "Test Failed.";
        System.out.println(calcVolume(3.0, calcArea(3.0, 5.0)));

        double[] fahr = celsiusToFahrenheit(celc);
        for (double temp : fahr) {
            System.out.println(temp);
        }

        System.out.println(overload(1, 2));
        System.out.println(overload(1, 2, 3));

        System.out.println(getCalories(scnr));

        //Perfect Size Array Declaration
        int[] perfectSizeArray = {1,2,3};

        //Oversize Array Variable Declarations
        final int arrayCapacity = 10;
        int currentSize = 0;
        int[] overSizeArray = new int[arrayCapacity];

        currentSize = addElement(overSizeArray, currentSize, 1);
        currentSize = addElement(overSizeArray, currentSize, 2);
        currentSize = addElement(overSizeArray, currentSize, 3);
        printOversizeArray(overSizeArray, currentSize);

        currentSize = fill(overSizeArray, currentSize);
        printOversizeArray(overSizeArray, currentSize);

        currentSize = fill(overSizeArray, currentSize, 3);
        printOversizeArray(overSizeArray, currentSize);
         */

        int num = 1;
        float floatNum = 3.14159f;
        char character = 'a';
        String str = "String";
        String fileInputName = "text.txt";
        String fileOutPutName = "output.txt";

        System.out.printf("%d %f %.3f %c %s\n", num, floatNum, floatNum, character, str);
        Scanner inSS = new Scanner(str);

        FileInputStream fileInputStream = new FileInputStream(fileInputName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutPutName);
        Scanner fIS = new Scanner(fileInputStream);
        PrintWriter outFS = new PrintWriter(fileOutputStream);

        try {
            System.out.println("Input String Stream: " + inSS.next());
            System.out.println("File Input Stream: " + fIS.nextLine());
            outFS.println("Output Text");

            int number = getInput(scnr);
            if (number <= 0) {
                throw new Exception("Invalid Number");
            }

        } catch (Exception except) {
            System.out.println("Error: " + except.getMessage());
        } catch (Throwable unknownError) {
            System.out.println("Unknown Error: " + unknownError.getMessage());
        }

        try {
            if (outFS != null) {
                System.out.println("\nClosing File: " + fileOutPutName);
            } else {
                throw new Exception("Cannot Close File.");
            }
        } catch (IOException except) {
            System.out.println("Caught IOException: " + except.getMessage());
        } finally {
            closeOutFS(outFS);
        }
    }
}