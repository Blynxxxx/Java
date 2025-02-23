import java.lang.reflect.Array;

public class HelloNumbers {
    public static void main(String[] args) {
//        int x = 1;
//        int total = 0;
//        while (x <= 10) {
//            System.out.print(total + " ");
//            total = total + x;
//            x = x + 1;
//        }
        int[] A = {1,2, 3, 3};
        System.out.println(findSum(A, 5));

	}

    public static boolean findSum(int[] A, int x) {
        int L = A.length - 1;
        int i = 0;
        while (i!=L){
            if(A[i] + A[L] == x) {
                return true;
            }
            else if(A[i] + A[L] > x){
                L = L -1;
            }
            else{
                i = i +1;
            }
        }
        return false;
    }
} 
