package Stacks_Queues;

import LinkedList.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
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

//    void push(E e);
    @Override
    public void push(E e) {
        list.addLast(e);
    }
//    E pop();
    @Override
    public E pop() {
        return list.removeLast();
    }

//    E peek();
    @Override
    public E peek() {
        return list.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListStack: Front [");
        sb.append(list);
        sb.append("] End");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        for(int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        int res = stack.peek();
        System.out.println(res);

        stack.pop();
        System.out.println(stack);
    }
}
