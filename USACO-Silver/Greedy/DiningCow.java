import java.io.*;
import java.util.*;

public class DiningCow {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int left = 0, right = 0;
        boolean[] cows = new boolean[n];
        // 1: true, 2: false
        for (int i = 0; i < n; i++) {
            cows[i] = io.nextInt() == 1;
            if (cows[i])
                right++;
        }
        int min = left + right;
        for (int i = 0; i < n; i++) {
            if (cows[i])
                right--;
            else
                left++;
            min = Math.min(min, left + right);
        }
        io.println(min);
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
