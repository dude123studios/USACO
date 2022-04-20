import java.io.*;
import java.util.*;

public class Convention {

    static class Event implements Comparable<Event> {
        int time, cow;
        boolean start;

        public Event(int time, int cow, boolean start) {
            this.time = time;
            this.cow = cow;
            this.start = start;
        }

        public int compareTo(Event o) {
            int val = Integer.compare(time, o.time);
            if (val == 0)
                return Integer.compare(cow, o.cow);
            return val;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        PriorityQueue<Event> events = new PriorityQueue<Event>();
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            int a = io.nextInt();
            int t = io.nextInt();
            ts[i] = t;
            events.add(new Event(a, i, true));
        }

        TreeMap<Integer, Integer> waitingSince = new TreeMap<Integer, Integer>();
        int cow = -1;
        int max = 0;
        for (int i = 0; i < 2 * n; i++) {
            Event e = events.poll();
            if (cow == -1) {
                // e must be a starting event
                cow = e.cow;
                events.add(new Event(e.time + ts[cow], cow, false));
                continue;
            }
            if (e.start) {
                // cow is waiting in line
                waitingSince.put(e.cow, e.time);
            } else {
                // cow finished, next cows with highest seniorities turn
                if (waitingSince.size() == 0) {
                    cow = -1;
                    continue;
                }
                int nextCow = waitingSince.firstKey();
                max = Math.max(max, e.time - waitingSince.get(nextCow));
                cow = nextCow;
                waitingSince.remove(nextCow);
                events.add(new Event(e.time + ts[cow], cow, false));
            }
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
