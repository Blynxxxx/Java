package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {


    private final LList sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new LList(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T item) {
//        sentinel = new LList(null, null, null);
//        sentinel.next = new LList(item, sentinel, sentinel);
//        sentinel.pre = sentinel.next;
//        size += 1;
//    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new LList(item, sentinel.next, sentinel);
        sentinel.next.next.pre = sentinel.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        sentinel.pre = new LList(item, sentinel, sentinel.pre);
        sentinel.pre.pre.next = sentinel.pre;
        size += 1;
    }

//    public boolean isEmpty() {
//        return size == 0;
//    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (LList p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;
        return first;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -= 1;
        return last;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        LList p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }


    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        LList p = sentinel.next;
        return helperGetRecursive(p, index);
    }
    private T helperGetRecursive(LList s, int index) {
        if (index == 0) {
            return s.item;
        }
        return helperGetRecursive(s.next, index -1);
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int wizPos;

        public LinkedListIterator() {
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
//        if (o instanceof LinkedListDeque L) {
//            if (this.size != L.size) {
//                return false;
//            }
//            for (int i = 0; i < size; i++){
//                if (!this.get(i).equals(L.get(i))){
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
        Deque<T> other = (Deque<T>) o;
        if (this.size() != other.size()) { return false; }
        for (int i = 0; i < size; i++){
                if (!this.get(i).equals(other.get(i))){
                    return false;
                }
        }
        return true;
    }
    private class LList {
        public T item;
        public LList next;
        public LList pre;

        public LList(T i, LList n, LList p) {
            pre = p;
            item = i;
            next = n;
        }
    }

//    public static void main(String[] args) {
//        LinkedListDeque<Integer> L = new LinkedListDeque<>(2);
//        L.addFirst(4);
//        L.addLast(5);
//        L.printDeque();
//        System.out.println(L.getRecursive(2));
//        for (int i : L){
//            System.out.println(i);
//        }
//        LinkedListDeque<Integer> R = L;
//        System.out.println(L.equals(R));
//    }

}
