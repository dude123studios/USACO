import java.io.*;
import java.util.*;

public class WordMorph {

    static boolean check(String s, String o) {
        boolean diff = false;
        if (s.length() != o.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != o.charAt(i)) {
                if (diff)
                    return false;
                diff = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        String a = io.next();
        String b = io.next();

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String val = io.next();
            if (val == null)
                break;
            list.add(val);
        }
        HashSet<String> visited = new HashSet<String>();

        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> times = new LinkedList<Integer>();

        queue.add(a);
        times.add(0);

        while (!queue.isEmpty()) {
            String val = queue.poll();
            int t = times.poll();

            if (val.equals(b)) {
                io.println(t);
                break;
            }

            for (String l : list) {
                if (check(val, l)) {
                    if (visited.contains(l))
                        continue;
                    queue.add(l);
                    times.add(t + 1);
                    visited.add(l);
                }
            }
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
