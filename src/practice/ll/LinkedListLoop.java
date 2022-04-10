package practice.ll;

public class LinkedListLoop {

  class Node {
    int data;
    Node next;
  }

  public static void main(String[] args) {
  }

  private static boolean doesLoopExist(Node head) {
    if(head==null || head.next==null) return false;
    Node slowPtr = head.next;
    Node fastPtr = head.next.next;

    while(slowPtr!=null && fastPtr!=null) {
      if(slowPtr==fastPtr) {
        return true;
	  } else {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next!=null?fastPtr.next.next:null;
	  }
	}
    return false;
  }
}
