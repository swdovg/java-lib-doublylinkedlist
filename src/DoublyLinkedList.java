public class DoublyLinkedList {

    private int size;
    private Node head;
    private Node tail;

    DoublyLinkedList() {
        size = 0;
        head = tail = null;
    }

    public synchronized void pushHead(Object value) {
        Node tmp = new Node();
        tmp.data=value;
        tmp.prev=head;
        tmp.next=null;

        if (head != null)
            head.prev = tmp;

        head = tmp;

        if (tail == null)
            tail = tmp;

        size++;
    }

    public synchronized Object popHead() {
        Node prev = new Node();
        if (head == null)
            return null;

        prev = head;
        head = head.next;
        if (head != null)
            head.prev = null;
        if (prev == tail)
            tail = null;

        size--;
        return prev.data;
    }

    public synchronized void pushTail(Object value) {
        Node tmp = new Node ();
        tmp.data=value;
        tmp.prev=tail;
        tmp.next=null;

        if (tail != null)
            tail.next = tmp;

        tail = tmp;

        if (head == null)
            head = tmp;

        size++;
    }

    public synchronized Object popTail() {
        Node next = new Node();
        if (tail == null)
            return null;

        next = tail;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        if (next == head)
            head = null;

        size--;
        return tail.data;
    }

    public synchronized Node getNth(int index) {
        Node tmp = new Node();
        int i=0;

        if ( (index < 0) || (index > size) )
            return null;

        while (tmp != null && i < index) {
            tmp = tmp.next;
            i++;
        }

        return tmp;
    }

    public synchronized void pushNth() {

    }

    public synchronized Object popNth() {

    }

    public synchronized boolean isListEmpty() {
        if (( head == null ) && ( tail == null ))
            return true;
        else
            return false;
    }

    public synchronized Node findNode() {

    }

    public synchronized DoublyLinkedList filter () {

    }


    public synchronized DoublyLinkedList reverse() {

    }


}
