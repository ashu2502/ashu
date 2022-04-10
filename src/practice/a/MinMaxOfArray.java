package practice.a;

// Array - [4,2,3,1,5]. Find minimum num and maximum num and print both.
// Max = 5, Min = 1
public class MinMaxOfArray {

  public static void main(String[] args) {
    findMinMaxOfArray(new int[]{-9,0,1});
  }

  private static void findMinMaxOfArray(int[] a) {
    int max = -1, min = Integer.MAX_VALUE;
    for(int i=0; i<a.length; i++) {
      if(a[i]>max) {
        max=a[i];
      }
      if(a[i]<min) {
        min=a[i];
      }
    }
    System.out.println("Min="+min+", Max="+max);
  }
}
