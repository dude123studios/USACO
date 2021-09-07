import java.io.*;
import java.util.*;

//2 - cow, 1 - filled, 0 - unfilled
public class WhyCowCrossRoad {
    static int[][] field;
    static Pair[][] roads;
    static Pair[] cows;
    static int nonDistant;
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };

    static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (field[nr][nc] == 1)
                continue;
            if (roads[r][c].r == nr && roads[r][c].c == nc)
                continue;
            if (field[nr][nc] == 2)
                nonDistant++;
            field[nr][nc] = 1;
            dfs(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt(), r = io.nextInt();
        field = new int[n][n];
        roads = new Pair[n][n];
        for (int i = 0; i < r; i++) {
            int ri = io.nextInt() - 1, ci = io.nextInt() - 1, r_i = io.nextInt() - 1, c_i = io.nextInt() - 1;
            roads[ri][ci] = new Pair(r_i, c_i);
            roads[r_i][c_i] = new Pair(ri, ci);
        }
        for (int i = 0; i < k; i++) {
            int x = io.nextInt() - 1, y = io.nextInt() - 1;
            field[x][y] = 2;
            cows[i] = new Pair(x, y);
        }
        int[][] temp = field.clone();
        int total = 0;
        for (int i = 0; i < k; i++) {
            field[cows[i].r][cows[i].c] = 1;
            dfs(cows[i].r, cows[i].c);
            temp[cows[i].r][cows[i].c] = 0;
            field = temp;
            temp = temp.clone();
            total += (k - nonDistant);
            nonDistant = 0;
        }
        io.println(total);
        io.close();
    }

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
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
