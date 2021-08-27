import java.io.*;
import java.util.*;

public class AwkwardDigits {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        String n2String = io.next();
        int n2 = 0;
        for (int i = n2String.length() - 1; i >= 0; i--) {
            n2 += (1 << (n2String.length() - 1 - i)) * (n2String.charAt(i) - '0');
        }
        String n3String = io.next();
        int n3 = 0;
        int[] p3 = new int[n3String.length()];
        p3[0] = 1;
        for (int i = n3String.length() - 1; i >= 0; i--) {
            n3 += p3[n3String.length() - 1 - i] * (n3String.charAt(i) - '0');
            if (i != 0)
                p3[n3String.length() - i] = 3 * p3[n3String.length() - 1 - i];
        }
        for (int i = 0; i < n2String.length(); i++) {
            for (int j = 0; j < n3String.length(); j++) {
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (n2String.charAt(i) - '0' == a || n3String.charAt(j) - '0' == b)
                            continue;
                        int newn2 = (a - (n2String.charAt(i) - '0')) * (1 << (n2String.length() - 1 - i)) + n2;
                        int newn3 = (b - (n3String.charAt(j) - '0')) * p3[n3String.length() - 1 - j] + n3;
                        if (newn2 == newn3) {
                            io.println(newn2);
                            io.close();
                            System.exit(0);
                        }
                    }
                }
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
