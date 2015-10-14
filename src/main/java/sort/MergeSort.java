package sort;

/**
 * Created by sharath on 5/7/14.
 */
public class MergeSort {

    private int[] numbers;
    private int[] helper;


    public void sort(int[] values) {
        this.numbers = values;
        this.helper = new int[numbers.length];
        mergeSort(0, numbers.length - 1);

    }

    private void mergeSort(int low, int high) {
        // Check if low is smaller then high, if not then the array is sorted
        if(low < high) {
            int mid = low + (high - low)/2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        // Copy part of numbers to be sorted into the helper array
        for(int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int li = low;
        int ri = mid + 1;
        int di = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while(li <= mid && ri <= high) {
            if(helper[li] <= helper[ri]) {
                numbers[di++] = helper[li++];
            }
            else {
                numbers[di++] = helper[ri++];
            }
        }

        // Copy the rest of the left side of the array into the target array
        // Note that since helper is copy of numbers and
        // right side is already sorted, we need not copy them again
        while(li <= mid) {
            numbers[di++] = helper[li++];
        }

    }
}
