import java.io.*;
import java.util.*;

public class Bunny {

    static class Rabbit implements Comparable<Rabbit> {
        int pos;
        boolean spot;

        public Rabbit(int pos, boolean spot) {
            this.pos = pos;
            this.spot = spot;
        }

        public int compareTo(Rabbit o) {
            return Integer.compare(pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();

        Rabbit[] r = new Rabbit[n];
        for (int i = 0; i < n; i++) {
            r[i] = new Rabbit(io.nextInt(), io.next().equals("S"));
        }
        Arrays.sort(r);
        int max = 0;

        // Contigous N's
        int index = 0;
        while (index < n) {
            while (index < n && r[index].spot) {
                index++;
            }
            if (index >= n)
                break;
            int firstNS = index;
            while (index < n && !r[index].spot)
                index++;
            max = Math.max(max, r[index - 1].pos - r[firstNS].pos);
        }

        // Contigous S's
        index = 0;
        while (index < n) {
            while (index < n && !r[index].spot) {
                index++;
            }
            if (index >= n)
                break;
            int firstS = index;
            while (index < n && r[index].spot)
                index++;
            max = Math.max(max, r[index - 1].pos - r[firstS].pos);
        }

        // Prefix Diff Sum for Equal amounts of N and S

        int[] diffPS = new int[n + 1];
        int ns = 0, s = 0;
        for (int i = 0; i < n; i++) {
            if (r[i].spot)
                s++;
            else
                ns++;
            diffPS[i + 1] = s - ns;
        }

        // Check for repeat values in prefix Diff sum, means that
        // an equal amount of ns and s have been added.

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            Integer id = map.get(diffPS[i]);
            if (id == null) {
                map.put(diffPS[i], i - 1);
                continue;
            }
            max = Math.max(max, r[i - 1].pos - r[id + 1].pos);
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
