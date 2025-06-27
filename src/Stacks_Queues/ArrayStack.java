package Stacks_Queues;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack() {
        array = new Array<>();
    }

    //int getSize()
    @Override
    public int getSize() {
        return array.getSize();
    }

//    boolean isEmpty()
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

//    void push(E e)
    @Override
    public void push(E e) {
        array.addLast(e);
    }

//    E pop()
    @Override
    public E pop() {
        return array.removeLast();
    }

//    E peek()
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append('[');
        for(int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if( i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

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
