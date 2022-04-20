import java.io.*;
import java.util.*;

public class Carrots {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
        }

        Arrays.sort(a);

        int l = 0, r = 0;
        int best = 1;
        int[] leftbest = new int[n];
        while (r < n && l < n) {
            // Move right pointer until window doesn't work
            while (r < n && a[r] - a[l] <= k) {
                best = Math.max(best, r - l + 1);
                leftbest[r] = best;
                r++;
            }
            // We might have overshot r by one:
            if (r >= n)
                break;
            // Move left pointer and remove old values until window works
            while (l < n && a[r] - a[l] > k) {
                l++;
            }
        }

        l = n - 1;
        r = n - 1;
        best = 1;
        int[] rightbest = new int[n];
        while (r >= 0 && l >= 0) {
            // Move left pointer until window doesn't work
            while (l >= 0 && a[r] - a[l] <= k) {
                best = Math.max(best, r - l + 1);
                rightbest[l] = best;
                l--;
            }
            // We might have overshot l by one:
            if (l < 0)
                break;
            // Move right pointer and remove old values until window works
            while (r >= 0 && a[r] - a[l] > k) {
                r--;
            }
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, leftbest[i] + rightbest[i + 1]);
        }

        io.println(max);
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
