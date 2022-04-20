import java.io.*;
import java.util.*;

public class StickGame {

    static void win(Kattio io) {
        io.println(1);
        io.close();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = io.nextInt();
            y[i] = io.nextInt();
        }

        // 3 parallel
        HashSet<Integer> setx = new HashSet<Integer>();
        HashSet<Integer> sety = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            setx.add(x[i]);
            sety.add(y[i]);
        }
        if (setx.size() <= 3)
            win(io);
        else if (sety.size() <= 3)
            win(io);
        HashMap<Integer, Integer> x2y = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> y2x = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            Integer ys = x2y.get(x[i]);
            if (ys == null) {
                x2y.put(x[i], 1);
            } else {
                x2y.put(x[i], ys + 1);
            }
            Integer xs = y2x.get(y[i]);
            if (xs == null) {
                y2x.put(y[i], 1);
            } else {
                y2x.put(y[i], xs + 1);
            }
        }

        int max = 0;
        int maxx = -1;
        for (int el : x2y.keySet()) {
            if (x2y.get(el) > max) {
                maxx = el;
                max = x2y.get(el);
            }

        }
        HashSet<Integer> county = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (x[i] != maxx) {
                county.add(y[i]);
            }
        }
        if (county.size() <= 2)
            win(io);

        max = 0;
        int maxy = -1;
        for (int el : y2x.keySet()) {
            if (y2x.get(el) > max) {
                maxy = el;
                max = y2x.get(el);
            }

        }
        HashSet<Integer> countx = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (y[i] != maxy) {
                countx.add(x[i]);
            }
        }
        if (countx.size() <= 2)
            win(io);

        io.println(0);
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
