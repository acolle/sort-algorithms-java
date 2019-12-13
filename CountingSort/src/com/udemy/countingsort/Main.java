package com.udemy.countingsort;

public class Main {

    public static void main(String[] args) {
	 int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

	 countingSort(intArray, 2, 10);

	 for (int i = 0; i < intArray.length;  i++) {
	     System.out.println(intArray[i]);
     }

    }

    public static void countingSort(int[] input, int min, int max) {

        int[] countingArray = new int[(max - min) + 1];

        // Counting step
        for (int i = 0; i < input.length; i++) {
            countingArray[input[i] - min]++;
        }

        // Sorting step
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countingArray[i - min] > 0) {
                input[j++] = i;
                countingArray[i - min]--;
            }
        }

    }
}
