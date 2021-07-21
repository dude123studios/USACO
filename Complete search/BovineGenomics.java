import java.io.*;
import java.util.*;

class Position {

    HashSet<Object> spotty;
    char[] plain;

    public Position(int n) {
        spotty = new HashSet<Object>(4);
        plain = new char[n];
    }

    public boolean es() {
        for (int i = 0; i < plain.length; i++) {
            if (spotty.contains(plain[i]))
                return false;
        }
        return true;
    }

}

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        String ProjectName = "cownomics";
        Scanner sc = new Scanner(new File(ProjectName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ProjectName + ".out")));

        int n = sc.nextInt(), m = sc.nextInt();
        int i, j;
        Position[] pos = new Position[m];
        for (i = 0; i < m; i++) {
            pos[i] = new Position(n);
        }
        String line;

        for (i = 0; i < n; i++) {
            line = sc.next();
            for (j = 0; j < m; j++) {
                pos[j].spotty.add(line.charAt(j));
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {

            }
        }
        int sum = 0;
        for (i = 0; i < m; i++) {
            if (pos[i].es())
                sum++;
        }
        pw.println(sum);
        pw.close();
    }
}
