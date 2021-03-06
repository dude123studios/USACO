import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    long s, e;

    public Interval(long start, long end) {
        this.s = start;
        this.e = end;
    }

    public int compareTo(Interval other) {
        return other.s > s ? -1 : 1;
    }
}

public class SocialDistance {
    static Interval[] intervals;
    static int n, m;

    static boolean check(long dist) {
        int index = 0;
        long prev = intervals[0].s;
        for (int i = 1; i < n; i++) {
            while (index < m && prev + dist > intervals[index].e) {
                index++;
            }
            if (index >= m) {
                return false;
            }
            if (prev + dist < intervals[index].s) {
                prev = intervals[index].s;
            } else {
                prev = prev + dist;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        long high = 0;
        intervals = new Interval[m];
        for (int i = 0; i < m; i++) {
            long s = io.nextInt();
            long e = io.nextInt();
            high = Math.max(high, e);
            intervals[i] = new Interval(s, e);
        }
        Arrays.sort(intervals);
        long low = 0;
        while (low <= high) {
            long mid = (high + low) / 2;
            if (check(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
