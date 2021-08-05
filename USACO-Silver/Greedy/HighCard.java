import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class HighCard {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] elsie = new int[n];
        int[] bessie = new int[n];
        boolean[] owned = new boolean[2 * n];
        for (int i = 0; i < n; i++) {
            elsie[i] = io.nextInt();
            owned[elsie[i] - 1] = true;
        }
        int j = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (!owned[i]) {
                bessie[j] = i + 1;
                j++;
            }
        }
        Arrays.sort(elsie);
        Arrays.sort(bessie);

        int pts = 0;
        int bessieIndex = 0;
        int elsieIndex = 0;
        while (bessieIndex < n && elsieIndex < n) {
            if (bessie[bessieIndex] > elsie[elsieIndex]) {
                pts++;
                bessieIndex++;
                elsieIndex++;
            } else {
                bessieIndex++;
            }
        }
        io.println(pts);
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