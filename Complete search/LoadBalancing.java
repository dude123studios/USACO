import java.io.*;
import java.util.*;

public class LoadBalancing {

    static int[] x, y;

    public static int maxPartition(int a, int b) {
        int i, j;
        int p = 0, q = 0, r = 0, s = 0;
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < y.length; j++) {
                if (a < x[i] && b < y[j])
                    p++;
                else if (a > x[i] && b < y[j])
                    q++;
                else if (a > x[i] && b > y[j])
                    r++;
                else
                    s++;
            }
        }
        return Math.max(p, Math.max(q, Math.max(r, s)));
    }

    public static void main(String[] args) throws IOException {
        String ProjectName = "balancing";
        Scanner sc = new Scanner(new File(ProjectName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ProjectName + ".out")));

        int n = sc.nextInt();

        x = new int[n];
        y = new int[n];
        int xMin = Integer.MAX_VALUE;
        int xMax = 0;
        int yMin = Integer.MAX_VALUE;
        int yMax = 0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            xMin = Math.min(x[i], xMin);
            xMax = Math.max(x[i], xMax);
            y[i] = sc.nextInt();
            yMin = Math.min(y[i], yMin);
            yMax = Math.max(y[i], yMax);
        }
        int a, b;
        int min = Integer.MAX_VALUE;
        for (a = xMin + 1; a < xMax; a += 2) {
            for (b = yMin + 1; b < yMax; b += 2) {
                min = Math.min(min, maxPartition(a, b));
            }
        }

        pw.println(min);
        pw.close();

    }
}