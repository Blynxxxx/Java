package deque;

public class ArrayDeque<T> {

    private final T[] items;
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
    public void addFirst(T item) {
//        if (size == items.length) {
//            resize(size * 2);
//        }
        items[nextFirst] = item;
        nextFirst = (nextFirst -  1 + items.length) % items.length;
        size += 1;
    }

//    /** Resizes the underlying array to the target capacity. */
//    private void resize(int capacity) {
//        T[] a = (T[]) new Object[capacity];
//        System.arraycopy(items, 0, a, 0, size);
//        items = a;
//    }

    /**
     * Adds an item of type T to the back of the deque. You can assume that item is never null.
     */
    public void addLast(T item) {
//        if (size == items.length) {
//            resize(size * 2);
//        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        for (int i = 0; i < size; i++){
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
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
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        T result = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size -= 1;
        return result;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.*/
    public T get(int index){
        if (index >= size || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];

    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> L = new ArrayDeque<>();
//        L.addFirst(4);
////        L.addLast(5);
//        L.addFirst(3);
//        L.addFirst(5);
////        L.removeFirst();
//        L.removeLast();
//        L.removeLast();
//        L.addLast(7);
//        L.removeFirst();
//        L.addFirst(6);
//        L.printDeque();
//        System.out.println(L.size());
//        System.out.println(L.get(1));
//    }

}