package com.udemy.shellsort;


public class Main {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -17, 56, -22, 1, 55 };

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < intArray.length; i++){

                int newElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;

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
}


