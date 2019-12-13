package com.udemy.mergesort;

public class Main {

    public static void main(String[] args) {
	    int[] intArray = { 20, 35, -15, 7, 55, 1, -22};

	    mergeSort(intArray, 0, intArray.length);

	    for (int i = 0; i < intArray.length; i++) {
	        System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        // Partition the array
        int mid = (start + end) / 2;

        // Process of the left arrays
        mergeSort(input, start, mid);

        // Process all the right arrays
        mergeSort(input, mid, end);

        // By the time we hit that function, all arrays have been processed
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {

        // Optimisation - As at any point, any array is sorted, if the last element of left array
        // is smaller or equal to the first element of the right array,
        // these 2 arrays are already sorted
        // Ascending order
//        if (input[mid - 1] >= input[mid]) {
//            return;
//        }

        // Descending order
        if (input[mid - 1] >= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            //temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
            // Ascending order
//            if (input[i] <= input[j]) {
//                temp[tempIndex] = input[i];
//                tempIndex++;
//                i++;
//            } else {
//                temp[tempIndex] = input[j];
//                tempIndex++;
//                j++;
//            }

            // Descending order
            if (input[i] >= input[j]) {
                temp[tempIndex] = input[i];
                tempIndex++;
                i++;
            } else {
                temp[tempIndex] = input[j];
                tempIndex++;
                j++;
            }
        }

        // In case elements remain in left array, they are directly copied in correct position in the merged array
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        // Copy elements of the temp array to the merge array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
