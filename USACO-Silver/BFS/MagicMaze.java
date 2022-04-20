import java.io.*;
import java.util.*;

public class MagicMaze {
    static class Point {
        static int n;
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int hash() {
            return r * n + c;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt(), m = io.nextInt();
        boolean[][] v = new boolean[n + 2][m + 2];
        HashMap<Point, Point> teleport = new HashMap<Point, Point>();
        HashMap<Character, Point> firsts = new HashMap<Character, Point>();
        Point.n = n;
        int startr = -1, startc = -1, endr = -1, endc = -1;

        for (int i = 0; i < n; i++) {
            String line = io.next();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == '.')
                    v[i + 1][j + 1] = true;
                else if (c == '@') {
                    startr = i;
                    startc = j;
                } else if (c == '=') {
                    v[i + 1][j + 1] = true;
                    endr = i;
                    endc = j;
                } else {
                    v[i + 1][j + 1] = true;
                    Point p = new Point(i, j);
                    if (!firsts.containsKey(c)) {
                        firsts.put(c, p);
                    } else {
                        Point o = firsts.get(c);
                        teleport.put(o, p);
                        teleport.put(p, o);
                    }
                }
            }
        }

        Queue<Point> pos = new LinkedList<Point>();
        Queue<Integer> times = new LinkedList<Integer>();

        pos.add(new Point(startr, startc));
        times.add(0);

        int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
        while (!pos.isEmpty()) {
            Point p = pos.poll();
            int t = times.poll();

            if (p.r == endr && p.c == endc) {
                io.println(t);
                break;
            }

            Point o = teleport.get(p);
            if (o != null) {
                if (v[o.r + 1][o.c + 1]) {
                    pos.add(o);
                    times.add(t + 1);
                    v[p.r + 1][p.c + 1] = false;
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];
                    if (!v[nr + 1][nc + 1]) {
                        pos.add(new Point(nr, nc));
                        times.add(t + 1);
                        v[nr + 1][nc + 1] = true;
                    }
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
