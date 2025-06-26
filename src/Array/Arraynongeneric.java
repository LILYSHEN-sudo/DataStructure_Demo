package Array;

public class Arraynongeneric {
    private int[] data;
    private int size;

    public Arraynongeneric(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Arraynongeneric() {
        data = new int[10]; //this(10)
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

    public void addFirst(int e) {
        add(0, e);
    }
    public void addLast(int e) {
        add(size, e);
    }

    public void add(int index, int e) {
        if(index < 0 || index > data.length) {
            throw new IllegalArgumentException("Add failed. Index is illegal");
        }
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full");
        }
        data[index] = e;
        size++;
    }

    public int get(int index) {
        if(index < 0 || index > data.length) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if(index < 0 || index > data.length) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for(int i = 0; i < size; i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for(int i = 0; i < size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int remove(int index) {
        if(index < 0 || index > data.length) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        int ret = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }
    public int removeLast() {
        return remove(size - 1);
    }
    public void removeElement(int e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

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
        }
        res.append(']');
        return res.toString();
    }
}
