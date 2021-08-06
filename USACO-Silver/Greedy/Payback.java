import java.io.*;
import java.util.*;

public class Payback {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int money = 0;
        int debt = 0;
        int minIndex = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int di = io.nextInt();
            if (minIndex == -1 && di < 0)
                minIndex = i;
            if (di < 0)
                debt -= di;
            else
                money += di;
            if (money >= debt) {
                money -= debt;
                debt = 0;
                if (minIndex != -1)
                    ans += 2 * (i - minIndex);
                minIndex = -1;
            }
        }
        io.println(n + ans);
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