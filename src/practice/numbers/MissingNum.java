package practice.numbers;

public class MissingNum {

  public static void main(String[] args) {
    Integer[] arr = {4, 5, 10, 11};
    int n = 4, m = 12;
    System.out.println(findMissingNum(arr, n, m));
  }

  private static int findMissingNum(Integer[] arr, int n, int m) {
    int missingNum = -1;
    for(int i=0; i<n; i++) {
      if(arr[i]!=i) { missingNum=i; break;}
    }
    if(missingNum==-1 && n<m) {
      missingNum = n;
    }
    return missingNum;
  }
}
