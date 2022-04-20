import java.io.*;
import java.util.*;

public class PET {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();

        // Compute prefix sums
        int[] t = new int[n + 1], p = new int[n + 1], e = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String move = io.next();
            e[i] = e[i - 1];
            p[i] = p[i - 1];
            t[i] = t[i - 1];
            if (move.equals("E")) {
                e[i]++;
            } else if (move.equals("P")) {
                p[i]++;
            } else {
                t[i]++;
            }
        }
        int[][] counts = { e, p, t };
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    max = Math.max(max, counts[j][i] + counts[k][n] - counts[k][i]);
                }
            }
        }
        io.println(max);
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
