import java.io.*;
import java.util.*;

class Event implements Comparable<Event> {
    int t;
    boolean start;

    public Event(int t, boolean start) {
        this.t = t;
        this.start = start;
    }

    public int compareTo(Event e) {
        if (e.t == t && e.start == start)
            return 0;
        if (e.t > t)
            return -1;
        if (e.t == t && !e.start)
            return -1;
        return 1;
    }
}

public class Goldilock {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt(), x = io.nextInt(), y = io.nextInt(), z = io.nextInt();
        Event[] events = new Event[2 * n];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new Event(io.nextInt(), true);
            events[2 * i + 1] = new Event(io.nextInt(), false);
        }
        Arrays.sort(events);
        int max = 0;
        int count = x * n;
        for (int i = 0; i < n * 2; i++) {
            if (events[i].start) {
                count += (y - x);
            } else {
                count += (z - y);
            }
            max = Math.max(max, count);
        }
        io.println(max);
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
