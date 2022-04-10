package practice.interview;

public class PubMatic {

  static class Node {
	int data;
	Node next;

	Node(int data, Node next) {
	  this.data = data;
	  this.next = next;
	}
  }

  public static void main(String[] args) {
    // 1->2->3->4
    Node nodeFour = new Node(4, null);
    Node nodeThree = new Node(3, nodeFour);
    Node nodeTwo = new Node(2, nodeThree);
    Node nodeOne = new Node(1, nodeTwo);

    nodeFour.next = nodeTwo;

    if(doesLoopExist(nodeOne)) {
	  System.out.println("Loop found");
	} else {
	  System.out.println("No loop found");
	}
  }

  private static boolean doesLoopExist(Node head) {
    Node slowPtr = head;
    Node fastPtr = (head!=null && head.next!=null)?head.next.next:null;

    while(fastPtr!=null && fastPtr.next!=null) {
     if(slowPtr==fastPtr) {
       return true;
	 }
     slowPtr=slowPtr.next;
     fastPtr=fastPtr.next.next;
	}
    return false;
  }

}
