package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    // invariant: index of Last = (First + size -1)/length
    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }


    /**
     * Adds an item of type T to the front of the deque. You can assume that item is never null.
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst -  1 + items.length) % items.length;
        size += 1;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            a[i] = items[(nextFirst + 1 + i) % items.length];
        }
        items = a;
        nextFirst = items.length -1;
        nextLast = size;
    }

    /**
     * Adds an item of type T to the back of the deque. You can assume that item is never null.
     */
    @Override
    public void addLast(T item) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
//    public boolean isEmpty() {
//        return size == 0;
//    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++){
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if ((size < items.length / 5) && (items.length >= 16)) {
            resize(items.length /2);
        }
        T result = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size -= 1;
        return result;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        if ((size < items.length / 5) && (items.length >= 16)) {
            resize(items.length /2);
        }
        T result = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size -= 1;
        return result;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.*/
    @Override
    public T get(int index){
        if (index >= size || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];

    }

    public Iterator<T> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int wizPos;

        public ArrayIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o instanceof ArrayDeque A) {
//            if (this.size != A.size) {
//                return false;
//            }
//            for (int i = 0; i < size; i++){
//                if (!this.get(i).equals(A.get(i))){
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this == o) { return true; } // optimization
        if (this.getClass() != o.getClass()) { return false; }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size() != other.size()) { return false; }
        for (int i = 0; i < size; i++){
            if (!this.get(i).equals(other.get(i))){
                return false;
            }
        }
        return true;
    }


//    public static void main(String[] args) {
//        ArrayDeque<Integer> L = new ArrayDeque<>();
//        L.addFirst(4);
////        L.addLast(5);
//        L.addFirst(3);
////        L.addFirst(5);
////        L.removeFirst();
////        L.removeLast();
////        L.removeLast();
//        L.addLast(7);
////        L.removeFirst();
////        L.addFirst(6);
////        L.printDeque();
////        System.out.println(L.size());
////        System.out.println(L.get(1));
//        for(int i : L) {
//            System.out.println(i);
//        }
//    }

}
