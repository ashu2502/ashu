package practice.a;

// Difference Array - Array that stores differences between consecutive elements of array
public class DifferenceArray {
  public static void main(String[] args) {
    int[] input = new int[] {10,5,20,40};
    int[] diffArr = new int[input.length+1];
    diffArr[0]=input[0];
    for(int i=1;i<input.length;i++) {
      diffArr[i]=input[i]-input[i-1];
    }
    // Arr   --   10,5,20,40 --0,1,10--> 20,60,20,40 --1,3,20--> 20,80,40,60 --2,2,30--> 20,80,70,60
    // diffArr -- 10,-5,15,20 --0,1,10--> 20,5,5,20 --1,3,20-->20,25,25,40-->2,2,30-->20,60,40,-10
    int[][] queries= new int[][] {{0,1,10},{1,3,20},{2,2,30}};
    for(int i=0;i<queries.length;i++) {
      diffArr[queries[i][0]]+=queries[i][2];
      diffArr[queries[i][1] + 1] -= queries[i][2];
    }
    input[0]=diffArr[0];
    System.out.println(input[0]);
    for(int i=1;i<input.length;i++) {
      input[i]=input[i-1]+diffArr[i];
      System.out.println(input[i]);
    }
  }
}
