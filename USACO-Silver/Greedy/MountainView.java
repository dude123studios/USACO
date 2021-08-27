import java.io.*;
import java.util.*;

class Range implements Comparable<Range> {
    int start, end, height;

    public Range(int x, int y) {
        this.start = x - y;
        this.end = x + y;
        this.height = y;
    }

    public int compareTo(Range p) {
        if (p.start == start) {
            if (p.height < height)
                return -1;
            return 1;
        }
        return p.start < start ? 1 : -1;
    }
}

public class MountainView {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            ranges[i] = new Range(io.nextInt(), io.nextInt());
        }
        Arrays.sort(ranges);
        int maxr = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ranges[i].end <= maxr)
                continue;
            maxr = ranges[i].end;
            count++;
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
