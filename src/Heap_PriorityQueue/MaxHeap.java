package Heap_PriorityQueue;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
        data = new Array<>();
    }

    //getSize
    public int size() {
        return data.getSize();
    }
    //isEmpty
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //parent
    public int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1)/2;
    }
    //leftChild
    public int leftChild(int index) {
        return index * 2 + 1;
    }
    //rightChild
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //add
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //find max element in the Heap
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("can not findMax when heap is empty.");
        }
        return data.get(0);
    }
    //get max element in the Heap
    public E getMax() {
        E res = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return res;
    }
    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);  //data[k]和data[j]交换位置
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) >= 0) {
                j++;               //data[j]是leftChild和rightChild中的最大值
            }
            if(data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //get the max element in the Heap and replace it with e
    public E replace(E e) {
        E res = findMax();
        data.set(0, e);
        siftDown(0);
        return res;
    }
}