package practice.a;

public class SparseMatrixRangeMinQuery {

  public static void main(String[] args) {
    preCompute(new int[]{7,2,3,0,5,10,3,12,18});
  }

  private static int[][] preCompute(int a[]) {
    // log (base 2) n = n >> 1
    int sparseMatrixRowSize = a.length>>1 + 1;
    int[][] sparseMatrix = new int[a.length][sparseMatrixRowSize];

    // Initialize first column with the array values
    // as minimum of one number is that number itself
    for(int i=0;i<a.length;i++) {
      sparseMatrix[i][0]=a[i];
    }

    // Rows
    for(int j = 1; j<sparseMatrixRowSize; j++) {
      for(int i=0; i+(j-1>>1)<a.length; i++) {
        sparseMatrix[i][j] = Math.min(sparseMatrix[i+(j-1>>1)][j], sparseMatrix[i][j]);
      }
    }
    return sparseMatrix;
  }
}
