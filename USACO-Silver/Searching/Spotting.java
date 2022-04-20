import java.io.*;
import java.util.*;

public class Spotting {

    static class Rabbit implements Comparable<Rabbit> {
        int pos;
        boolean spotted;

        public Rabbit(int pos, boolean spotted) {
            this.pos = pos;
            this.spotted = spotted;
        }

        public int compareTo(Rabbit o) {
            return Integer.compare(pos, o.pos);
        }

        public int rabbitsBetween(Rabbit o) {
            if (o.spotted && spotted) {
                return o.pos - pos;
            } else if (!o.spotted && !spotted) {
                return 0;
            } else if (!o.spotted && spotted) {
                return (o.pos - pos) / 2;
            } else {
                return (o.pos - pos) / 2 - 1;
            }

        }

        public int rabbitsAfter(Rabbit o, int after) {
            if (after >= (o.pos + pos + 1) / 2) {
                return o.spotted ? o.pos - after : 0;
            }
            int total = 0;
            if (spotted) {
                total += (o.pos + pos + 1) / 2 - after;
            }
            if (o.spotted) {
                total += o.pos - (o.pos + pos + 1) / 2;
            }
            return total;
        }

        public int rabbitsBefore(Rabbit o, int before) {
            if (before < (o.pos + pos + 1) / 2) {
                return o.spotted ? before - pos + 1 : 0;
            }
            int total = 0;
            if (spotted) {
                total += (o.pos + pos + 1) / 2 + 1;
            }
            if (o.spotted) {
                total += before - (o.pos + pos + 1) / 2;
            }
            return total;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt(), a = io.nextInt(), b = io.nextInt();
        Rabbit[] rabbits = new Rabbit[n];

        for (int i = 0; i < n; i++) {
            boolean spotted = io.next().equals("S");
            rabbits[i] = new Rabbit(io.nextInt(), spotted);
        }

        Arrays.sort(rabbits);

        int total = 0;
        int r = 0;
        while (r < n && rabbits[r].pos < a) {
            r++;
        }
        if (r == n) {
            io.println(rabbits[r - 1].spotted ? a - b + 1 : 0);
            io.close();
            System.exit(0);
        }
        if (r == 0) {
            total += rabbits[0].spotted ? rabbits[0].pos - a : 0;
        } else {
            total += rabbits[r - 1].rabbitsAfter(rabbits[r], a);
        }
        while (r < n - 1 && rabbits[r].pos <= b) {
            total += rabbits[r].rabbitsBetween(rabbits[r + 1]);
            r++;
        }
        if (r == n - 1) {
            total += rabbits[r].spotted ? b - rabbits[r].pos + 1 : 0;
        } else {
            total += rabbits[r].rabbitsBefore(rabbits[r + 1], b);
        }
        io.println(total);
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
