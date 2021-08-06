import java.io.*;
import java.util.*;

class Bale implements Comparable<Bale> {
    int width, height;

    public Bale(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int compareTo(Bale other) {
        if (other.width == width)
            return 0;
        return other.width > width ? 1 : -1;
    }
}

public class BaleTower {
    static int bales;
    static Bale[] sizes;

    public static int length(int mask) {
        int prev = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < bales; i++) {
            if ((mask & (1 << i)) > 0) {
                if (sizes[i].height > prev)
                    return 0;
                num++;
                prev = sizes[i].height;
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        bales = io.nextInt();
        sizes = new Bale[bales];

        for (int i = 0; i < bales; i++) {
            sizes[i] = new Bale(io.nextInt(), io.nextInt());
        }
        Arrays.sort(sizes);
        int max = 0;
        for (int mask = 0; mask < (1 << bales); mask++) {
            max = Math.max(max, length(mask));
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
