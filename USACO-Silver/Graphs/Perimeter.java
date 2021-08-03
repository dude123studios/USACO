import java.io.*;
import java.util.*;

//-1: accesible
//0: used/outofbounds
//1: bale

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Perimeter {

    static short[][] field;
    static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };
    static Point bales[];

    public static void floodfill(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (field[nr][nc] != -1)
                continue;
            field[nr][nc] = 0;
            floodfill(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        bales = new Point[io.nextInt()];
        int n = 100;

        field = new short[n + 4][n + 4];
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                field[i + 1][j + 1] = -1;
            }
        }
        for (int i = 0; i < bales.length; i++) {
            int x = io.nextInt();
            int y = io.nextInt();
            field[x + 2][y + 2] = 1;
            bales[i] = new Point(x + 2, y + 2);
        }
        floodfill(1, 1);
        int total = 0;
        for (int i = 0; i < bales.length; i++) {
            for (int j = 0; j < 4; j++) {
                int nr = bales[i].x + dr[j];
                int nc = bales[i].y + dc[j];
                if (field[nr][nc] == 0)
                    total++;
            }
        }
        io.println(total);
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
