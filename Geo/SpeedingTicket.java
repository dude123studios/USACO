import java.io.*;
import java.util.*;

//o(n^2)

public class SpeedingTicket {
    static int[] seg, speed, besseg, besspeed;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("speeding.in"));
        int n = sc.nextInt(), m = sc.nextInt();
        seg = new int[n + 1];
        speed = new int[n];
        besseg = new int[m + 1];
        besspeed = new int[m];
        int i, j;
        int total = 0;
        for (i = 0; i < n; i++) {
            seg[i] = total;
            total += sc.nextInt();
            speed[i] = sc.nextInt();
        }
        seg[n] = 100;
        total = 0;
        for (i = 0; i < m; i++) {
            besseg[i] = total;
            total += sc.nextInt();
            besspeed[i] = sc.nextInt();
        }
        besseg[m] = 100;
        int max = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (intersection(i, j)) {
                    max = Math.max(max, besspeed[i] - speed[j]);
                    System.out.println(i + ", " + j);
                }
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
        pw.println(max);
        pw.close();
    }

    public static boolean intersection(int i, int j) {
        return (Math.min(besseg[i + 1], seg[j + 1]) - Math.max(besseg[i], seg[j])) > 0;
    }
}
