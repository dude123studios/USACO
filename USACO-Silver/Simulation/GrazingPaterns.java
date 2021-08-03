import java.io.*;
import java.util.*;

public class GrazingPaterns {
    static boolean canVisit[][];
    static int[] dx = { -1, 0, 0, 1 }, dy = { 0, 1, -1, 0 };
    static int n;

    public static int dfs(int x, int y, int length) {
        if (x == 5 && y == 5 && length == 25 - n) {
            return 1;
        }

        int paths = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!canVisit[nx][ny])
                continue;
            canVisit[nx][ny] = false;
            paths += dfs(nx, ny, length + 1);
            canVisit[nx][ny] = true;
        }
        return paths;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        canVisit = new boolean[5 + 2][5 + 2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                canVisit[i + 1][j + 1] = true;
            }
        }
        n = io.nextInt();
        for (int i = 0; i < n; i++) {
            canVisit[io.nextInt()][io.nextInt()] = false;
        }

        canVisit[1][1] = false;

        io.println(dfs(1, 1, 1));
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
