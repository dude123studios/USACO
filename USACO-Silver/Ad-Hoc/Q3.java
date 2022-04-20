import java.io.*;
import java.util.*;

public class Q3 {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int q = io.nextInt();
        int[] ps1 = new int[n + 1];
        int[] ps2 = new int[n + 1];
        int[] ps3 = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ps1[i + 1] = ps1[i];
            ps2[i + 1] = ps2[i];
            ps3[i + 1] = ps3[i];

            int val = io.nextInt();
            if (val == 1)
                ps1[i + 1]++;
            else if (val == 2)
                ps2[i + 1]++;
            else
                ps3[i + 1]++;

        }

        for (int i = 0; i < q; i++) {
            int a = io.nextInt(), b = io.nextInt();
            io.print(ps1[b] - ps1[a - 1] + " ");
            io.print(ps2[b] - ps2[a - 1] + " ");
            io.println(ps3[b] - ps3[a - 1]);

        }

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
