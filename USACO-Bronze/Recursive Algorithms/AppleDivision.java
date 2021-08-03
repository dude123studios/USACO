
import java.io.*;
import java.util.*;

public class AppleDivision {
    static int[] weights;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            weights[i] = io.nextInt();
        }
        io.println(search(0, 0, 0));
        io.close();
    }

    public static int search(int n, int set1, int set2) {
        if (n == weights.length)
            return Math.abs(set1 - set2);
        return Math.min(search(n + 1, set1 + weights[n], set2), search(n + 1, set1, set2 + weights[n]));
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
