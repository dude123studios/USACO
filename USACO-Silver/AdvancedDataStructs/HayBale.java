import java.io.*;
import java.util.*;

public class HayBale {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt();
        int[] increments = new int[n + 1]; // n-1th value is for padding
        for (int i = 0; i < k; i++) {
            int l = io.nextInt() - 1;
            int h = io.nextInt() - 1;
            increments[l]++;
            increments[h + 1]--;
        }
        int[] vals = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vals[i] = vals[i - 1] + increments[i - 1];
        }
        Arrays.sort(vals);
        io.println(vals[n / 2 + 1]);
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
