import java.io.*;
import java.util.*;

public class Mult {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), q = io.nextInt();
        int[][] ps = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String line = io.next();
            for (int j = 0; j < n; j++) {
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j];
                if (line.charAt(j) == '*')
                    ps[i + 1][j + 1]++;
            }
        }
        for (int i = 0; i < q; i++) {
            int y1 = io.nextInt() - 1, x1 = io.nextInt() - 1, y2 = io.nextInt(), x2 = io.nextInt();
            int area = ps[y2][x2] - ps[y1][x2] - ps[y2][x1] + ps[y1][x1];
            io.println(area);
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
