import java.io.*;
import java.util.*;

public class Queens {
    static short[][] chessboard = new short[8][8];

    public static int search(int row) {
        if (row == 8)
            return 1;
        int val = 0;
        for (int i = 0; i < 8; i++) {
            if (chessboard[row][i] == 2 || queenOnColumn(i, row) || queenOnDiagonal(i, row))
                continue;
            chessboard[row][i] = 1;
            val += search(row + 1);
            chessboard[row][i] = 0;
        }
        return val;
    }

    public static boolean queenOnColumn(int col, int row) {
        for (int i = 0; i < col; i++) {
            if (chessboard[row][col] == 1)
                return true;
        }
        return false;
    }

    public static boolean queenOnDiagonal(int col, int row) {
        int i = 0;
        while (col - i >= 0 && row - i >= 0 && row + i >= 0) {
            if (chessboard[row - i][col - i] == 1 || chessboard[row + i][col - i] == 1)
                return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        String line;
        for (int i = 0; i < 8; i++) {
            line = io.next();

        }
        io.println(search(0));
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
