package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sharath on 8/3/15.
 */
public class HeapReverseSort {
    public void sort(int[] input) {
        // initial capacity is needed if you want to specify a comparator.
        Queue<Integer> maxPQ = new PriorityQueue<>(10, Collections.reverseOrder());
        for(int i : input) {
            maxPQ.add(i);
        }
        for(int i = 0; i < input.length; i++) {
            input[i] = maxPQ.remove();
        }
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        HeapReverseSort hrs = new HeapReverseSort();
        int[] in = {18, -4, 0, 2, 5, 1, 4, 8, 4};
        hrs.sort(in);
    }
}
