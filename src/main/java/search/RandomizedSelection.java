package search;

import java.util.Arrays;
import java.util.Random;

/**
 * Find the k-th smallest element in an array without sorting.
 *
 * Check this video for understanding : https://www.youtube.com/watch?v=kg3XKGFObI4
 * Created by sharath on 5/29/14.
 */

// Follow quick sort subroutine.
// For problem of selecting 5th smallest entry,
// start with pivot. If pivot gets positioned in 3rd place,
// then recurse the right subarray finding 2nd largest in the new subarray.
public class RandomizedSelection<V extends Comparable<V>> {

    public V search(int nth, V[] inputs) {
        System.out.println("nth is " + nth);
        if(inputs == null || inputs.length <= nth)
            throw new IllegalArgumentException();

        int k = nth - 1;

        int from = 0, to = inputs.length - 1;

        while(from < to) {
            int r = from, w = to;
            V mid = inputs[(r + w)/2];

            while(r < w) {
                if(inputs[r].compareTo(mid) >= 0) {
                    swap(inputs, r, w);
                    w--;
                } else {
                    r++;
                }
            }

            if(inputs[r].compareTo(mid) > 0) {
                r--;
            }

            if(k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }
        return inputs[k];
    }

    private void swap(V[] arr, int i, int j) {
        V tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        Integer[] inputs = new Integer[50];
        Random generator = new Random();
        for(int i = 0; i < inputs.length; i++) {
            int number = generator.nextInt(1000);
            inputs[i] = number;
        }
        System.out.println(Arrays.toString(inputs));
        int nth = generator.nextInt(50);
        System.out.println(new RandomizedSelection<Integer>().search(nth, inputs));
        Arrays.sort(inputs);
        System.out.println(Arrays.toString(inputs));
        System.out.println(inputs[nth - 1]);
    }

}
