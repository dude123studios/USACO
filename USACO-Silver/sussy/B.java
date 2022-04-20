import java.io.*;
import java.util.*;

public class B {
    static class Event implements Comparable<Event> {
        int pos;
        boolean i;

        public Event(int pos, boolean i) {
            this.pos = pos;
            this.i = i;
        }

        public int compareTo(Event o) {
            return Integer.compare(pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("socdist2");

        int n = io.nextInt();
        Event[] c = new Event[n];
        for (int i = 0; i < n; i++) {
            c[i] = new Event(io.nextInt(), io.nextInt() == 1);
        }
        Arrays.sort(c);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if ((c[i].i && !c[i - 1].i) || (!c[i].i && c[i - 1].i)) {
                min = Math.min(min, c[i].pos - c[i - 1].pos);
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if ((c[i - 1].i && !c[i].i) || c[i - 1].i && c[i].i && c[i].pos - c[i - 1].pos >= min) {
                ans++;
            }
        }
        if (c[n - 1].i)
            ans++;

        io.println(ans);
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
