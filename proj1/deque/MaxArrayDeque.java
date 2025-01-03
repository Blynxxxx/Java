package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> mc;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        mc = c;
    }

    public T max() {
        return max(mc);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T returnItem = get(0);
        for (T i : this) {
            if (c.compare(returnItem, i) < 0) {
                returnItem = i;
            }
        }
        return returnItem;
    }

}
