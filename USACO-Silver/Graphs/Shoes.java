import java.io.*;
import java.util.*;

public class Shoes {
    static Kattio io;
    static int N;
    static short[][] grid;
    static int max;
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };

    public static void dfs(int r, int c, int count, int next, int d) {
        if (grid[r][c] != next)
            return;

        if (count == 0)
            max = Math.max(max, d);

        short val = grid[r][c];
        grid[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (grid[nr][nc] == 0)
                continue;
            if (val == -1) {
                // Expect a (
                dfs(nr, nc, count + 1, -1, d + 1);
            }
            // Expect a )
            dfs(nr, nc, count - 1, 1, d + 1);

        }
        grid[r][c] = val;
    }

    public static void main(String[] args) throws IOException {
        io = new Kattio();
        N = io.nextInt();
        grid = new short[N + 2][N + 2];
        for (int i = 0; i < N; i++) {
            String line = io.next();
            for (int j = 0; j < N; j++) {
                grid[i + 1][j + 1] = (short) (line.charAt(j) == '(' ? -1 : 1);
            }
        }
        dfs(1, 1, 1, -1, 1);
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