import java.io.*;
import java.util.*;

public class Cow {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        String line = io.next();
        int c = 0;
        long co = 0, cow = 0;
        for (int i = 0; i < n; i++) {
            char letter = line.charAt(i);
            if (letter == 'C') {
                c++;
            } else if (letter == 'O') {
                // add a new set of permutations invloving all the alst c's and this o
                co += c;
            } else {
                // add a new set of complete words cow using all the permutations of co and this
                // w
                cow += co;
            }
        }

        io.println(cow);
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
