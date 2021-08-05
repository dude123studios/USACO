import java.io.*;
import java.util.*;

public class Racing {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int m = io.nextInt();
        int t = io.nextInt();
        int u = io.nextInt();
        int f = io.nextInt();
        int d = io.nextInt();

        int time = 0;
        int i;
        for (i = 0; i < t; i++) {
            String token = io.next();
            if (token.equals("u")) {
                time += (u + d);
            } else if (token.equals("f")) {
                time += 2 * f;
            } else {
                time += (u + d);
            }
            if (time > m)
                break;
        }
        io.println(i);
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
