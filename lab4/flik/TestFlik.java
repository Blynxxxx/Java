package flik;

import static flik.Flik.isSameNumber;
import static org.junit.Assert.assertTrue;


public class TestFlik {
    @org.junit.Test
    public void test1() {
        int a = 128;
        int b = a;
        int c = 128;
        assertTrue(isSameNumber(a,c));
    }
}
