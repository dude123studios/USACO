import java.io.*;
import java.util.*;

public class Storks {

    static char[][] map = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' }, { 'J', 'K', 'L' },
            { 'M', 'N', 'O' }, { 'P', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y' } };

    static HashSet<String> set = new HashSet<String>();
    static int[] codeArr;
    static ArrayList<Character> string = new ArrayList<Character>();

    public static void generate(int index) {
        if (index == codeArr.length) {
            StringBuilder sb = new StringBuilder();
            for (char val : string) {
                sb.append(val);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            string.add(map[codeArr[index] - 2][i]);
            generate(index + 1);
            string.remove(string.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        String code = "" + io.nextLong();

        ArrayList<String> possibilities = new ArrayList<String>();
        String next;
        while (true) {
            next = io.next();
            if (next == null)
                break;
            possibilities.add(next);
        }

        char[] codeCharArr = code.toCharArray();
        codeArr = new int[codeCharArr.length];
        for (int i = 0; i < codeArr.length; i++) {
            codeArr[i] = Character.getNumericValue(codeCharArr[i]);
        }
        codeCharArr = null;
        generate(0);
        boolean contains = false;
        for (String p : possibilities) {
            if (set.contains(p)) {
                contains = true;
                io.println(p);
            }
        }

        if (!contains)
            io.println("NONE");

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