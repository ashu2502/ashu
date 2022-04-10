/*
public class LinkedList {
    public static void main(String[] args) {
        Node head = createLinkedList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        printLinkedList(head);
        //printLinkedList(reverseLL(head));
        printLinkedList(reverseGroupsInLL(head,3));
    }

    private static Node reverseLL(Node head) {
        Node currentNode = head;
        Node prev = null;
        Node next = null;
        while(currentNode!=null) {
            next = currentNode.next;
            currentNode.next=prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    private static Node reverseGroupsInLL(Node head, int groupSize) {
        Node currentNode = head;
        Node prev = null;
        int k=0;
        while (currentNode!=null) {
            if(k%2==0) {
                currentNode = reverseSubList(currentNode, groupSize);
                if(k==0) head = currentNode;
                else prev.next = currentNode;
            }
            for(int i = 0; i<groupSize; i++) {
                prev = currentNode;
                currentNode = currentNode.next;
            }
            k++;
        }
        return head;
    }

    private static Node reverseSubList(Node head, int size) {
        Node firstNode = head;
        Node prev = null;
        Node next = head;
        int count=0;
        while(head!=null && count<size) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count++;
        }
        firstNode.next = head;
        return prev;
    }


    private static void printLinkedList(Node head) {
        System.out.println();
        while(head!=null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static Node createLinkedList(int... data) {
        Node head = new Node();
        Node prevNode = null;
        for(int i : data) {
            Node currentNode = new Node();
            if(prevNode!=null) {
                prevNode.next = currentNode;
            } else {
                head = currentNode;
            }
            currentNode.data = i;
            currentNode.next = null;
            prevNode = currentNode;
        }
        return head;
    }

    private static int findLength(Node head) {
        if(head==null) return 0;
        return 
    }

}

class Node {
    int data;
    Node next;
    Node() {
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}*/
