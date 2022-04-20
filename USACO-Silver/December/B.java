import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        boolean[] arr = new boolean[n];
        String line = io.next();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i) == 'G';
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] != arr[i] && arr[i + 1] != arr[i]) {
                int a = 1, b = 1;
                for (int j = 2; j < n - i; j++) {
                    if (arr[i + j] != arr[i])
                        a++;
                    else {
                        break;
                    }
                }
                for (int j = 2; j < i + 1; j++) {
                    if (arr[i - j] != arr[i])
                        b++;
                    else {
                        break;
                    }
                }
                ans += a * b;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] != arr[i + 1]) {
                for (int j = i + 2; j < n; j++) {
                    if (arr[j] == arr[i])
                        break;
                    ans++;
                }
            }
        }
        for (int i = n - 1; i > 1; i--) {
            if (arr[i] != arr[i - 1]) {
                for (int j = i - 2; j >= 0; j--) {
                    if (arr[j] == arr[i])
                        break;
                    ans++;
                }
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
