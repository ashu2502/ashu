package practice.a;

public class ArrayUtil {

  static void printArray(int[] a) {
    for(int i : a) {
      System.out.print(i + " ");
    }
  }

  protected static void swapArrayElements(int[] a, int i, int j) {
    a[i] = a[i]+a[j];
    a[j] = a[i]-a[j];
    a[i] = a[i]-a[j];
  }


}
