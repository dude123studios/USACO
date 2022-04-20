import java.io.*;
import java.util.*;

public class LazerTag {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int w = io.nextInt(), h = io.nextInt();

        int[][] arr = new int[h + 2][w + 2];
        int startr = -1, startc = -1, endr = -1, endc = -1;
        for (int i = 0; i < h; i++) {
            String line = io.next();
            for (int j = 0; j < w; j++) {
                char c = line.charAt(j);
                if (c == '.')
                    arr[i + 1][j + 1] = -1;
                else if (c == '*')
                    arr[i + 1][j + 1] = -2;
                else {
                    if (startr == -1) {
                        startr = i;
                        startc = j;
                        arr[startr + 1][startc + 1] = -1;
                    } else {
                        endr = i;
                        endc = j;
                        arr[endr + 1][endc + 1] = -1;
                    }
                }
            }
        }

        Queue<Integer> posr = new LinkedList<Integer>();
        Queue<Integer> posc = new LinkedList<Integer>();

        posr.add(startr);
        posc.add(startc);

        int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
        while (!posr.isEmpty()) {
            int r = posr.poll();
            int c = posc.poll();
            int val = arr[r + 1][c + 1];

            if (r == endr && c == endc) {
                io.println(arr[r + 1][c + 1]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;
                while (arr[nr + 1][nc + 1] == -1) {
                    posr.add(nr);
                    posc.add(nc);
                    arr[nr + 1][nc + 1] = val + 1;
                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }
        // System.err.println();
        // for (int i = 0; i < h; i++) {
        // for (int j = 0; j < w; j++) {
        // System.out.print(arr[i + 1][j + 1] + " ");
        // }
        // System.out.println();
        // }

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
