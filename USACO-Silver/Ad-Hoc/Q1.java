import java.io.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int m = io.nextInt(), n = io.nextInt();
        int startx = 0, starty = 0, endx = 0, endy = 0;
        boolean[][] arr = new boolean[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            String line = io.next();
            for (int j = 0; j < n; j++) {
                int val = line.charAt(j);
                if (val == '.') {
                    arr[i + 1][j + 1] = true;
                } else if (val == 'B') {
                    arr[i + 1][j + 1] = true;
                    endx = i;
                    endy = j;
                } else if (val == 'C') {
                    startx = i;
                    starty = j;
                }
            }
        }

        int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };

        Queue<Integer> posxs = new LinkedList<Integer>();
        Queue<Integer> posys = new LinkedList<Integer>();
        Queue<Integer> times = new LinkedList<Integer>();

        posxs.add(startx);
        posys.add(starty);
        times.add(0);

        // bfs on answer
        while (!posxs.isEmpty()) {
            int x = posxs.poll();
            int y = posys.poll();
            int time = times.poll();
            if (x == endx && y == endy) {
                io.println(time);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                if (arr[nx + 1][ny + 1]) {
                    posxs.add(nx);
                    posys.add(ny);
                    times.add(time + 1);
                    arr[nx + 1][ny + 1] = false;
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
