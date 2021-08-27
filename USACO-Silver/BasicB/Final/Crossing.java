import java.io.*;
import java.util.*;

public class Crossing {

    static int n, m, c;
    static int[] t;

    static boolean check(int d) {
        int index = 0;
        for (int i = 0; i < m; i++) {
            int first = t[index];
            int count = 1;
            while (count <= c && index < n && t[index] - first <= d) {
                index++;
                count++;
            }

            if (index >= n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        c = io.nextInt();
        t = new int[n];
        int high = 0;
        for (int i = 0; i < n; i++) {
            t[i] = io.nextInt();
            high = Math.max(high, t[i]);
        }
        Arrays.sort(t);
        int low = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        io.println(high);
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
