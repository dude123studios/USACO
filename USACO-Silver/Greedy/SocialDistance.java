import java.io.*;
import java.util.*;

class Interval {
    int s, e;

    public Interval(int start, int end) {
        this.s = start;
        this.e = end;
    }
}

public class SocialDistance {
    static Interval[] intervals;
    static int n, m;

    static boolean check(int dist) {
        int index = 0;
        int prev = intervals[0].s;
        for (int i = 0; i < n; i++) {
            while (index < m && prev + dist > intervals[index].e) {
                index++;
            }
            if (index >= m) {
                return false;
            }
            prev = intervals[index].s;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        int high = 0;
        intervals = new Interval[m];
        for (int i = 0; i < m; i++) {
            int s = io.nextInt();
            int e = io.nextInt();
            high = Math.max(high, e);
            intervals[i] = new Interval(io.nextInt(), io.nextInt());
        }
        int low = 0;
        high = high / 2;
        int max = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            if (check(mid)) {
                high = mid - 1;
            }
        }
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
