package practice.interview;

import java.util.HashSet;
import java.util.Set;


// 2 nodes -
public class GreyOrange {
  class Node {
    int data;
    Set<Node> nextNodes;
  }

  // Set of visited nodes
  static Set<Node> visitedNodes = new HashSet<>();

  public static void main(String[] args) {

  }
  // O(n^k+1), where k=max num of subnodes
  // O(n+k)
  private static int findMinPathLength(Node start, Node dest) {
    // if the node has not been visited
		// check
	if(visitedNodes.contains(start)) return Integer.MIN_VALUE;
	return 0;
  }

}
