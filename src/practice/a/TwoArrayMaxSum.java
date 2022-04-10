package practice.a;

import java.util.Arrays;

public class TwoArrayMaxSum {

  public static void main(String[] args) {
    printKMaxSums(new int[]{3,2,9}, new int[]{1,4,0}, 5);
  }

  private static void printKMaxSums(int[] a, int[] b, int k) {
    Arrays.sort(a);
    Arrays.sort(b);
    for(int i=a.length-1,j=b.length-1, count=k; i>=0 && j>=0 && count>0; count--) {
      System.out.println(a[i]+b[j]);
      if(i>0 && j>0) {
        if (a[i] + b[j - 1] > a[i - 1] + b[j - 1]) {
          if (a[i - 1] + b[j] > a[i] + b[j - 1]) {
            i--;
          } else {
            j--;
          }
        } else {
          i--;
          j--;
        }
      }
      // if k>practice.a.length || k>b.length is allowed, use desc priority queue(max heap) to store the max k sums at all times
    }
  }
}
