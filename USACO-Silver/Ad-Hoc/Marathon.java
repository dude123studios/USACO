import java.io.*;
import java.util.*;

public class Marathon {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[][] checkpoints = new int[n][2];
        for (int i = 0; i < n; i++) {
            checkpoints[i][0] = io.nextInt();
            checkpoints[i][1] = io.nextInt();
        }
        int dist = 0;
        for (int i = 1; i < n; i++) {
            dist += (Math.abs(checkpoints[i - 1][0] - checkpoints[i][0])
                    + Math.abs(checkpoints[i - 1][1] - checkpoints[i][1]));
        }
        int maxSave = 0;
        for (int i = 1; i < n - 1; i++) {
            int dist1 = (Math.abs(checkpoints[i - 1][0] - checkpoints[i][0])
                    + Math.abs(checkpoints[i - 1][1] - checkpoints[i][1]));
            int dist2 = (Math.abs(checkpoints[i][0] - checkpoints[i + 1][0])
                    + Math.abs(checkpoints[i][1] - checkpoints[i + 1][1]));
            int dist3 = (Math.abs(checkpoints[i + 1][0] - checkpoints[i - 1][0])
                    + Math.abs(checkpoints[i + 1][1] - checkpoints[i - 1][1]));
            maxSave = Math.max(maxSave, dist1 + dist2 - dist3);
        }
        io.println(dist - maxSave);
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
