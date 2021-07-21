import java.io.*;
import java.util.*;

public class Paths {
    static boolean grid[][];
    static String line;
    static int ans = 0;

    public static void search(int move, int x, int y) {
        if (x == 7 && y == 7 && move == 47) {
            ans++;
            return;
        }
        if (line.charAt(move) == '?') {
            int r = 0, c = 0;
            if (x < 6 && !grid[x + 1][y]) {
                grid[x + 1][y] = true;
                search(move + 1, x + 1, y);
                grid[x + 1][y] = false;
                r++;
            }
            if (x > 0 && !grid[x - 1][y]) {
                grid[x - 1][y] = true;
                search(move + 1, x - 1, y);
                grid[x - 1][y] = false;
                r--;
            }
            if (y < 6 && !grid[x][y + 1]) {
                grid[x][y + 1] = true;
                search(move + 1, x, y + 1);
                grid[x][y + 1] = false;
                c++;
            }
            if (y > 0 && !grid[x][y - 1]) {
                grid[x][y - 1] = true;
                search(move + 1, x, y - 1);
                grid[x][y - 1] = false;
                c--;
            }
        } else if (line.charAt(move) == 'U') {
            grid[x][y + 1] = true;
            search(move + 1, x, y + 1);
            grid[x][y + 1] = false;
        } else if (line.charAt(move) == 'D') {
            grid[x][y - 1] = true;
            search(move + 1, x, y - 1);
            grid[x][y - 1] = false;
        } else if (line.charAt(move) == 'L') {
            grid[x - 1][y] = true;
            search(move + 1, x - 1, y);
            grid[x - 1][y] = false;
        } else if (line.charAt(move) == 'R') {
            grid[x + 1][y] = true;
            search(move + 1, x + 1, y);
            grid[x + 1][y] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        grid = new boolean[7][7];
        line = io.next();
        grid[0][0] = true;
        grid[1][0] = true;
        search(1, 1, 0);

        io.println(ans * 2);
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