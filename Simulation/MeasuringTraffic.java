import java.io.*;
import java.util.*;

public class MeasuringTraffic {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("traffic.in"));
        int n = sc.nextInt();
        int deltamin = 0, deltamax = 0;
        ArrayList<Integer> mins = new ArrayList<Integer>();
        ArrayList<Integer> maxs = new ArrayList<Integer>();
        int i;
        String change;
        boolean wasNone = false;
        for (i = 0; i < n; i++) {
            change = sc.next();
            if (change != "none" && wasNone)
                break;
            if (change == "none") {
                wasNone = true;
                mins.add(sc.nextInt());
                maxs.add(sc.nextInt());
            } else if (change == "on") {
                deltamin -= sc.nextInt();
                deltamax -= sc.nextInt();
            } else if (change == "off") {
                deltamin += sc.nextInt();
                deltamax += sc.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (i = 0; i < mins.size(); i++) {
            min = Math.min(min, mins.get(i));
            max = Math.max(max, maxs.get(i));
        }
        min += deltamin;
        max += deltamax;
        PrintWriter pw = new PrintWriter(new FileWriter("traffic.out"));
        pw.println(min + " " + max);

        mins = new ArrayList<Integer>();
        maxs = new ArrayList<Integer>();

        wasNone = false;
        for (i = i; i < n; i++) {
            change = sc.next();
            if (change != "none" && wasNone)
                break;
            if (change == "none") {
                wasNone = true;
                mins.add(sc.nextInt());
                maxs.add(sc.nextInt());
            } else if (change == "on") {
                deltamin -= sc.nextInt();
                deltamax -= sc.nextInt();
            } else if (change == "off") {
                deltamin += sc.nextInt();
                deltamax += sc.nextInt();
            }
        }
    }
}
