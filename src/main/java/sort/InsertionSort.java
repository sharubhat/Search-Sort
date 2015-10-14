package sort;

/**
 * For i = 1, 2, 3 ... n
 * insert A[i] into sorted array A[0 : i-1] by pairwise swaps down to the last correct position.
 * Created by sharath on 5/8/14.
 */
public class InsertionSort {

    public void sort(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            int tmp = numbers[i];
            int j = i;

            while(j > 0 && numbers[j - 1] >= tmp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = tmp;
        }
    }
}
