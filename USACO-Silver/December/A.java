import java.io.*;
import java.util.*;

public class A {

    public static boolean c(int i, int val) {
        return (i < 0 && val < i) || (i > 0 && val > i);
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        int n = io.nextInt();
        int[] d = new int[n];
        // compute difference in temprature array
        for (int i = 0; i < n; i++) {
            d[i] = io.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] -= io.nextInt();
        }
        // we require the mins and maxes to loop through every slice
        // if the min is > 0 we still need to start at zero
        // if max < 0 we still need to got up to 0
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, d[i]);
            max = Math.max(max, d[i]);
        }
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if (i == 0)
                continue;
            boolean l = c(i, d[0]);
            for (int j = 1; j < n; j++) {
                if (c(i, d[j]))
                    l = true;
                else if (l) {
                    sum++;
                    l = false;
                }
            }
            if (c(i, d[n - 1]))
                sum++;
            System.out.println(i + "," + sum);
        }

        io.println(sum);
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
