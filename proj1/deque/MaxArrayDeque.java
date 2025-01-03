package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    Comparator<T> mc;
    /** Create a MaxArrayDeque with the given Comparator.*/
    public MaxArrayDeque(Comparator<T> c){
        super();
        mc = c;
    }

    /** Returns the maximum element in the deque as governed by the previously given Comparator. If the MaxArrayDeque is empty, simply return null.*/
    public T max() {
//        if (isEmpty()) {
//            return null;
//        }
//        T returnItem = get(0);
//        for (T i: this) {
//            if (mc.compare(returnItem, i) < 0) {
//                returnItem = i;
//            }
//        }
//        return returnItem;
        return max(mc);
    }

    /** Returns the maximum element in the deque as governed by the parameter Comparator c. If the MaxArrayDeque is empty, simply return null.*/
    public T max(Comparator<T> c) {
        if(isEmpty()) {
            return null;
        }
        T returnItem = get(0);
        for (T i: this) {
            if (c.compare(returnItem, i) < 0) {
                returnItem = i;
            }
        }
        return returnItem;
    }

//    public static class MaxComparator implements Comparator<T> {
//        public int compare(T a, T b) {
//            return 1;
//        }
//    }
//
//    public static Comparator<T> getMaxComparator() {
//        return new MaxComparator();
//    }

}
