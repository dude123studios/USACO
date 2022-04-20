import java.io.*;
import java.util.*;

public class Mootel {

    static class Node implements Comparable<Node> {
        int t, id;

        public Node(int t, int id) {
            this.t = t;
            this.id = id;
        }

        public int compareTo(Node o) {
            int val = Integer.compare(t, o.t);
            if (val == 0)
                return Integer.compare(id, o.id);
            return val;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), m = io.nextInt() - 1;

        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (io.nextInt() == 1)
                    adj[i].add(j);
            }
        }

        PriorityQueue<Node> rooms = new PriorityQueue<Node>();

        rooms.add(new Node(0, m));

        int lastTime = 0;
        boolean[] v = new boolean[n];
        v[m] = true;
        while (!rooms.isEmpty()) {
            Node node = rooms.poll();
            int time = node.t;
            int room = node.id;
            if (time != lastTime)
                io.println();
            io.print((room + 1) + " ");
            for (int neighbor : adj[room]) {
                if (!v[neighbor]) {
                    rooms.add(new Node(time + 1, neighbor));
                    v[neighbor] = true;
                }
            }
            lastTime = time;
        }

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
