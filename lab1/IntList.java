import java.util.function.ToDoubleBiFunction;

/* Implement the method evenOdd by destructively changing the ordering of a given
IntList so that even indexed links precede odd indexed links.
For instance, if lst is defined as IntList.list(0, 3, 1, 4, 2, 5), evenOdd(lst)
would modify lst to be IntList.list(0, 1, 2, 3, 4, 5).
You may not need all the lines.
Hint: Make sure your solution works for lists of odd and even lengths.*/
public class IntList {
    public int first;
    public IntList rest;

    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null || lst.rest.rest == null) {
            return;
        }
        IntList temp = lst.rest;
        IntList temp1 = lst.rest;
        while(temp != null && temp.rest != null){
            lst.rest = new IntList(temp.rest.first, temp1);
            temp.rest = temp.rest.rest;
            lst = lst.rest;
            temp = temp.rest;
        }
    }


    public static IntList[] partition (IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst;
        while (L != null) {
            int i = index % k;
            array[i] = new IntList(L.first, array[i]);
            L = L.rest;
            index++;
        }
        return array;
    }

    private IntList reverse() {
        return new IntList(first, rest);
    }


    public static void main (String[] args) {
        IntList L = new IntList(6, null);
        L = new IntList(5,L);
        L = new IntList(2, L);
//        L = new IntList(4, L);
//        L = new IntList(1, L);
        L = new IntList(3,L);
        L = new IntList(0,L);

        IntList[] a = partition(L , 2);

    }

}