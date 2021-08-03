import java.io.*;
import java.util.*;

class Point {
    long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long dist(long x2, long y2) {
        return (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y);
    }
}

public class Dinner {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), m = io.nextInt();
        Point[] cows = new Point[n];
        Point[] seats = new Point[m];
        for (int i = 0; i < n; i++) {
            cows[i] = new Point(io.nextLong(), io.nextLong());
        }
        for (int i = 0; i < m; i++) {
            seats[i] = new Point(io.nextLong(), io.nextLong());
        }
        boolean[] cowsUsed = new boolean[n];
        for (int i = 0; i < m; i++) {
            int minCow = -1;
            long minDist = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (cowsUsed[j])
                    continue;
                long dist = cows[j].dist(seats[i].x, seats[i].y);
                if (minDist > dist) {
                    minCow = j;
                    minDist = dist;
                }
            }
            cowsUsed[minCow] = true;
        }
        boolean none = true;
        for (int i = 0; i < n; i++) {
            if (!cowsUsed[i]) {
                io.println(i + 1);
                none = false;
            }
        }
        if (none)
            io.println(0);
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
