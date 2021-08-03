import java.io.*;
import java.util.*;

public class TreasureCave {
    static int[] parent;
    static ArrayList<Integer> path;
    static Kattio io;
    static int P, NS, T;

    public static void main(String[] args) throws IOException {
        io = new Kattio();
        P = io.nextInt();
        NS = io.nextInt();
        T = io.nextInt();
        parent = new int[P];

        for (int i = 0; i < NS; i++) {
            int n = io.nextInt() - 1;
            parent[io.nextInt() - 1] = n;
            parent[io.nextInt() - 1] = n;
        }

        path = new ArrayList<Integer>();
        path.add(T - 1);
        int curr = T - 1;
        while (curr != 0) {
            curr = parent[curr];
            path.add(curr);
        }

        io.println(path.size());
        for (int i = path.size() - 1; i >= 0; i--) {
            io.println(path.get(i) + 1);
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
