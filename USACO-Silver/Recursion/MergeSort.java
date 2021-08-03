import java.io.*;
import java.util.*;

public class MergeSort {
    static int arr[];
    static Kattio io;

    public static void sort(int low, int high) {
        if (low == high)
            return;

        int mid = (low + high) / 2;

        sort(low, mid);
        sort(mid + 1, high);

        int pt1 = low, pt2 = mid + 1;
        int temp[] = new int[high - low + 1];
        int i = 0;
        while (pt1 <= mid && pt2 <= high) {
            if (arr[pt1] <= arr[pt2]) {
                temp[i] = arr[pt1];
                pt1++;
            } else {
                temp[i] = arr[pt2];
                pt2++;
            }
            i++;
        }
        while (pt1 <= mid) {
            temp[i] = arr[pt1];
            pt1++;
            i++;
        }
        while (pt2 <= high) {
            temp[i] = arr[pt2];
            pt2++;
            i++;
        }
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
        printArr();
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
