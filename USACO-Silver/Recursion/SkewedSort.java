import java.io.*;
import java.util.*;

public class SkewedSort {

    static int arr[];
    static Kattio io;
    static int sum = 0;

    public static void sort(int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;

        sort(low, mid);
        sort(mid + 1, high);

        for (int i = low; i <= mid; i++) {
            if (arr[i] > arr[i - low + mid + 1]) {
                swap(low, mid);
                return;
            } else if (arr[i] < arr[i - low + mid + 1])
                return;

        }
    }

    public static void swap(int low, int mid) {
        int temp;
        for (int i = low; i <= mid; i++) {
            // System.out.println(arr[i] + 1 + ", " + (arr[i - low + mid + 1] + 1));
            temp = arr[i];
            arr[i] = arr[i - low + mid + 1];
            arr[i - low + mid + 1] = temp;
            sum += (-low + mid + 1) * 2;
        }
    }

    public static void main(String[] args) throws IOException {
        io = new Kattio();
        arr = new int[(int) Math.pow(2, io.nextInt())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = io.nextInt();
        }
        sort(0, arr.length - 1);

        io.println(sum);
        for (int i = 0; i < arr.length; i++) {
            io.println(arr[i]);
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
