import java.io.IOException;

import java.io.*;
import java.util.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("pails.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("pails.out"));

        int x = sc.nextInt(), y = sc.nextInt(), m = sc.nextInt();
        int max = 0;
        for (int i = 0; i < (int) (m / x); i++) {
            max = Math.max(x * i + y * (int) ((m - x * i) / y), max);
        }
        pw.println(max);
        pw.close();
    }
}
