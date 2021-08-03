import java.io.*;
import java.util.*;

public class DaisyChains {
    static int[] petals;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int i, j;
        petals = new int[n];
        int num = 0;
        for (i = 0; i < n; i++) {
            petals[i] = io.nextInt();
            for (j = 0; j <= i; j++) {
                if (average(i, j))
                    num++;
            }
        }
        io.println(num);
        io.close();

    }

    static boolean average(int i, int j) {
        double sum = 0;
        for (int k = j; k <= i; k++) {
            sum += petals[k];
        }
        sum = sum / (i - j + 1);
        for (int k = j; k <= i; k++) {
            if (petals[k] == sum)
                return true;
        }
        return false;
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
