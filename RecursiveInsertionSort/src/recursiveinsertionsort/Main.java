package recursiveinsertionsort;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -17, 56, -22, 1, 55 };

        insertionSort(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    public static void insertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;
        for (i = numItems - 1; i > 0 && input[i-1] > newElement; i--) {
            // Shift elements
            // At each iteration indexes i and i-1 will have the same value
            input[i] = input[i -1];
        }

        // Index i is then replaced with the element at the first unsorted index
        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("----------");
    }
}

