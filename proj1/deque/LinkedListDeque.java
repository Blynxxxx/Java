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
        return helperGetRecursive(s.next, index - 1);
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque ) {
            Deque<T> L = (Deque<T>) o;
            if (this.size != L.size()) {
                return false;
            }
            for (int i = 0; i < size; i++){
                if (!this.get(i).equals(L.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
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

}
