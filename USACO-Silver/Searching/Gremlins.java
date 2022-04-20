import java.io.*;
import java.util.*;

public class Gremlins {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt(), b = io.nextInt();
        boolean[] gremlins = new boolean[n];
        for (int i = 0; i < b; i++) {
            gremlins[io.nextInt() - 1] = true;
        }

        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i];
            if (gremlins[i])
                ps[i + 1]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            min = Math.min(min, ps[i + k - 1] - ps[i - 1]);
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
