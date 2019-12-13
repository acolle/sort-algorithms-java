package com.udemy.insertionsort;

public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -17, 56, -22, 1, 55 };

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int newElement = intArray[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && intArray[i-1] > newElement; i--) {
                // Shift elements
                // At each iteration indexes i and i-1 will have the same value
                intArray[i] = intArray[i -1];
            }

            // Index i is then replaced with the element at the first unsorted index
            intArray[i] = newElement;
        }

        // Check results
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }
}

