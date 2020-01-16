package bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 54, 66, 23, 43, 76, 87, 23, 55 };

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        // At each array position, create an array list
        for (int i = 0; i < buckets.length; i++) {
            // advantages of using the parent interface when creating a list structure
            // with ArrayList to store the buckets
//            buckets[i] = new ArrayList<Integer>();
            // with LinkedList to store the buckets
            buckets[i] = new LinkedList<Integer>();
            // with Vector to store the buckets
//            buckets[i] = new Vector<Integer>();
        }

        //  1 - Scattering phase where items are distributed into buckets based on their hashed values
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        // 2 - Sorting phase where each individual bucket is sorted
        for (List bucket: buckets) {
            Collections.sort(bucket);
        }

        // 3 - Merging phase where all the sorted buckets are concatenated
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int item: buckets[i]) {
                input[j++] = item;
            }
        }
    }

    private static int hash(int value) {
        return value / (int) 10;
    }
}
