import java.io.*;
import java.util.*;

//-1 is red, 1 is blue, 0 is taken
public class Disco {
    static boolean[][] floor;
    static int rows, cols;
    static int ans;

    public static void dfs(int r, int c, boolean color) {
        if (r == rows - 1 && c == cols - 1) {
            ans++;
            return;
        }
        for (int i = r + 1; i < rows; i++) {
            for (int j = c + 1; j < rows; j++) {
                if (floor[i][j] != color)
                    continue;
                dfs(i, j, !color);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        rows = io.nextInt();
        cols = io.nextInt();

        floor = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = io.next();
            for (int j = 0; j < cols; j++) {
                floor[i][j] = line.charAt(j) == 'R';
            }
        }
        dfs(0, 0, !floor[0][0]);
        io.println(ans);
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
