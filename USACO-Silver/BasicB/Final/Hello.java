import java.io.*;
import java.util.*;

public class Hello {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt(), m = io.nextInt();
        int[] move1 = new int[n];
        int[] move2 = new int[m];
        int cow1 = 0;
        int time1 = 0;
        for (int i = 0; i < n; i++) {
            int x = io.nextInt();
            cow1 += io.next().equals("R") ? x : -x;
            time1 += x;
            move1[i] = cow1;
        }
        int time2 = 0;
        int cow2 = 0;
        for (int i = 0; i < m; i++) {
            int x = io.nextInt();
            time2 += x;
            cow2 += io.next().equals("R") ? x : -x;
            move2[i] = cow2;
        }
        int time = Math.max(time1, time2);
        cow1 = 0;
        cow2 = 0;
        int cow1Dir = move1[0] > 0 ? 1 : -1, cow2Dir = move2[0] > 0 ? 1 : -1;
        int cow1Next = move1[0], cow2Next = move2[0];
        int cow1Index = 1, cow2Index = 1;
        int ans = 0;
        for (int i = 0; i < 1000000; i++) {
            if (i < time1)
                cow1 += cow1Dir;
            if (i < time2)
                cow2 += cow2Dir;
            if (cow1 == cow2) {
                if (!(cow1 - cow1Dir == cow2 - cow2Dir)) {
                    ans++;
                }
            }
            if (cow1Next == cow1) {
                if (!(cow1Index == n)) {
                    cow1Dir = move1[cow1Index] - move1[cow1Index - 1] > 0 ? 1 : -1;
                    cow1Next = move1[cow1Index];
                    cow1Index++;
                }
            }
            if (cow2Next == cow2) {
                if (!(cow2Index == m)) {
                    cow2Dir = move2[cow2Index] - move2[cow2Index - 1] > 0 ? 1 : -1;
                    cow2Next = move2[cow2Index];
                    cow2Index++;
                }
            }
            if (i == time - 1) {
                break;
            }
        }
        io.println(ans);
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