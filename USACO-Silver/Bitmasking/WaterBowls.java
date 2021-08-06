import java.io.*;
import java.util.*;

public class WaterBowls {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        boolean[] bowls = new boolean[20];
        for (int i = 0; i < 20; i++) {
            bowls[i] = io.nextInt() == 0;
        }
        int min = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << 20); mask++) {
            int count = 0;
            boolean[] temp = bowls.clone();
            for (int i = 0; i < 20; i++) {
                if (((1 << i) & mask) > 0) {
                    if (i != 0)
                        temp[i - 1] = !temp[i - 1];
                    if (i != 19)
                        temp[i + 1] = !temp[i + 1];
                    temp[i] = !temp[i];
                    count++;
                }
            }
            boolean drinkable = true;
            for (int i = 0; i < 20; i++) {
                if (!temp[i])
                    drinkable = false;
            }
            if (drinkable) {
                min = Math.min(min, count);
            }
        }
        io.println(min);
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
