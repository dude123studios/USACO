import java.io.*;
import java.util.*;

public class Reflection {
    static Kattio io;
    static int n, m;
    static boolean[][] mirrors;
    static long count;

    public static void dfs(int r, int c, int lastr, int lastc) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return;
        count++;
        int dr = (r - lastr), dc = (c - lastc);
        int nr, nc;
        if (mirrors[r][c]) { // "/"
            if (dr > 0) {
                nr = r;
                nc = c - 1;
            } else if (dr < 0) {
                nr = r;
                nc = c + 1;
            } else if (dc > 0) {
                nc = c;
                nr = r - 1;
            } else {
                nc = c;
                nr = r + 1;
            }
        } else { // "\""
            if (dr > 0) {
                nr = r;
                nc = c + 1;
            } else if (dr < 0) {
                nr = r;
                nc = c - 1;
            } else if (dc > 0) {
                nc = c;
                nr = r + 1;
            } else {
                nc = c;
                nr = r - 1;
            }
        }
        dfs(nr, nc, r, c);

    }

    public static void main(String[] args) throws IOException {
        io = new Kattio("q");
        n = io.nextInt();
        m = io.nextInt();

        mirrors = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = io.next();
            for (int j = 0; j < m; j++) {
                mirrors[i][j] = (line.charAt(j) == '/');
            }
        }
        long max = 0;
        for (int i = 0; i < m; i++) {
            count = 0;
            dfs(0, i, -1, i);
            max = Math.max(max, count);
            count = 0;
            dfs(n - 1, i, n, i);
            max = Math.max(max, count);
        }
        for (int i = 0; i < n; i++) {
            count = 0;
            dfs(i, 0, i, -1);
            count = 0;
            dfs(i, m - 1, i, m);
            max = Math.max(max, count);
        }
        io.println(max);
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
