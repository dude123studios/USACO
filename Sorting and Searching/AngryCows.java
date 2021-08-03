import java.io.*;
import java.util.*;

public class AngryCows {

    public void explode(int pos, int t) {
        bales[t]
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("angry");
        int N = io.nextInt();
        int bales[] = new int[N];
        for(int i =0; i< N; i++) {
            bales[i] = io.nextInt();
        }
        Arrays.sort(bales);
        for(int i =0; i < bales.length; i++) {
            for(int t = 0; t < bales.length; t++) {
                if(bales[i + t])
            }
        }
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
