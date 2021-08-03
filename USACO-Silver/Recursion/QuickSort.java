import java.io.*;
import java.util.*;

public class QuickSort {
    static int arr[];
    static Kattio io;

    public static void sort(int l, int h) {
        if (l >= h)
            return;
        int pivot = arr[h];
        int high = h, low = l;
        h--;
        int temp;
        while (true) {
            while (l <= arr.length - 1 && arr[l] < pivot)
                l++;
            while (h >= 0 && arr[h] > pivot)
                h--;

            if (l >= h)
                break;

            // Swap
            temp = arr[h];
            arr[h] = arr[l];
            arr[l] = temp;

            l++;
            h--;

        }
        arr[high] = arr[l];
        arr[l] = pivot;

        printArr();
        sort(low, l - 1);
        sort(l + 1, high);
    }

    public static void printArr() {
        for (int i = 0; i < arr.length - 1; i++) {
            io.print(arr[i] + " ");
        }
        io.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) throws IOException {
        io = new Kattio();

        arr = new int[io.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = io.nextInt();
        }
        sort(0, arr.length - 1);

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