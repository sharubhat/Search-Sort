package sort;

import java.util.Arrays;

/**
 * Created by sharath on 5/12/14.
 */
public class QuickSort {
  private static int[] inputs;
  private static String pivotChoice;
  private static int countComparisons;

  public QuickSort(int[] numbers, String choice) {
    inputs = numbers;
    pivotChoice = choice;
    countComparisons = 0;
  }

  public void sort() {
    if (inputs.length == 0)
      throw new IllegalArgumentException("Empty array");
    sort(0, inputs.length - 1);
    //System.out.println(countComparisons);
  }

  private void sort(int start, int end) {
    if (start < end) {
      // use this if the pivot needs to be other than first
      choosePivot(start, end);
      int pivotIndex = partition(start, end);
      sort(start, pivotIndex - 1);
      sort(pivotIndex + 1, end);
    }
  }

  // As per Stanford Coursera tutorial
  private int partition(int left, int right) {
    int pivot = inputs[left];
    int i = left + 1;   // index to right of pivot element

    countComparisons += (long) right - left;

    // j is index at the beginning of un-partitioned sub array
    // everything between i and j are partitioned(not exactly sorted)
    // partitioned means, everything to left of i is smaller than pivot
    // and everything to it's right till j is larger than pivot
    for (int j = left + 1; j <= right; j++) {
      if (inputs[j] < pivot) {
        swap(i, j);
        i++;
      }
    }
    // i always points to element larger than pivot because it is incremented right after the swap.
    // We need to move it one position to the left, so that when the pivot is swapped with element at i,
    // we are still honoring the condition that all elements to left of pivot are smaller than pivot.
    i--;
    swap(left, i);
    return i;
  }

  private int choosePivot(int start, int end) {
    switch (pivotChoice.toLowerCase()) {
      case "first":
        break;
      case "last":
        swap(start, end);
        break;
      case "median": {
        // This method is called median of 3. This is not a true median of entire sub array.
        // Sort first, middle and last numbers and take the middle from the sorted list.
        int mid = start + (end - start) / 2;
        int a = inputs[start];
        int b = inputs[mid];
        int c = inputs[end];
        // if a,b,c are sorted, b becomes the median and it should be swapped with a.
        if ((a <= b && b <= c) || (a >= b && b >= c)) {
          // if sorted array looks like [a,b,c] or [c,b,a]
          swap(start, mid);
        } else if ((a <= c && c <= b) || (a >= c && c >= b)) {
          // if sorted array looks like [a,c,b] or [b,c,a]
          swap(start, end);
        }
        // if sorted array looks like [b,a,c] or [c,a,b] where a is in the center, no swapping needed
        break;
      }
    }
    return start;
  }

  // Some internet based solution that works but is not exact
  private int partition1(int left, int right) {
    int pivot = inputs[left];
    int i = left - 1;
    int j = right + 1;

    while (true) {
      do {
        i++;
      } while (i < right && inputs[i] < pivot);
      do {
        j--;
      } while (j > left && inputs[j] > pivot);

      if (i < j)
        swap(i, j);
      else
        return j;
    }

  }

  private void swap(int i, int j) {
    int tmp = inputs[i];
    inputs[i] = inputs[j];
    inputs[j] = tmp;
  }

  public static void main(String[] args) {
    int[] a1 = {};
    int[] a2 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
    int[] a3 = {6, 3, 9, 2, 7, 4, 6, 3};

//        QuickSort qs = new QuickSort(a1, "median");
//        System.out.println(Arrays.toString(a1));
//        qs.sort();
//        System.out.println(Arrays.toString(a1));
    QuickSort qs = new QuickSort(a2, "median");
    System.out.println(Arrays.toString(a2));
    qs.sort();
    System.out.println(Arrays.toString(a2));
    qs = new QuickSort(a3, "median");
    System.out.println(Arrays.toString(a3));
    qs.sort();
    System.out.println(Arrays.toString(a3));
  }
}
