import java.io.*;
import java.util.*;

public class Diversity {
    static int n, m;
    static int[][] striped, solid;

    static boolean check(int pos1, int pos2, int pos3) {
        boolean[] set = new boolean[64];
        for (int i = 0; i < n; i++) {
            int[] row = striped[i];
            set[row[pos1] + 4 * row[pos2] + 16 * row[pos3]] = true;
        }
        for (int i = 0; i < n; i++) {
            int[] row = solid[i];
            if (set[row[pos1] + 4 * row[pos2] + 16 * row[pos3]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('T', 1);
        map.put('C', 2);
        map.put('G', 3);

        striped = new int[n][m];
        solid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = io.next();
            for (int j = 0; j < m; j++) {
                striped[i][j] = map.get(line.charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            String line = io.next();
            for (int j = 0; j < m; j++) {
                solid[i][j] = map.get(line.charAt(j));
            }
        }

        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    if (check(i, j, k)) {
                        ans++;
                    }
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