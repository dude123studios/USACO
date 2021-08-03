import java.io.*;
import java.util.*;

//DONT ACTUALLY PERFORM SWAPS, JUST REMEMBER WHERE WE VISIT AND DONT GO THERE AGAIN. COUNT LENGTH OF CYCLE BY JUST LOOPING THROUGH AND MOVING THERE

public class Reorder {
    static int[] d, b, a;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        a = new int[n];
        b = new int[n];
        d = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt() - 1;
        }
        for (int i = 0; i < n; i++) {
            int cow = io.nextInt() - 1;
            d[cow] = i;
            b[i] = cow;
        }

        int cycles = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i] || a[i] == b[i])
                continue;
            visited[i] = true;
            int curr = d[a[i]]; // location we need to go
            int cnt = 1; // length of cycle
            while (curr != i) {
                cnt++;
                visited[curr] = true; // set visited to true
                curr = d[a[curr]]; // location we need to go
            }
            ans = Math.max(ans, cnt);
            cycles++;
        }
        io.println(cycles + " " + ans);
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