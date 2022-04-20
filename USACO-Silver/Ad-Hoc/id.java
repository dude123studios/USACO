import java.io.*;
import java.util.*;

public class id {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] ps = new int[n + 1], a = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = (ps[i] + io.nextInt()) % 7;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ps[i + 1])) {
                maxlen = Math.max(maxlen, i - map.get(ps[i + 1]));
            } else {
                map.put(ps[i + 1], i);
            }
        }
        io.println(maxlen);
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
