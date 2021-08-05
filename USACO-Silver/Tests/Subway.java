import java.io.*;
import java.util.*;

public class Subway {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean visited[];

    public static void dfs(int n) {
        if (n == 0)
            return;

        for (int i : graph[n]) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int number = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i);
            if (!visited[0]) {
                io.println(i + 1);
                number++;
            }
        }
        if (number == 0)
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