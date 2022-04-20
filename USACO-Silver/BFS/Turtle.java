import java.io.*;
import java.util.*;

public class Turtle {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int m = io.nextInt(), n = io.nextInt(), m1 = io.nextInt(), m2 = io.nextInt();
        int startx = 0, starty = 0, endx = 0, endy = 0;
        boolean[][] arr = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = io.nextInt();
                if (val == 1) {
                    arr[i][j] = true;
                } else if (val == 4) {
                    arr[i][j] = true;
                    endx = i;
                    endy = j;
                } else if (val == 3) {
                    startx = i;
                    starty = j;
                }
            }
        }

        int[] dr = { m1, m1, -m1, -m1, m2, m2, -m2, -m2 }, dc = { m2, -m2, m2, -m2, m1, -m1, m1, -m1 };

        Queue<Integer> posxs = new LinkedList<Integer>();
        Queue<Integer> posys = new LinkedList<Integer>();
        Queue<Integer> times = new LinkedList<Integer>();

        posxs.add(startx);
        posys.add(starty);
        times.add(0);

        int[][] visited = new int[m][n];
        // bfs on answer
        while (!posxs.isEmpty()) {
            int x = posxs.poll();
            int y = posys.poll();
            int time = times.poll();
            if (x == endx && y == endy) {
                io.println(time);
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] && visited[nx][ny] == 0) {
                    posxs.add(nx);
                    posys.add(ny);
                    times.add(time + 1);
                    visited[nx][ny] = 1;
                }
            }
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
