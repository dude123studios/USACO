import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Pair p) {
        if (p.end == end)
            return 0;
        return p.end < end ? 1 : -1;
    }
}

public class CrossyRoad {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int c = io.nextInt();
        int n = io.nextInt();
        int[] t = new int[c];
        Pair[] ab = new Pair[n];
        for (int i = 0; i < c; i++) {
            t[i] = io.nextInt();
        }
        Arrays.sort(t);
        for (int i = 0; i < n; i++) {
            ab[i] = new Pair(io.nextInt(), io.nextInt());
        }
        Arrays.sort(ab);
        boolean[] paired = new boolean[n];
        int count = 0;
        for (int i = 0; i < c; i++) {
            int best = -1;
            for (int j = 0; j < n; j++) {
                if (!paired[j] && ab[j].start <= t[i] && ab[j].end >= t[i]) {
                    paired[best] = true;
                    count++;
                    break;
                }
            }
        }
        io.println(count);
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
