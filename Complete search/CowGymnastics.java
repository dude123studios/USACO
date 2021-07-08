import java.io.*;
import java.util.*;

class CowRating {
    int[] ratings;
    int n;

    public CowRating(int k) {
        ratings = new int[k];
    }

    public void addRating(int r) {
        ratings[n] = r;
        n++;
    }

    public boolean consistant(CowRating rating) {
        boolean original = ratings[0] > rating.ratings[0];
        for (int i = 1; i < ratings.length; i++) {
            if ((ratings[i] > rating.ratings[i]) != original)
                return false;
        }
        return true;
    }
}

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        String ProjectName = "gymnastics";
        Scanner sc = new Scanner(new File(ProjectName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ProjectName + ".out")));
        int k = sc.nextInt(), n = sc.nextInt();
        int i, j;
        CowRating[] cowRatings = new CowRating[n];
        for (i = 0; i < n; i++) {
            cowRatings[i] = new CowRating(k);
        }
        for (i = 0; i < k; i++) {
            for (j = 0; j < n; j++) {
                cowRatings[j].addRating(sc.nextInt());
            }
        }
        int pairs = 0;
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (cowRatings[i].consistant(cowRatings[j]))
                    pairs++;
            }
        }
        pw.println(pairs);
        pw.close();

    }
}
