package Array;

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


}
