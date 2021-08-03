import java.io.*;
import java.util.*;

public class RelayRace {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] l = new int[n];
        int[] m = new int[n];
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            l[i] = io.nextInt();
            m[i] = io.nextInt();
            a[i] = new int[m[i]];
            for (int j = 0; j < m[i]; j++) {
                a[i][j] = io.nextInt() - 1;
            }
        }
        // -2 not gone yet, -1 done, n -> time at which it will be done
        int[] active = new int[n];
        active[0] = l[0];
        for (int i = 1; i < active.length; i++) {
            active[i] = -2;
        }
        int time = 0;
        int dc = 0;
        while (dc < n) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            // finds next cow that finishes
            for (int c = 0; c < n; c++) {
                if (active[c] >= 0 && active[c] < min) {
                    min = active[c];
                    index = c;
                }
            }
            time = active[index];
            dc++;
            for (int c = 0; c < m[index]; c++) {
                if (active[a[index][c]] == -2) {
                    // starts the other cows
                    active[a[index][c]] = time + l[a[index][c]];
                }
            }
            // sets the next cow that finishes to done
            active[index] = -1;
        }
        io.println(time);
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
