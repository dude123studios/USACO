import java.io.*;
import java.util.*;

public class CowJam {
    static class Cow implements Comparable<Cow> {
        int pos, speed;

        public Cow(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public int compareTo(Cow o) {
            return -1 * Integer.compare(pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            cows[i] = new Cow(io.nextInt(), io.nextInt());
        }
        Arrays.sort(cows);

        int groups = 0;
        int lastMin = cows[0].speed;
        for (int i = 0; i < n; i++) {
            if (cows[i].speed <= lastMin) {
                groups++;
                lastMin = cows[i].speed;
            }
        }
        io.println(groups);
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
