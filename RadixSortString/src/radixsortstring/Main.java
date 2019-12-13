package radixsortstring;

public class Main {

    public static void main(String[] args) {
        String[] radixArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

        radixSort(radixArray, 26, 5);

        for (int i = 0; i < radixArray.length;  i++) {
            System.out.println(radixArray[i]);
        }

    }

    public static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {

        int numItems = input.length;

        // Create the regular counting array
        int[] countArray = new int[radix];

        for(String value: input) {
            countArray[getIndexForChar(position, value)]++;
        }

        // Create cumulative counting array
        for (int j = 1; j < countArray.length;  j++) {
            countArray[j] += countArray[j - 1];
        }

        // Sort array based on the ith position
        String[] tmp = new String[numItems];
        for (int k = numItems - 1; k >= 0; k--) {
            tmp[--countArray[getIndexForChar(position, input[k])]] = input[k];
        }

        // Copy elements of the temp array to the merge array
        System.arraycopy(tmp, 0, input, 0, numItems);
    }

    public static int getIndexForChar(int position, String value) {
        Character c = value.charAt(position);
        int index = (char)(c - 'a');
        return index;
    }

}
