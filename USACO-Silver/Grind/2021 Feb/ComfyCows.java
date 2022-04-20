import java.io.*;
import java.util.*;

public class ComfyCows {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        int n = io.nextInt();
        boolean[][] b = new boolean[2004][2004];

        LinkedList<Integer> x = new LinkedList<Integer>(), y = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            int r = io.nextInt() + 1002, c = io.nextInt() + 1002;
            b[r][c] = true;
            x.add(r);
            y.add(c);
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int ans = 0;
        while (!x.isEmpty()) {
            int r = x.poll();
            int c = y.poll();
            int changer = 0, changec = 0, total = 0;
            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if (!b[nr][nc]) {
                    total++;
                    changer = nr;
                    changec = nc;
                }
            }
            if (total != 1)
                continue;
            ans++;
            b[changer][changec] = true;
            for (int[] dir : dirs) {
                int nr = dir[0] + changer;
                int nc = dir[1] + changec;
                if (b[nr][nc] && !(nr == r && nc == c)) {
                    x.add(nr);
                    y.add(nc);
                }
            }
        }
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