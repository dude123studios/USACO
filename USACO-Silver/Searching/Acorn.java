import java.io.*;
import java.util.*;

public class Acorn {
    static int k, n;
    static int[] targets;

    static boolean check(int r) {
        int index = 0;
        for (int i = 0; i < k; i++) {
            int loc = targets[index] + 2 * r;
            while (index < n && targets[index] <= loc) {
                index++;
            }
            if (index == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        k = io.nextInt();
        targets = new int[n];
        for (int i = 0; i < n; i++) {
            targets[i] = io.nextInt();
        }
        Arrays.sort(targets);
        int r = targets[n - 1];
        int low = 0, high = r;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
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
