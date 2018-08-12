package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sharath on 9/4/14.
 */
public class HeapSort {
    public void sort(int[] input) {
        if(input == null || input.length == 0)
            throw new IllegalArgumentException("Empty inputs");
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i : input) {
            minHeap.offer(i);
        }
        for(int i = 0; i < input.length; i++) {
            input[i] = minHeap.poll();
        }
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] in = {18, -4, 0, 2, 5, 1, 4, 8, 4};
        hs.sort(in);
    }
}
