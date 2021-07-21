import java.io.*;
import java.util.*;

public class LifeGaurds {

    public static void main(String[] args) throws IOException {
        String ProjectName = "";
        Scanner sc = new Scanner(new File(ProjectName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ProjectName + ".out")));

        int n = sc.nextInt();

        HashSet<Integer>[] time = new HashSet[1000];

        int start, end, i, j;
        for (i = 0; i < n; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            for (j = start; j <= end; j++) {
                time[j].add(i);
            }
        }
        int max = 0;
        int count;
        HashSet temp;
        for (i = 0; i < n; i++) {
            count = 0;
            for (j = 0; j < time.length; j++) {
                temp = (HashSet) (time[i].clone());
                temp.remove(i);
                if (temp.isEmpty())
                    count++;
            }
            max = Math.max(count, max);
        }
        pw.println(max);
    }
}
