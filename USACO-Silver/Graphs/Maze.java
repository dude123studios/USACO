import java.io.*;
import java.util.*;

public class Maze {
    static StringBuilder sb;
    static boolean[][] maze;
    static int startr, startc, finishr, finishc;
    static Kattio io;
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };
    static char[] chars = { 'U', 'R', 'L', 'D' };

    public static void dfs(int r, int c) {
        if (maze[r][c])
            return;
        if (r == finishr && c == finishc) {
            io.println(sb.toString());
            io.close();
            System.exit(0);
        }
        maze[r][c] = true;
        for (int i = 0; i < 4; i++) {
            sb.append(chars[i]);
            dfs(dr[i] + r, dc[i] + c);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        io = new Kattio();

        sb = new StringBuilder();

        int r = io.nextInt();
        int c = io.nextInt();
        maze = new boolean[r][c];
        String line;
        for (int i = 0; i < r; i++) {
            line = io.next();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '#') {
                    maze[i][j] = true;
                } else if (line.charAt(j) == 'F') {
                    finishr = i;
                    finishc = j;
                } else if (line.charAt(j) == 'S') {
                    startr = i;
                    startc = j;
                }
            }
        }
        dfs(startr, startc);
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
