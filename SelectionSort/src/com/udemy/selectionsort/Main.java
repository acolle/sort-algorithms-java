package com.udemy.selectionsort;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -17, 56, -22, 1, 55 };

        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }

        // Check results
        for (int i = 0; i < intArray.length; i++) {
            if (i == intArray.length - 1) {
                System.out.print(intArray[i]);
            } else {
                System.out.print(intArray[i] + " < ");
            }
        }

    }

    public static void swap(int[] array, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
