import java.io.*;
import java.util.*;

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Walk {
    static ArrayList<Pair>[] graph;
    static boolean[] visited;
    static int N, Q;
    static int ans;

    public static void search(int node, int dist, int g) {
        if (node == g) {
            ans = dist;
            return;
        }
        for (Pair i : graph[node]) {
            if (visited[i.first])
                continue;
            visited[i.first] = true;
            search(i.first, dist + i.second, g);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        N = io.nextInt();
        Q = io.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            int l = io.nextInt();
            graph[a].add(new Pair(b, l));
            graph[b].add(new Pair(a, l));
        }
        for (int i = 0; i < Q; i++) {
            visited = new boolean[N];
            int start = io.nextInt();
            visited[start - 1] = true;
            search(start - 1, 0, io.nextInt() - 1);
            io.println(ans);
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