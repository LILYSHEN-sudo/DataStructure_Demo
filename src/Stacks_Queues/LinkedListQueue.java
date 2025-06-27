package Stacks_Queues;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> list;
    public LinkedListQueue() {
        list = new LinkedList<E>();
    }

//    int getSize();
    @Override
    public int getSize() {
        return list.getSize();
    }
//    boolean isEmpty();
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

//    void enqueue(E e);
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }
//    E dequeue();
    @Override
    public E dequeue() {
        return list.removeFirst();
    }

//    E getFront();
    @Override
    public E getFront() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue: Front [");
        sb.append(list);
        sb.append("] End");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        for(int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        int res = queue.getFront();
        System.out.println(res);

        queue.dequeue();
        System.out.println(queue);
    }

}
