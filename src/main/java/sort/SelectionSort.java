package sort;

/**
 * Created by sharath on 5/8/14.
 */
public class SelectionSort {
    public void sort(int[] numbers) {
        int minIndex;
        for(int i = 0; i < numbers.length; i++) {
            minIndex = i;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            swap(numbers, i, minIndex);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
