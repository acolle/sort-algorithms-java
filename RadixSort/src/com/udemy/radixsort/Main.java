package com.udemy.radixsort;

public class Main {

    public static void main(String[] args) {
        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length;  i++) {
            System.out.println(radixArray[i]);
        }

    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;

        // Create the regular counting array
        int[] countArray = new int[radix];

        for(int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // Create cumulative counting array
        for (int j = 1; j < countArray.length;  j++) {
            countArray[j] += countArray[j - 1];
        }

        // Sort array based on the ith position
        int[] tmp = new int[numItems];
        for (int k = numItems - 1; k >= 0; k--) {
            tmp[--countArray[getDigit(position, input[k], radix)]] = input[k];
        }

        // Copy elements of the temp array to the merge array
        System.arraycopy(tmp, 0, input, 0, numItems);
    }

    public static int getDigit(int position, int value, int radix) {
        // the division sign takes precedence on modulo
        return value / (int) Math.pow(10, position) % radix;
    }
}
