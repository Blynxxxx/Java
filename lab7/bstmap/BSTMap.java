package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable <K>, V> implements Map61B<K, V>{

    private int size;
    private BSTNode root;

    public BSTMap() {
        root = null;
        size = 0;
    }

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode right;
        private BSTNode left;
        BSTNode (K i, V v) {
            key = i;
            value = v;
        }

    }
    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        BSTNode A = root;
        while (A!= null) {
            if (key.equals(A.key)) {
                return true;
            } else if (A.key.compareTo(key) < 0) {
                A = A.right;
            } else {
                A = A.left;
            }
        }
        return false;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        BSTNode A = root;
        while (A!= null) {
            if (key.equals(A.key)) {
                return A.value;
            } else if (A.key.compareTo(key) < 0) {
                A = A.right;
            } else {
                A = A.left;
            }
        }
        return null;
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
        size+=1;
    }

    private BSTNode putHelper (BSTNode x, K key, V value) {
        if (x == null) {
            return new BSTNode(key, value);
        }
        else if (x.key.compareTo(key) < 0) {
            x.right = putHelper(x.right, key, value);
        }
        else {
            x.left = putHelper(x.left, key, value);
        }
        return x;
    }
    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {

    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

//    private class KeyIterator<K> implements Iterator<K> {
//        private int wizPos;
//
//        KeyIterator() {
//            wizPos = 0;
//        }
//
//        public boolean hasNext() {
//            return wizPos < size;
//        }
//
//        public K next() {
//            K returnItem = get();
//            wizPos += 1;
//            return returnItem;
//        }
//    }
}
