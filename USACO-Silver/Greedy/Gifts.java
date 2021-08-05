import java.io.*;
import java.util.*;

class Gift implements Comparable<Gift> {
    int p, s;

    public Gift(int p, int s) {
        this.p = p;
        this.s = s;
    }

    public int compareTo(Gift g) {
        int num = g.p + g.s;
        if (num == p + s)
            return 0;
        if (num > p + s)
            return -1;
        return 1;
    }
}

public class Gifts {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int b = io.nextInt();
        Gift[] gifts = new Gift[n];
        for (int i = 0; i < n; i++) {
            gifts[i] = new Gift(io.nextInt(), io.nextInt());
        }
        Arrays.sort(gifts);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = 0;
            int count = 1;
            int sum = gifts[i].p / 2 + gifts[i].s;
            while (index < n && sum < b) {
                if (index == i) {
                    index++;
                    continue;
                }
                sum += (gifts[index].p + gifts[index].s);
                index++;
                count++;
            }
            count--;
            if (sum < b) {
                max = n;
                break;
            }
            max = Math.max(max, count);
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
