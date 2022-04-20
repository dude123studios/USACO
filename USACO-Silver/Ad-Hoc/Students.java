import java.io.*;
import java.util.*;

public class Students {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int s = io.nextInt();

        int[] x1s = new int[n], x2s = new int[n], y1s = new int[n], y2s = new int[n], stxs = new int[s], stys[s];


        HashMap<Integer, Integer> compressx = new HashMap<Integer, Integer>();
        int[] allx = new int[2 * n + s];
        for(int i=0; i<n; i++) {allx[i] = x1s[i];}
        for(int i=0; i<n; i++) {allx[i + n] = x2s[i];}
        for(int i=0; i<s; i++) {allx[i + 2 * n] = x1s[i];}

        Arrays.sort(allx);

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
