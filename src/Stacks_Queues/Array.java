package Stacks_Queues;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    //add
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        if(size == data.length) {
            resize(2 * data.length);
        }

        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
        add(size, e);
    }

    //get
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size - 1);
    }

    //set
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
    }

    //contains
    public boolean contains(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //find
    public int find(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //remove
    public E remove(int index) {
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E res = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length) {
            resize(data.length / 2);
        }
        return res;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    //toString
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(',');
            }
            res.append(']');
        }
        return res.toString();
    }

    //resize
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
