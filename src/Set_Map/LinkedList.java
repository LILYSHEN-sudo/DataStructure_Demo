package Set_Map;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(Node next, E e) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            this(null, e);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //add
    public void add(int index, E e) {
        if(index < 0 && index > size) {
            throw new IllegalArgumentException("Add failed. The index is illegal.");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    //addFirst
    public void addFirst(E e) {
        add(0, e);
    }

    //addLast
    public void addLast(E e) {
        add(size, e);
    }

    //get
    public E get(int index) {
        if(index < 0 && index >= size) {
            throw new IllegalArgumentException("Add failed. The index is illegal.");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size - 1);
    }

    //set
    public void set(int index, E e) {
        if(index < 0 && index >= size) {
            throw new IllegalArgumentException("Add failed. The index is illegal.");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //contains
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.e == e) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //remove
    public E remove(int index) {
        if(index < 0 && index >= size) {
            throw new IllegalArgumentException("Add failed. The index is illegal.");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }
    //removeFirst
    public E removeFirst() {
        return remove(0);
    }
    //removeLast
    public E removeLast() {
        return remove(size - 1);
    }
    //removeElement
    public void removeElement(E e) {
        Node prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node cur = prev.next;
            prev.next = cur.next;
            cur.next = null;
            size--;
        }
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("Null");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            list.addLast(i);
            System.out.println(list);
        }
        list.set(2, 100);
        System.out.println(list);
        Boolean res = list.contains(10);
        System.out.println(res);

        list.remove(1);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.removeElement(100);
        System.out.println(list);
    }
}
