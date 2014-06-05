package search;

/**
 * Created by sharath on 5/22/14.
 */
//Find nth largest element in array in O(n) time.
//Algorithm is called selection algorithm. It requires O(kn) time
public class SelectionAlgo {
    public int search(int nth, int[] input) throws IllegalArgumentException {
        if(input.length == 0 || nth > input.length || nth < 0)
            throw new IllegalArgumentException("Empty array");
        int maxindex;
        int maxvalue;
        for(int i = 0; i < input.length; i++) {
            maxindex = i;
            maxvalue = input[i];
            for(int j = i + 1; j < input.length; j++) {
                if(maxvalue <= input[j]) {
                    maxvalue = input[j];
                    maxindex = j;
                }
            }
            swap(input, i, maxindex);
        }
        return input[nth];
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
