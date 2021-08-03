import java.io.*;
import java.util.*;

class Measurement implements Comparable<Measurement> {
    int day, change;
    String cow;

    public Measurement(int day, String cow, int change) {
        this.day = day;
        this.change = change;
        this.cow = cow;
    }

    public int compareTo(Measurement m) {
        if (m.day == day)
            return 0;
        if (m.day > day)
            return -1;
        return 1;
    }

    public String toString() {
        return day + ", " + change + ", " + cow;
    }
}

public class MilkMeasurements {

    static int b, brate = 7, e, erate = 7, m, mrate = 7;
    static int max;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));

        int n = sc.nextInt();
        Measurement[] measurements = new Measurement[n];
        int i;
        for (i = 0; i < n; i++) {
            measurements[i] = new Measurement(sc.nextInt(), sc.next(), sc.nextInt());
        }
        Arrays.sort(measurements);
        for (i = 0; i < n; i++) {
            System.out.println(measurements[i]);
        }
        String name;
        int changes = 0;
        for (i = 0; i < n; i++) {
            name = measurements[i].cow;
            if (name.equals("Bessie")) {
                brate += measurements[i].change;
                b += brate;
            }

            else if (name.equals("Elsie")) {
                erate += measurements[i].change;
                e += erate;
            } else {
                mrate += measurements[i].change;
                m += mrate;
            }
            if (wasChange()) {
                changes++;
            }
        }
        pw.println(changes);
        pw.close();
    }

    public static boolean wasChange() {
        int newMax = Math.max(brate, Math.max(erate, mrate));
        return newMax != max;
    }
}
