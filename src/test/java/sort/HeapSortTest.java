package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by sharath on 8/3/15.
 */
public class HeapSortTest {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;
    private HeapSort heapSort;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        heapSort = new HeapSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortingEmptyArrayShouldReturnEmptyArray() {
        heapSort.sort(null);
    }

    @Test
    public void testSort() {
        long startTime = System.currentTimeMillis();
        heapSort.sort(numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("HeapSort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1])
                fail("Should not happen");
        }
        assertTrue(true);
    }
}
