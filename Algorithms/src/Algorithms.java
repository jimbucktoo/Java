public class Algorithms {

    public static int linearSearch(int[] numbers, int key) {
        for (int i=0; i < numbers.length; ++i) {
            if(numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int key) {
        int mid;
        int low = 0;
        int high = numbers.length -1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (numbers[mid] < key) {
                low = mid + 1;
            } else if (numbers[mid] > key) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; i < numbers.length - i - 1; i++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        int indexSmallest;
        int temp;

        for (int i = 0; i < numbers.length - 1; ++i) {
            indexSmallest = i;
            for (int j = i + 1; j < numbers[indexSmallest]; ++j) {
                if (numbers[j] < numbers[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[indexSmallest];
            numbers[indexSmallest] = temp;
        }
    }

    public static void insertionSort(int[] numbers) {
        int i;
        int j;
        int temp;
        for (i = 0; i < numbers.length; i++) {
            j = i;
            while (j > 0 && numbers[j] < numbers[j - 1]) {
                temp = numbers[j];
                numbers[j] = numbers [j - 1];
                numbers[j - 1] = temp;
                --j;
            }
        }
    }

    public static int partition(int [] numbers, int i, int k) {
        int l;
        int h;
        int midpoint;
        int pivot;
        int temp;
        boolean done;

        midpoint = i + (k - i) / 2;
        pivot = numbers[midpoint];

        done = false;
        l = i;
        h = k;

        while (!done) {
            while (numbers[l] < pivot) {
                ++l;
            }

            while (pivot < numbers[h]) {
                --h;
            }

            if (l >= h) {
                done = true;
            } else {
                temp = numbers[l];
                numbers[l] = numbers[h];
                numbers[h] = temp;

                ++l;
                --h;
            }
        }

        return h;
    }

    public static void quickSort(int [] numbers, int i, int k) {
        int j;

        if (i >= k) {
            return;
        }

        j = partition(numbers, i, k);
        quickSort(numbers, i, j);
        quickSort(numbers, j + 1, k);
    }

    public static void merge(int [] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;
        int mergedNumbers [] = new int[mergedSize];
        int mergePos;
        int leftPos;
        int rightPos;

        mergePos = 0;
        leftPos = i;
        rightPos = j + 1;

        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] < numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }

        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void mergeSort(int [] numbers, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;

            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,8,7,6,9};
        int key = 3;
        int keyIndex;

        keyIndex = linearSearch(numbers, key);
        keyIndex = binarySearch(numbers, key);
        bubbleSort(numbers);
        selectionSort(numbers);
        insertionSort(numbers);
        quickSort(numbers, 0, numbers.length - 1);
        mergeSort(numbers, 0, numbers.length - 1);

        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }

        if (keyIndex == -1) {
            System.out.println(key + " was not found.");
        } else {
            System.out.println("Found key " + key + " at index " + keyIndex + ".");
        }
    }
}