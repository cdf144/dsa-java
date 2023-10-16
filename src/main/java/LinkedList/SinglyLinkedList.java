package LinkedList;

public class SinglyLinkedList {
    public SinglyLinkedListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void printList() {
        for (SinglyLinkedListNode node = this.head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    public void insertNodeAtTail(int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (this.head == null) return;
        SinglyLinkedListNode tail = new SinglyLinkedListNode(this.head);
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

    public void insertNodeAtHead(int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertNodeAtPosition(int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode index = new SinglyLinkedListNode(this.head);
        for (int i = 1; i < position; i++) {
            index = index.next;
        }
        newNode.next = index.next;
        index.next = newNode;
    }

    public void deleteNode(int position) {
        if (position == 0) this.head = this.head.next;
        SinglyLinkedListNode index = new SinglyLinkedListNode(this.head);
        for (int i = 1; i < position; i++) {
            index = index.next;
        }
        index.next = index.next.next;
    }

    public void reversePrint(SinglyLinkedListNode listHead) {
        if (listHead == null) return;
        reversePrint(listHead.next);
        System.out.println(listHead.data);
    }

    public void reverseList() {
        // Write your code here
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = this.head;
        SinglyLinkedListNode nxt = this.head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if (nxt != null) nxt = nxt.next;
        }
    }

    public int getLength() {
        int len = 0;
        SinglyLinkedListNode itr = new SinglyLinkedListNode(this.head);
        while (this.head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public int getNode(int positionFromTail) {
        // Write your code here
        int len = getLength();
        SinglyLinkedListNode index = new SinglyLinkedListNode(this.head);
        for (int i=1; i < len - positionFromTail; ++i) {
            index = index.next;
        }
        return index.data;
    }
}

