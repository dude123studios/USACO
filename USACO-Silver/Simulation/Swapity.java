import java.io.*;
import java.util.*;

public class Swapity {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");
        int n = io.nextInt(), m = io.nextInt(), k = io.nextInt();
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int l = io.nextInt() - 1, r = io.nextInt() - 1;
            for (int j = 0; j < (l + r) / 2; j++) {
                int temp = map[j];
                map[l + j] = map[r - j];
                map[r - j] = temp;
            }
        }

        ArrayList<Integer> cycle;
        int[] ans = new int[n];
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            System.out.println(i);
            int curr = map[i];
            cycle = new ArrayList<Integer>();
            while (curr != i) {
                visited[curr] = true;
                cycle.add(curr);
                curr = map[curr];
            }
            for (int j = 0; j < cycle.size(); j++) {
                ans[cycle.get((j + k % cycle.size()) % cycle.size())] = cycle.get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            io.println(ans[i]);
            System.out.println(ans[i]);
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
