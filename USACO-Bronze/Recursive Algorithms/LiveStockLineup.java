import java.io.*;
import java.util.*;

//Slowest Running Time: 327ms
/*
    Store an array of cows in lexographic order, such that a DFS will be run and the first solution will be the best one.
*/

class Pair {
    String first, second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

public class LiveStockLineup {
    static String cows[], order[];
    static boolean cowUsed[];
    static Pair pairs[];
    static int N;
    static Kattio io;

    public static void search(int loc) {
        if (loc == 8) {
            if (checkPermutation()) {
                for (int i = 0; i < 8; i++) {
                    io.println(order[i]);
                }
                io.close();
                System.exit(0);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (!cowUsed[i]) {
                cowUsed[i] = true;
                order[loc] = cows[i];
                search(loc + 1);
                cowUsed[i] = false;
            }
        }
    }

    static boolean checkPermutation() {
        for (int i = 0; i < N; i++) {
            if (!isNextTo(pairs[i].first, pairs[i].second))
                return false;
        }
        return true;
    }

    static boolean isNextTo(String cow1, String cow2) {
        for (int i = 0; i < 8; i++) {
            if (order[i].equals(cow1)) {
                if (i != 0 && order[i - 1].equals(cow2))
                    return true;
                else if (i != 7 && order[i + 1].equals(cow2))
                    return true;
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        io = new Kattio("lineup");
        cows = new String[] { "Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue" };
        cowUsed = new boolean[8];
        N = io.nextInt();
        pairs = new Pair[N];
        String first;
        for (int i = 0; i < N; i++) {
            first = io.next();
            io.next();
            io.next();
            io.next();
            io.next();
            pairs[i] = new Pair(first, io.next());
        }
        order = new String[8];
        search(0);
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
