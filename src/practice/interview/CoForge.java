package practice.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoForge {

  // List of interger elem, find odd practice.numbers in it, multiply by 3 and then find unique elem in that
  public static void main(String[] args) {
    int[] a = new int[]{5, 7, 9};
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(7);
    list.add(9);
    Set<Integer> uniqueOddMulOfThree = list.stream().filter(x -> x % 2 == 1).map(x -> x * 3).collect(Collectors.toSet());
    uniqueOddMulOfThree.forEach(System.out::println);

    SumInterface sumInterface = (x, y) -> x + y;
    System.out.println(sumInterface.sum(1, 2));
  }
}

interface SumInterface {
  double sum(double x, double y);
}
