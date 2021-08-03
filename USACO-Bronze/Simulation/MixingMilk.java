import java.io.*;
import java.util.*;

//o(n)

public class MixingMilk {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("mixingMilk.in"));
        int[] buckets = new int[3];
        int[] max = new int[3];
        int i;
        for (i = 0; i < 3; i++) {
            max[i] = sc.nextInt();
            buckets[i] = sc.nextInt();
        }
        int num1, num2;
        for (i = 0; i < 100; i++) {
            num1 = i % 3;
            num2 = (i + 1) % 3;
            if (buckets[num1] + buckets[num2] > max[num2]) {
                buckets[num2] = max[num2];
                buckets[num1] -= max[num2] - buckets[num2];
            } else {
                buckets[num2] += buckets[num1];
                buckets[num1] = 0;
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("mixingMilk.out"));
        for (i = 0; i < 3; i++) {
            pw.println(buckets[i]);
        }
        pw.close();

    }

}
