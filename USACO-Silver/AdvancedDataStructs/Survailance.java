import java.io.*;
import java.util.*;

public class Survailance {

    static class Point implements Comparable<Point> {
        int pos;
        int label;
        int id;

        public Point(int pos, int label, int id) {
            this.pos = pos;
            this.label = label;
            this.id = id;
        }

        public int compareTo(Point o) {
            return Integer.compare(pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        Point[] points = new Point[2 * n];
        for (int i = 0; i < n; i++) {
            points[2 * i] = new Point(io.nextInt(), 1, i);
            points[2 * i + 1] = new Point(io.nextInt(), -1, i);
        }
        Arrays.sort(points);

        // Calculate total area
        int total = 0;
        int active = 0;
        int l = 0, r = 0;
        for (int i = 0; i < 2 * n; i++) {
            int lastActive = active;
            active += points[i].label;
            if (lastActive == 0 && active > 0) {
                l = points[i].pos;
            }
            if (lastActive > 0 && active == 0) {
                r = points[i].pos;
                total += (r - l);
            }
        }

        HashMap<Integer, Integer> aloneTime = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            aloneTime.put(i, 0);
        }
        HashMap<Integer, Integer> aloneStart = new HashMap<Integer, Integer>();
        HashSet<Integer> activeSet = new HashSet<Integer>();

        for (Point p : points) {
            int prevSize = activeSet.size();
            if (p.label == -1)
                activeSet.remove(p.id);
            else
                activeSet.add(p.id);
            int newSize = activeSet.size();
            if (prevSize == 2 && newSize == 1) {
                for (int el : activeSet) {
                    // There is only 1 element
                    aloneStart.put(el, p.pos);
                }
            } else if (prevSize == 0 && newSize == 1) {
                aloneStart.put(p.id, p.pos);
            } else if (prevSize == 1 && newSize == 0) {
                aloneTime.put(p.id, p.pos - aloneStart.get(p.id));
            } else if (prevSize == 1 && newSize == 2) {
                for (int el : activeSet) {
                    if (el == p.id)
                        continue;
                    aloneTime.put(el, p.pos - aloneStart.get(el));
                }
            }

        }
        int min = Integer.MAX_VALUE;
        for (int el : aloneTime.keySet()) {
            min = Math.min(min, aloneTime.get(el));
        }
        io.println(total - min);
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
