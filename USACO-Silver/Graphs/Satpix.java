import java.io.*;
import java.util.*;

public class Satpix {

    static boolean[][] img;
    static int rows, cols;
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };
    static int blob;

    public static void dfs(int r, int c) {
        blob++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!img[nr][nc])
                continue;
            img[nr][nc] = false;
            dfs(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        cols = io.nextInt();
        rows = io.nextInt();
        img = new boolean[rows + 2][cols + 2];
        for (int i = 0; i < rows; i++) {
            String line = io.next();
            for (int j = 0; j < cols; j++) {
                img[i + 1][j + 1] = line.charAt(j) == '*';
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (img[i + 1][j + 1]) {
                    img[i + 1][j + 1] = false;
                    blob = 0;
                    dfs(i + 1, j + 1);
                    max = Math.max(max, blob);
                }
            }
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
