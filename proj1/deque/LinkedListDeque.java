package deque;

public class LinkedListDeque<T> {


    private final LList sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new LList(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new LList(null, null, null);
        sentinel.next = new LList(item, sentinel, sentinel);
        sentinel.pre = sentinel.next;
        size += 1;
    }


    public void addFirst(T item) {
        sentinel.next = new LList(item, sentinel.next, sentinel);
        sentinel.next.next.pre = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.pre = new LList(item, sentinel, sentinel.pre);
        sentinel.pre.pre.next = sentinel.pre;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (LList p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst() {
        if (sentinel.next.item == null) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;
        return first;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        if (sentinel.pre.item == null) {
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

//    public Iterator<T> iterator(){
//
//    }

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

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>(2);
        L.addFirst(4);
        L.addLast(5);
        L.printDeque();
        System.out.println(L.getRecursive(2));
    }

}
