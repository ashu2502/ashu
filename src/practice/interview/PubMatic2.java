package practice.interview;

public class PubMatic2 {
  /**
   * [
   *   ["1","1","1","1","0"],
   *   ["1","1","0","1","0"],
   *   ["1","1","0","0","0"],
   *   ["0","0","0","1","1"],
   *   ["0","0","0","0","1"]
   * ]
   * 1 - infected, 0 - not infected
   * Number of infected clusters
   */

  /**
   * * [
   *    *   ["1","1","1","0","0"],
   *    *   ["0","0","0","0","0"],
   *    *   ["0","0","0","0","0"],
   *    *   ["0","0","0","0","0"],
   *    *   ["0","0","0","0","0"]
   *    * ]
   * @param args
   */

  // 2-D array to store cluster num for all 1-values

  public static void main(String[] args) {
	int[][] arr = new int[5][5];
	arr[0][0]=1;
	arr[0][1]=1;
	arr[0][2]=1;
	arr[0][3]=1;
	arr[1][0]=1;
	arr[1][1]=1;
	arr[1][3]=1;
	arr[2][0]=1;
	arr[2][1]=1;
	arr[2][2]=1;
	arr[3][3]=1;
	arr[3][4]=1;
	arr[4][4]=1;
	System.out.println(findNumberOfInfectedClusters(arr));
  }

  private static int findNumberOfInfectedClusters(int[][] arr) {
    int clusterNum = 0;
    int numRows = arr.length;
    int numColumns = numRows>0?arr[0].length:0;
    int[][] clusterNumArray = new int[numRows][numColumns];

    // iterate arr
	for(int i=0;i<numRows;i++) {
	  for (int j=0; j < numColumns; j++) {
	    if(arr[i][j]==1) {
		  if (adjacentClusterElementsZero(clusterNumArray, numRows, numColumns, i, j)) {
			clusterNum++;
		  }
		  clusterNumArray[i][j] = clusterNum;
		  System.out.println(clusterNumArray[i][j]);
		}
	  }
	}
	return clusterNum;
  }

  private static boolean adjacentClusterElementsZero(int[][] clusterNumArray, int numRows, int numColumns,
	  int i, int j) {
    // Check whether all adjacent elements are zero
	return (j<numColumns-1?clusterNumArray[i][j+1]==0:true)
		&& (j>0?clusterNumArray[i][j-1]==0:true)
		&& (i<numRows-1?clusterNumArray[i+1][j]==0:true)
		&& (i>0?clusterNumArray[i-1][j]==0:true);
  }

}
