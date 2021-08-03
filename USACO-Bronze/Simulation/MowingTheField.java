import java.io.*;
import java.util.*;

public class MowingTheField {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("mowing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));

        int n = sc.nextInt();
        int t = 0;
        int[][] field = new int[500][500];
        int x = 250, y = 250, deltax = 0, deltay = 0;
        String direction;
        int length;
        int i, j;
        int min = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            direction = sc.next();
            length = sc.nextInt();
            if (direction.equals("N")) {
                deltay = 1;
                deltax = 0;
            } else if (direction.equals("S")) {
                deltay = -1;
                deltax = 0;
            } else if (direction.equals("W")) {
                deltax = -1;
                deltay = 0;
            } else {
                deltax = 1;
                deltay = 0;
            }
            for (j = 0; j < length; j++) {
                t++;
                x += deltax;
                y += deltay;
                if (field[x][y] != 0) {
                    min = Math.min(min, t - field[x][y]);
                }
                System.out.println(x + ", " + y + ", " + t);
                field[x][y] = t;
            }

        }
        if (min != Integer.MAX_VALUE)
            pw.println(min);
        else {
            pw.println(-1);
        }
        pw.close();
    }
}
