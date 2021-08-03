import java.io.*;
import java.util.*;

public class Grass {
    static ArrayList<Integer> field[];
    static int N;
    static Kattio io;

    public static void main(String[] args) throws IOException {
        io = new Kattio();
        N = io.nextInt();
        field = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            field[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = io.nextInt(), b = io.nextInt();
            field[a - 1].add(b - 1);
            field[b - 1].add(a - 1);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, field[i].size());
        }
        io.println(max + 1);
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
