package com.udemy.bubblesort;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -17, 56, -22, 1, 55 };

        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i+1]) {
                    swap(intArray, i, i+1);
                }
            }
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
        // We need a static method in order to use it in the main method
        // A static method is associated to the class in which they reside and can be called even without creating an instance of the class

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
