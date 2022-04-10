package practice.a;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSubArraySum {

  public static void main(String[] args) {
    System.out.println(getKthLargestSum(new int[]{20,-5,-1}, 3));
  }

  private static int getKthLargestSum(int[] a, int k) {
    int[] prefixSums = new int[a.length+1];
    prefixSums[0] = 0;
    prefixSums[1] = a[0];
    for (int i = 2; i <= a.length; i++) {
      prefixSums[i] = prefixSums[i - 1] + a[i-1];
    }
    Queue<Integer> largestSumQueue = new PriorityQueue<>();
    for (int i = 1; i < a.length; i++)
      for (int j = i; j <= a.length; j++) {
        int diff = prefixSums[j] - prefixSums[i-1];
        if (largestSumQueue.size() < k) {
          largestSumQueue.add(diff);
        } else {
          if (diff > largestSumQueue.peek()) {
            largestSumQueue.poll();
            largestSumQueue.add(diff);
          }
        }
      }
    return largestSumQueue.peek();
  }

}
