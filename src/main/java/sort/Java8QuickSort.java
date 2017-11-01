package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8QuickSort {
  private static Function<Integer, Predicate<Integer>> smallerThan = x -> (y -> y < x);

  private static List<Integer> sort(List<Integer> list) {
    if(list.isEmpty()) {
      return Collections.emptyList();
    }
    return Stream.concat(Stream.concat(sort(list.stream().skip(1).filter(smallerThan.apply(list.get(0))).collect(Collectors.toList())).stream(),
        Stream.of(list.get(0))),
        sort(list.stream().skip(1).filter(smallerThan.apply(list.get(0)).negate()).collect(Collectors.toList())).stream()).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> l = Arrays.asList(5,6,7,23,4,5645,6,1223,44453,60182,2836,23993, 1);
    System.out.println(sort(l));
  }
}
