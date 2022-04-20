import java.io.*;
import java.util.*;

public class PaintJob {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int a = io.nextInt(), b = io.nextInt();
        int n = io.nextInt(), p = io.nextInt();

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = io.nextInt();
        }

        Queue<Integer> vals = new LinkedList<Integer>();
        Queue<Integer> mixes = new LinkedList<Integer>();

        vals.add(a);
        mixes.add(0);

        boolean[] v = new boolean[p + 1];
        boolean found = false;
        while (!vals.isEmpty()) {
            int val = vals.poll();
            int mix = mixes.poll();

            if (val == b) {
                io.println(mix);
                found = true;
                break;
            }

            for (int color : colors) {
                int newVal = (color * val) % p;
                if (!v[newVal]) {
                    vals.add(newVal);
                    mixes.add(mix + 1);
                    v[newVal] = true;
                }
            }
        }
        if (!found)
            System.out.println(-1);
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
