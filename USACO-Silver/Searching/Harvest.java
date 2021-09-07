import java.io.*;
import java.util.*;

public class Harvest {
    static int a, b, c, d, e, f, g, h;

    static long pow(int a, int b, int mod) {
        long prod = 1;
        for (int i = 0; i < b; i++) {
            prod = (prod * a) % mod;
        }
        return prod;
    }

    static class Acorn implements Comparable<Acorn> {
        long w, u;

        public Acorn(int i) {
            int modD = i % d;
            int modH = i % h;
            w = ((a % d) * pow(modD, 5, d) + b * pow(modD, 2, d) + c) % d;
            u = ((e % h) * pow(modH, 5, h) + f * pow(modH, 3, h) + g) % h;
        }

        public int compareTo(Acorn o) {
            if (o.u > u)
                return 1;
            if (o.u == u)
                return o.w < w ? 1 : -1;
            return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");
        int n = io.nextInt();
        a = io.nextInt();
        b = io.nextInt();
        c = io.nextInt();
        d = io.nextInt();
        e = io.nextInt();
        f = io.nextInt();
        g = io.nextInt();
        h = io.nextInt();
        int m = io.nextInt();
        Acorn[] acorns = new Acorn[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            acorns[i] = new Acorn(i);
        }
        Arrays.sort(acorns);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + acorns[i].w) % m;
        }
        io.println(sum);
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
