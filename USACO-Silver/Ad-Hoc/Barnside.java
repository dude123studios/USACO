import java.io.*;
import java.util.*;

public class Barnside {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = io.nextInt();
        }
        int[] c = new int[n];
        Stack<Integer> blocks = new Stack<Integer>();
        blocks.add(n - 1);
        long sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (!blocks.isEmpty()) {
                int next = blocks.peek();
                if (h[i] <= h[next])
                    break;
                else {
                    c[i] += c[next] + 1;
                    blocks.pop();
                }
            }
            blocks.add(i);
            sum += c[i];
        }

        io.print(sum);
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
