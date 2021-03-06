package sort;

/**
 * Created by sharath on 5/8/14.
 */
public class BubbleSort {

    public void sort(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if( numbers[i] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
