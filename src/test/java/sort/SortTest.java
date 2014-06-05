package sort;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
/**
 * Created by sharath on 5/7/14.
 */
public class SortTest {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testBubbleSort() {
        long startTime = System.currentTimeMillis();
        BubbleSort sorter = new BubbleSort();
        sorter.sort(numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("BubbleSort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1])
                fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testInsertionSort() {
        long startTime = System.currentTimeMillis();
        InsertionSort sorter = new InsertionSort();
        sorter.sort(numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("InsertionSort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1])
                fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testSelectionSort() {
        long startTime = System.currentTimeMillis();
        SelectionSort sorter = new SelectionSort();
        sorter.sort(numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("SelectionSort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1])
                fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();
        MergeSort sorter = new MergeSort();
        sorter.sort(numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("Mergesort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1])
                fail("Should not happen");
        }
        assertTrue(true);
    }

    @Test
    public void testQuickSortZeroInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Empty array");

        QuickSort sorter = new QuickSort(new int[0], "first");
        sorter.sort();
    }

    @Test
    public void testQuickSortOneInput() {
        long startTime = System.currentTimeMillis();
        int[] inputs = {5};
        QuickSort sorter = new QuickSort(inputs, "first");
        sorter.sort();
        long stopTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (stopTime - startTime));
        assertEquals(1, inputs.length);
    }

    @Test
    public void testQuickSortTwoInputs() {
        long startTime = System.currentTimeMillis();
        int[] inputs = {5, -4};
        QuickSort sorter = new QuickSort(inputs, "first");
        sorter.sort();
        long stopTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (stopTime - startTime));
        for(int i = 0; i < inputs.length - 1; i++) {
            if(inputs[i] > inputs [i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
        QuickSort sorter = new QuickSort(numbers, "first");
        sorter.sort();
        long stopTime = System.currentTimeMillis();
        System.out.println("QuickSort took " + (stopTime - startTime));
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }

    @Test
    public void itWorksRepeatably() {
        //Bubble sort
        for(int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for(int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbers);
            for(int j = 0; j < numbers.length - 1 ; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }

        //Insertion sort
        for(int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for(int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            InsertionSort sorter = new InsertionSort();
            sorter.sort(numbers);
            for(int j = 0; j < numbers.length - 1 ; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }

        //Selection sort
        for(int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for(int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            SelectionSort sorter = new SelectionSort();
            sorter.sort(numbers);
            for(int j = 0; j < numbers.length - 1 ; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }

        //Merge sort
        for(int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for(int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            MergeSort sorter = new MergeSort();
            sorter.sort(numbers);
            for(int j = 0; j < numbers.length - 1 ; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }

        //Quick sort
        for(int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for(int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            QuickSort sorter = new QuickSort(numbers, "first");
            sorter.sort();
            for(int j = 0; j < numbers.length - 1 ; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();

        System.out.println("Standard sort took " + (stopTime - startTime));

        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers [i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
}
