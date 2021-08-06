import java.io.*;
import java.util.*;

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class CowBeauty {
    static boolean[][] img;
    static ArrayList<Pair> first = new ArrayList<Pair>();
    static ArrayList<Pair> second = new ArrayList<Pair>();
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };

    public static void dfs(int r, int c, boolean isFirst) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!img[nr][nc])
                continue;
            img[nr][nc] = false;
            if (isFirst)
                first.add(new Pair(nr, nc));
            else
                second.add(new Pair(nr, nc));
            dfs(nr, nc, isFirst);
        }
    }

    public static void fill(int rows, int cols) {
        boolean isFirst = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (img[i + 1][j + 1]) {
                    if (isFirst) {
                        dfs(i + 1, j + 1, true);
                        isFirst = false;
                    } else {
                        dfs(i + 1, j + 1, false);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int rows = io.nextInt(), cols = io.nextInt();
        img = new boolean[rows + 2][cols + 2];
        for (int i = 0; i < rows; i++) {
            String line = io.next();
            for (int j = 0; j < cols; j++) {
                img[i + 1][j + 1] = line.charAt(j) == 'X';
            }
        }
        fill(rows, cols);
        long min = Long.MAX_VALUE;
        for (Pair firstSpot : first) {
            for (Pair secondSpot : second) {
                int dist = Math.abs(firstSpot.r - secondSpot.r) + Math.abs(firstSpot.c - secondSpot.c) - 1;
                min = Math.min(min, dist);
            }
        }
        io.println(min);
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
