import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Farm {

    static class Event implements Comparable<Event> {
        int time, id, prod;

        public Event(int time, int id, int prod) {
            this.time = time;
            this.id = id;
            this.prod = prod;
        }

        public int compareTo(Event o) {
            return Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        io.nextLong(); // remove a

        Event[] events = new Event[n];
        for (int i = 0; i < n; i++) {
            events[i] = new Event(io.nextInt(), io.nextInt(), io.nextInt());
        }
        Arrays.sort(events);

        HashMap<Integer, Integer> id2prod = new HashMap<Integer, Integer>();
        TreeMap<Integer, Integer> prod2count = new TreeMap<Integer, Integer>(); // must be sorted

        for (int i = 0; i < n; i++) {
            Event e = events[i];
            id2prod.put(e.id, 0);
        }
        prod2count.put(0, id2prod.size());

        int changes = 0;
        for (int i = 0; i < n; i++) {
            Event e = events[i];
            int oldMax = prod2count.lastKey();
            int oldVal = id2prod.get(e.id);
            int newVal = oldVal + e.prod;
            id2prod.put(e.id, newVal);

            // remove old value
            int newCount = prod2count.get(oldVal) - 1;
            if (newCount == 0)
                prod2count.remove(oldVal);
            else
                prod2count.put(oldVal, newCount);

            // increment new value
            Integer count = prod2count.get(newVal);
            if (count == null)
                prod2count.put(newVal, 1);
            else
                prod2count.put(newVal, count + 1);

            int newMax = prod2count.lastKey();
            if ((newMax == newVal && oldMax != oldVal) || (oldMax == oldVal && newMax != newVal)) {
                changes++;
            }

        }

        io.println(changes + 1);
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