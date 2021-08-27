import java.io.*;
import java.util.*;

//0: water, 1: open land, 2: used land
public class Domination {
	static int[][] grid;
	static int n;
	static int area, perimeter;

	static int[] dr = { -1, 0, 0, 1 }, dc = { 0, 1, -1, 0 };

	public static void dfs(int r, int c) {
		area++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (grid[nr][nc] == 0)
				perimeter++;
			if (grid[nr][nc] != 1)
				continue;
			grid[nr][nc] = 2;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		n = io.nextInt();
		grid = new int[n + 2][n + 2];
		for (int i = 0; i < n; i++) {
			String line = io.next();
			for (int j = 0; j < n; j++) {
				grid[i + 1][j + 1] = line.charAt(j) == '#' ? 1 : 0;
			}
		}
		int max = 0;
		int perim = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i + 1][j + 1] == 1) {
					area = 0;
					perimeter = 0;
					grid[i + 1][j + 1] = 2;
					dfs(i + 1, j + 1);
					if (area == max) {
						if (perimeter < perim) {
							perim = perimeter;
						}
					} else if (area > max) {
						max = area;
						perim = perimeter;
					}
				}
			}
		}
		io.println(max + " " + perim);
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