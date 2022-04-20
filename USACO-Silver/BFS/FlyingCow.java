import java.io.*;
import java.util.*;

public class FlyingCow {
    static Queue<Integer> pos, dist;
    static boolean[] v;
    static int n;

    static void add(int temp, int moves) {
        if (temp > 1 && temp <= n + 2 && !v[temp]) {
            pos.add(temp);
            dist.add(moves + 1);
            v[temp] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        n = io.nextInt();
        pos = new LinkedList<Integer>();
        dist = new LinkedList<Integer>();

        pos.add(1);
        dist.add(0);

        v = new boolean[n + 3];
        v[1] = true;
        while (!pos.isEmpty()) {
            int loc = pos.poll();
            int moves = dist.poll();

            if (loc == n) {
                io.println(moves);
                break;
            }

            add(loc * 3, moves);
            add(loc + 1, moves);
            add(loc - 1, moves);

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