package search;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 5/22/14.
 */
public class SearchTest {

    private int[] numbers;
    private Integer[] inputs;
    private final static int SIZE = 1000;
    private final static int MAX = 1000;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        int number = 0;
        numbers = new int[SIZE];
        inputs = new Integer[SIZE];
        Random generator = new Random();
        for(int i = 0; i < numbers.length; i++) {
            number = generator.nextInt(MAX);
            numbers[i] = number;
            inputs[i] = number;
        }
    }
    
    @Test
    public void testSelectionAlgoWorksForNoInputs() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Empty array");

        Random generator = new Random();
        int nth = generator.nextInt(MAX);
        SelectionAlgo selectionAlgo = new SelectionAlgo();
        selectionAlgo.search(nth, new int[0]);
    }

    @Test
    public void testSelectionAlgo() {
        long startTime = System.currentTimeMillis();
        Random generator = new Random();
        int nth = generator.nextInt(MAX);
        SelectionAlgo selectionAlgo = new SelectionAlgo();
        int n = selectionAlgo.search(nth, numbers);
        long stopTime = System.currentTimeMillis();
        System.out.println("SelectionAlgo took " + (stopTime - startTime));
        Arrays.sort(numbers);
        assertEquals(numbers[SIZE - 1  - nth], n);
    }

    @Test
    public void testBinarySearchWorksForNoInputs() {
        thrown.expect(IllegalArgumentException.class);

        Random generator = new Random();
        int nth = generator.nextInt(MAX);
        BinarySearch<Integer> bSearch = new BinarySearch<>();
        bSearch.search(nth, new Integer[0]);
    }

    @Test
    public void testBinarySearch() {
        long startTime = System.currentTimeMillis();
        Random generator = new Random();
        int key = generator.nextInt(MAX);
        Arrays.sort(inputs);
        BinarySearch<Integer> bSearch = new BinarySearch<>();
        int position = bSearch.search(key, inputs);
        long stopTime = System.currentTimeMillis();
        System.out.println("SelectionAlgo took " + (stopTime - startTime));
        if(position != -1)
            assertEquals((int)inputs[position], key);
    }
}
