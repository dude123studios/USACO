import java.io.*;
import java.util.*;

public class Asteroids {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[][] v = new boolean[n + 2][n + 2];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '*')
                    v[i + 1][j + 1] = true;
            }
        }

        Queue<Integer> posr = new LinkedList<Integer>();
        Queue<Integer> posc = new LinkedList<Integer>();

        int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i + 1][j + 1]) {
                    num++;
                    posr.add(i);
                    posc.add(j);
                    v[i + 1][j + 1] = false;

                    while (!posr.isEmpty()) {
                        int r = posr.poll();
                        int c = posc.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (v[nr + 1][nc + 1]) {
                                posr.add(nr);
                                posc.add(nc);
                                v[nr + 1][nc + 1] = false;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(num);
    }
}
