import java.io.*;
import java.util.*;

public class ABCs {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int a, b, c;
        int[] vals = new int[7];
        for (int i = 1; i < 7; i++) {
            vals[i] = io.nextInt();
        }
        Arrays.sort(vals);
        a = vals[0];
        b = vals[1];
        if (vals[2] != a + b)
            c = vals[2];
        else
            c = vals[3];

        io.println(a + " " + b + " " + c);
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