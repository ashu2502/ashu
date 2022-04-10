package practice.a;

import static practice.a.ArrayUtil.printArray;
import static practice.a.ArrayUtil.swapArrayElements;
import static java.lang.Integer.min;

public class ArrayArrange {

  public static void main(String[] args) {
    int[] a = new int[]{2,0,1};
    rearrangeAiToAj(a);
    printArray(a);
  }

  protected static int findMinSwapsToGetLTEElementsTogether(int[] a, int k) {
    int count = 0;
    for(int i: a) {
      if(i<=k) count++;
    }

    int badNumCnt = 0;
    for(int i=0;i<count;i++) {
      if(a[i]>k) badNumCnt++;
    }
    int ans = badNumCnt;
    for(int i=0, j=count; j<a.length; i++, j++) {
      if(a[i]>k) badNumCnt--;
      if(a[j]>k) badNumCnt++;
      ans = min(badNumCnt, ans);
    }
    return ans;
  }

  protected static void getAllZeroesTogetherAtEnd(int[] a) {
    int indexOfFirstZero = -1;
    for(int i=0; i<a.length; i++) {
      if(a[i]==0) {
        indexOfFirstZero = i;
        break;
      }
    }

    if(indexOfFirstZero>-1) {
      for(int i=indexOfFirstZero+1; i<a.length; i++) {
        if(a[i]!=0) {
          a[i]=a[i]+a[indexOfFirstZero];
          a[indexOfFirstZero]=a[i]-a[indexOfFirstZero];
          a[i]=a[i]-a[indexOfFirstZero];
          indexOfFirstZero++;
        }
      }
    }
  }

  protected static void rearrangeEvenGreaterThanOddPosition(int[] a) {
    for(int i=1; i<a.length; i++) {
      if(i%2==1 && a[i]<a[i-1]) {
        swapArrayElements(a, i, i-1);
      } else if(i%2==0 && a[i]>a[i-1]) {
        swapArrayElements(a, i, i-1);
      }
    }
  }

  protected static void rearrangeAiToAj(int[] a) {
    for(int i=0; i<a.length; i++) {
      a[a[i]%a.length]+=(i*a.length);
    }
    for(int i=0; i<a.length; i++) {
      a[i]/=a.length;
    }
  }
}