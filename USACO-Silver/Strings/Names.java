import java.io.*;
import java.util.*;

public class Names {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = io.next();
        }
        String[] worstNames = new String[n];
        String[] bestNames = new String[n];
        for (int i = 0; i < n; i++) {
            char[] arr = names[i].toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            bestNames[i] = sorted;
            worstNames[i] = new StringBuilder(sorted).reverse().toString();
        }
        names = null;
        String[] worstNamesSort = worstNames.clone();
        String[] bestNamesSort = bestNames.clone();
        Arrays.sort(worstNamesSort);
        Arrays.sort(bestNamesSort);
        HashMap<String, Integer> bestMap = new HashMap<String, Integer>();
        HashMap<String, Integer> worstMap = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            worstMap.put(worstNamesSort[i], i);
            bestMap.put(bestNamesSort[i], i);
        }

        for (int i = 0; i < n; i++) {
            String worstTarget = worstNames[i];
            String bestTarget = bestNames[i];

            int high = n - 1;
            int low = 0;
            while (low < high) {
                int mid = (low + high) / 2;
                if (bestNamesSort[mid].compareTo(worstTarget) >= 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (bestMap.get(bestTarget) < high)
                high--;
            int highest = high;

            high = n - 1;
            low = 0;
            while (low < high) {
                int mid = (low + high) / 2;
                if (worstNamesSort[mid].compareTo(bestTarget) >= 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (worstMap.get(worstTarget) < high)
                high--;
            int lowest = high;

            io.println((lowest + 1) + " " + (highest + 1));
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
