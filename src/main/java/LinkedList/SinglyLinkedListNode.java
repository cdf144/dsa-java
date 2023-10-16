package LinkedList;

public class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }

    public SinglyLinkedListNode(SinglyLinkedListNode node) {
        this.data = node.data;
        this.next = node.next;
    }
}
