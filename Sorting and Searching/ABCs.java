import java.io.*;
import java.util.*;

public class ABCs {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int a = 0, b = -1, c = -1;
        int[] vals = new int[7];
        for (int i = 1; i < 7; i++) {
            vals[i] = io.nextInt();
            if (vals[i] < vals[a]) {
                a = i;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (i != a) {
                if (b == -1)
                    b = i;
                else if (vals[i] < vals[b])
                    b = i;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (i != a && i != b && i != a + b) {
                if (c == -1)
                    c = i;
                else if (vals[i] < vals[c])
                    c = i;
            }
        }
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