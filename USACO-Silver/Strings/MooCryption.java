import java.io.*;
import java.util.*;

public class MooCryption {

    static HashMap<String, Integer> count = new HashMap<String, Integer>();

    static void increment(String str) {
        Integer val = count.get(str);
        if (val == null) {
            count.put(str, 1);
        } else {
            count.put(str, val + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int rows = io.nextInt(), cols = io.nextInt();
        char[][] grid = new char[rows + 4][cols + 4];

        for (int r = 0; r < rows; r++) {
            String line = io.next();
            for (int c = 0; c < cols; c++) {
                grid[r + 2][c + 2] = line.charAt(c);
            }
        }

        int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 }, dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
        for (int r = 2; r < rows + 2; r++) {
            for (int c = 2; c < cols + 2; c++) {
                if (grid[r][c] == 'M')
                    continue;
                for (int d = 0; d < 8; d++) {
                    char v1 = grid[r + dr[d]][c + dc[d]];
                    char v2 = grid[r + 2 * dr[d]][c + 2 * dc[d]];
                    if (v1 == 'O' || v1 == '\u0000')
                        continue;
                    if (v1 == v2 && v1 != grid[r][c]) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(grid[r][c]);
                        sb.append(v1);
                        sb.append(v2);
                        increment(sb.toString());
                    }
                }
            }
        }
        int max = 0;
        for (String key : count.keySet()) {
            max = Math.max(max, count.get(key));
        }

        io.println(max);
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
