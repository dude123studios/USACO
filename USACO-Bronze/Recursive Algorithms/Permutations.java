import java.io.*;
import java.util.*;

public class Permutations {

    static ArrayList<String> permutations = new ArrayList<String>();
    static int[] letters = new int[26];
    static int N;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

    }

    public static void search(String str) {
        if (str.length() == N) {
            permutations.add(str);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] == 0)
                continue;
            letters[i]--;
            search(str + (char) (i + 'a'));
            letters[i]++;
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
