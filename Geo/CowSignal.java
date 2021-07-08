import java.io.*;
import java.util.*;

//o(n^2)

public class CowSignal {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("cowsignal.in"));
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        String line;
        StringBuilder sb;
        PrintWriter pw = new PrintWriter(new FileWriter("cowsignal.out"));
        int i, j;
        for (i = 0; i < m; i++) {
            line = sc.nextLine();
            sb = new StringBuilder();
            for (j = 0; j < n; j++) {
                sb.append(line.charAt(j) * k);
            }
            for (j = 0; j < k; j++) {
                pw.println(sb.toString());
            }
        }
        pw.close();
    }
}
