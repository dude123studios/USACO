import java.io.*;
import java.util.*;

public class Stroll {
    static int[][] field;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int c = io.nextInt(), r = io.nextInt();

        field = new int[r + 1][c + 1];
        int besx = 0, besy = 0;
        boolean bessie = false;
        int bx = 0, by = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                String val = io.next();
                field[j + 1][i + 1] = val.equals("R") ? -1 : 0;
                if (val.equals("B")) {
                    if (!bessie) {
                        besx = j;
                        besy = i;
                        bessie = true;
                        continue;
                    }
                    bx = j;
                    by = i;
                }
            }
        }
        field[besx][besy + 1] = 1;
        for (int i = besy + 1; i < c + 1; i++) {
            for (int j = besx + 1; j < r + 1; j++) {
                if (field[j][i] != -1) {
                    field[j][i] += field[j - 1][i] + field[j][i - 1];
                } else {
                    field[j][i] = 0;
                }
            }
        }
        io.println(field[bx + 1][by + 1]);
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
