package com.udemy.quicksort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void quickSort(int[] input, int start, int end) {

        if (end - start < 2) {
            // Base case - When we're dealing in 1-element arrays, do not do anything
            return;
        }

        // Return the index of the pivot element once it's sorted (all left elements lower than pivot, all right element greater than pivot)
        int pivotIndex = partition(input, start, end);

        // Keep partitioning on the left subarrays until base case has been reached
        quickSort(input, start, pivotIndex);

        // Keep partitioning on the right subarrays until base case has been reached
        quickSort(input, pivotIndex + 1, end);

    }

    public static int partition(int[] input, int start, int end) {
        // Use the first element of array/subarray as the pivot element
        int pivot = input[start];
        int i = start;
        int j = end;

        // Alternate between i and j until pivot element is sorted
        while (i < j) {

            // Below we use prefix decrement and increment
            // As we want to first decrement/increment and then use the result of the index

            // Empty loop body
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }

            // Empty loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
