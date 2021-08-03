import java.io.*;
import java.util.*;

//o(n)

public class ShellGame {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("shell.in"));
        int numSwaps = sc.nextInt();
        int[] shells = new int[] { 0, 1, 2 };
        int[] count = new int[3];
        int a, b, g, temp;
        for (int i = 0; i < numSwaps; i++) {
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            g = sc.nextInt() - 1;

            temp = shells[a];
            shells[a] = shells[b];
            shells[b] = temp;
            count[shells[g]]++;
        }
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));
        pw.println(Math.max(count[0], Math.max(count[1], count[2])));
        pw.close();

    }

}
