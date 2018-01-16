interface Filterable {
    public boolean filterItem(Node node);
}

public class DoublyLinkedList {

    private int size;
    private Node head;
    private Node tail;

    DoublyLinkedList() {
        size = 0;
        head = tail = null;
    }

    public synchronized int getSize() {
        return size;
    }

    public synchronized Node getHead() {
        return head;
    }

    public synchronized Node getTail() {
        return tail;
    }

    public synchronized void pushHead(Object value) {
        Node tmp = new Node();
        tmp.data=value;
        tmp.next=head;
        tmp.prev=null;

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
        return next.data;
    }

    public synchronized Node getNth(int index) {
        Node tmp = head;
        int i=0;

        if ( (index < 0) || (index > size) )
            return null;

        while (tmp != null && i < index) {
            tmp = tmp.next;
            i++;
        }
        return tmp;
    }

    public synchronized void pushNth(int index, Object value) {
        Node ins = new Node();
        Node elm = getNth(index);

        if (elm==null)
            return;
        ins.data = value;
        ins.prev = elm;
        ins.next = elm.next;

        if (elm.next != null)
            elm.next.prev=ins;

        elm.next=ins;

        if (elm.prev == null)
            head=elm;

        if (elm.next == null)
            tail=elm;

        size++;
    }

    public synchronized Object popNth(int index) {
        Object tmp = new Node();
        Node elm = getNth(index);

        if (elm == null)
            return null;

        if (elm.prev != null)
            elm.prev.next=elm.next;

        if (elm.next != null)
            elm.next.prev=elm.prev;

        tmp = elm.data;

        if (elm.prev == null)
            head = elm.next;

        if (elm.next == null)
            tail = elm.prev;

        size--;

        return tmp;
    }

    public synchronized boolean isListEmpty() {
        if (( head == null ) && ( tail == null ))
            return true;
        else
            return false;
    }

    public synchronized Node findNode(Object value) {
        if (head == null)
            return null;

        Node tmp = head;

        while (tmp != null) {
            if (tmp.data.equals(value)) {
                return tmp;
            }
            tmp=tmp.next;
        }
        return null;
    }

    public synchronized DoublyLinkedList filter (Filterable p) {
        if (head == null)
            return null;
        DoublyLinkedList newList = new DoublyLinkedList();
        Node tmp = head;

        while (tmp != null) {
            if (p.filterItem(tmp))
                newList.pushTail(tmp.data);
            tmp=tmp.next;
        }
        return newList;
    }


    public synchronized DoublyLinkedList reverse() {
        if (head == null)
            return null;

        DoublyLinkedList newList = new DoublyLinkedList();
        Node tmp = head;

        while (tmp != null) {
            newList.pushHead(tmp.data);
            tmp=tmp.next;
        }
        return newList;
    }

    public synchronized void PrintDblLinkedList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data.toString()+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}