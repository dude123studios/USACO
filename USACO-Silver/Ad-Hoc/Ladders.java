import java.io.*;
import java.util.*;

public class Ladders {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        String dir = io.next();
        boolean[][] a = new boolean[2001][2001];
        int areas = 0;
        int x = 1000, y = 1000;
        a[x][y] = true;
        HashMap<Character, int[]> map = new HashMap<Character, int[]>();
        map.put('N', new int[] { 0, 1 });
        map.put('S', new int[] { 0, -1 });
        map.put('E', new int[] { 1, 0 });
        map.put('W', new int[] { -1, 0 });
        for (int i = 0; i < n; i++) {
            int[] d = map.get(dir.charAt(i));
            x += d[0];
            y += d[1];
            if (a[x][y])
                areas++;
            a[x][y] = true;
        }

        io.println(areas);
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
