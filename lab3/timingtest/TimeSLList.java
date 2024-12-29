package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<>();
        AList<Double> times= new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int i = 1000; i <= 128000; i = i*2) {
            Ns.addLast(i);

            SLList<Integer> L = new SLList<>(1);
            for (int j = 0; j < i; j++) {
                L.addLast(j);
            }
            int opCount = 0;
            Stopwatch sw = new Stopwatch();
            for (int n = 0; n < 10000; n++) {
                int val = L.getLast();
                opCount +=1;
            }
            double timeInSeconds = sw.elapsedTime();
            opCounts.addLast(opCount);
            times.addLast(timeInSeconds);
        }

        printTimingTable(Ns, times, opCounts);
    }
}


