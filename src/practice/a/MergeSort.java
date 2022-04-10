package practice.a;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = new int[]{5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2,5,1,7,6,3,3,4,8,6,9,2};
    long start = System.currentTimeMillis();
    sort(arr, 0, arr.length-1);
    Arrays.stream(arr).forEach(i -> System.out.println(i));
    System.out.println("Time taken for "+ arr.length + " entries : "+ (System.currentTimeMillis()-start)+" ms");
  }

  static void sort(int[] arr, int left, int right) {
    if(left>=right) {
      return;
    }
    int middle = (left+right)/2;
    sort(arr, left, middle);
    sort(arr, middle+1, right);
    merge(arr, left, middle, right);
  }

  static void merge(int[] arr, int left, int middle, int right) {
    int i=0, j=0;
    int[] leftArr = new int[middle-left+1], rightArr = new int[right-middle];
    for(i=left; i<arr.length && i<=middle; i++) {
      leftArr[j++]=arr[i];
    }
    j=0;
    for(i=middle+1; i<arr.length && i<=right; i++) {
      rightArr[j++]=arr[i];
    }

    int leftItr = 0, rightItr = 0;

    for(i=left; i<=right; i++) {
      if(rightItr>=rightArr.length || (leftItr<leftArr.length && leftArr[leftItr]<=rightArr[rightItr])) {
        arr[i]=leftArr[leftItr++];
      } else if(leftItr>=leftArr.length || (rightItr<rightArr.length && leftArr[leftItr]>rightArr[rightItr])) {
        arr[i]=rightArr[rightItr++];
      }
    }

  }
}
