package Stacks_Queues;

//泛型
public class Array<E> {
     private E[] data;
     private int size;

     public Array(int capacity) {
         data = (E[])new Object[capacity];
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
    public void add(int index, E e){
         if(index < 0 || index > size) {
             throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
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
    //addLast
    public void addLast(E e) {
         add(size, e);
    }
    //addFirst
    public void addFirst(E e) {
         add(0, e);
    }

    //get
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }
        return data[index];
    }
    public E getLast() {
        return get(size - 1);
    }

    //set
    public E set(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }
        return data[index];
    }

    //contains
    public boolean contains(E e) {
         for(int i = 0; i < size; i++){
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
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }
        E res = data[index];
        for(int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return res;
    }

    //removeFirst
    public E removeFirst() {
         return remove(0);
    }
    //removeLast
    public E removeLast() {
         return remove(size);
    }
    //removeElement
    public void removeElement(E e) {
         int index = find(e);
         if(index != -1) {
             remove(index);
         }
    }

    //resize
    public void resize(int newCapacity) {
         E[] newData = (E[])new Object[newCapacity];
         for(int i = 0; i < size; i++) {
             newData[i] = data[i];
         }
         data = newData;
    }

    //toString
    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
         sb.append('[');
         for(int i = 0; i < size; i++) {
             sb.append(data[i]);
             if(i != size - 1) {
                 sb.append(", ");
             }
         }
         sb.append(']');
         return sb.toString();
    }

    public static void main(String[] args) {
         Array<Integer> arr = new Array<Integer>();
         for(int i = 0; i < 10; i++) {
             arr.addLast(i);
         }
         System.out.println(arr);

         arr.add(1, 100);
        System.out.println(arr);

         arr.addFirst(-1);
        System.out.println(arr);

         arr.remove(2);
        System.out.println(arr);

         arr.removeElement(4);
        System.out.println(arr);

         arr.removeFirst();
        System.out.println(arr);
    }
}
