package sort;

import java.util.Arrays;

/**
 * Created by sharath on 5/27/14.
 */
public class CountingSort {

    public void sort(int[] inputs) {
        if(inputs.length == 0)
            throw new IllegalArgumentException("Empty array");

        int[] repetitions = new int[10];
        for(int i: inputs) {
            repetitions[i]++;
        }

        int k = 0;

        for(int i = 0; i < repetitions.length; i++) {
            for(int j = 0; j < repetitions[i]; j++) {
                inputs[k++] = i;
            }
        }
        System.out.println(Arrays.toString(inputs));
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 4, 0, 4, 6, 6, 6, 4, 6, 3, 7, 3, 7, 3, 7, 8, 9, 0, 0, 0, 9, 0, 9, 0, 8, 6, 4, 5, 2, 1};

        CountingSort cs = new CountingSort();
        cs.sort(array);
    }
}
