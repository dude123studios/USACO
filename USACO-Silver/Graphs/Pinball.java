import java.io.*;
import java.util.*;

class TreeNode {
    TreeNode left, right;
    int val;
    int maxval;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Pinball {

    public static int dfs(TreeNode node) {
        if (node.left == null || node.right == null) {
            return node.val;
        }
        if (node.maxval == 0) {
            node.maxval = node.val + Math.max(dfs(node.left), dfs(node.right));
        }
        return node.maxval;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int r = io.nextInt();
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(io.nextInt());
        prev.add(root);
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < i + 1; j++) {
                curr.add(new TreeNode(io.nextInt()));
            }
            for (int j = 0; j < prev.size(); j++) {
                prev.get(j).left = curr.get(j);
                prev.get(j).right = curr.get(j + 1);
            }
            prev = curr;
            curr = new ArrayList<TreeNode>();
        }
        int max = dfs(root);
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
