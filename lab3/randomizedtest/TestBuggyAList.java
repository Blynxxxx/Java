package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        A.addLast(6);
        A.addLast(5);
        A.addLast(4);

        BuggyAList<Integer> B = new BuggyAList<>();
        B.addLast(6);
        B.addLast(5);
        B.addLast(4);

        assertEquals(A.removeLast(), B.removeLast());
        assertEquals(A.removeLast(), B.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();

        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                assertEquals(sizeL, sizeB);
                System.out.println("size: " + sizeL);
            }
            //get Last
            //removeLast
            else {
                if (L.size() > 0){
                    if (operationNumber == 2) {
                        //get Last
                        int lastValL = L.getLast();
                        int lastValB = B.getLast();
                        assertEquals(lastValL, lastValB);
                        System.out.println("addLast(" + lastValL + ")");
                    }else {
                        //removeLast
                        int removedValL = L.removeLast();
                        int removedValB = B.removeLast();
                        assertEquals(removedValL, removedValB);
                        System.out.println("addLast(" + removedValL + ")");
                    }
                }
            }
        }

    }
}
