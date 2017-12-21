package search;

/**
 * Created by sharath on 9/15/14.
 */
public class BinarySearch<V extends Comparable<V>> {

    public int search2(V key, V[] input) {
        if(key == null || input.length == 0)
            throw new IllegalArgumentException();
        System.out.println(key);
        return search(key, input, 0, input.length - 1);
    }

    private int search(V key, V[] input, int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            if(key.compareTo(input[mid]) == 0)
                return mid;
            else if(key.compareTo(input[mid]) < 0)
                search(key, input, start, mid);
            else if(key.compareTo(input[mid]) > 0)
                search(key, input, mid + 1, end);
        }
        return -1;
    }

    public int search(V key, V[] input) {
        if(key == null || input.length == 0) {
            throw new IllegalArgumentException();
        }
        int low = 0;
        int high = input.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(input[mid]) == 0) {
                return mid;
            } else if (key.compareTo(input[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
