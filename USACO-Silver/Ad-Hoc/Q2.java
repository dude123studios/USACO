import java.io.*;
import java.util.*;

public class Q2 {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, HashSet<Integer>> notAllowed = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < k; i++) {
            int a = io.nextInt() - 1, b = io.nextInt() - 1;
            if (!pq.contains(a))
                pq.add(a);
            if (!pq.contains(b))
                pq.add(b);

            if (!notAllowed.containsKey(a)) {
                notAllowed.put(a, new HashSet<Integer>());
            }
            if (!notAllowed.containsKey(b)) {
                notAllowed.put(b, new HashSet<Integer>());
            }
            notAllowed.get(a).add(b);
            notAllowed.get(b).add(a);
        }
        HashSet<Integer> window = new HashSet<Integer>();
        int num = 0;
        while (!pq.isEmpty()) {
            int next = pq.poll();
            for (int item : window) {
                if (notAllowed.get(item).contains(next)) {
                    num++;
                    window.clear();
                    break;
                }
            }
            window.add(next);
        }
        io.println(num + 1);
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
