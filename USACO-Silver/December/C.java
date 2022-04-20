import java.io.*;
import java.util.*;

public class C {

    static int n, k;
    static boolean[][] b;

    public static int dfs(int r, int c, int turns, boolean last) {
        if (r == n && c == n) {
            return 1;
        }
        int ans = 0;
        if (turns == k) {
            if (last) {
                int nr = r + 1;
                int nc = c;
                if (b[nr][nc]) {
                    ans += dfs(nr, nc, turns, true);
                }
            } else {
                int nr = r;
                int nc = c + 1;
                if (b[nr][nc]) {
                    ans += dfs(nr, nc, turns, false);
                }
            }
            return ans;
        }

        int nr = r + 1;
        int nc = c;
        int nt = turns;
        if (b[nr][nc]) {
            if (!last && !(r == 1 && c == 1))
                nt++;
            ;
            ans += dfs(nr, nc, nt, true);
        }
        nr = r;
        nc = c + 1;
        nt = turns;
        if (b[nr][nc]) {
            if (last && !(r == 1 && c == 1))
                nt++;
            ans += dfs(nr, nc, nt, false);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int t = io.nextInt();
        for (int p = 0; p < t; p++) {
            n = io.nextInt();
            k = io.nextInt();
            b = new boolean[n + 2][n + 2];
            for (int i = 0; i < n; i++) {
                String line = io.next();
                for (int j = 0; j < n; j++) {
                    if (line.charAt(j) == '.') {
                        b[i + 1][j + 1] = true;
                    }
                }
            }
            io.println(dfs(1, 1, 0, true));
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
