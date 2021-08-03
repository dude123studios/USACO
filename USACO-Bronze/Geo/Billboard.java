import java.io.*;
import java.util.*;

//o(1)

class Rect {
    int x1, y1, x2, y2;

    int area() {
        return (x2 - x1) * (y2 - y1);
    }
}

public class Billboard {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("billboard.in"));

        Rect a = new Rect(), b = new Rect(), c = new Rect();
        a.x1 = sc.nextInt();
        a.y1 = sc.nextInt();
        a.x2 = sc.nextInt();
        a.y2 = sc.nextInt();
        b.x1 = sc.nextInt();
        b.y1 = sc.nextInt();
        b.x2 = sc.nextInt();
        b.y2 = sc.nextInt();
        c.x1 = sc.nextInt();
        c.y1 = sc.nextInt();
        c.x2 = sc.nextInt();
        c.y2 = sc.nextInt();

        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));
        pw.println(a.area() + b.area() - intersect(a, c) - intersect(b, c));
        pw.close();
    }

    static int intersect(Rect p, Rect q) {
        int xOverlap = Math.max(0, Math.min(p.x2, q.x2) - Math.max(p.x1, q.x1));
        int yOverlap = Math.max(0, Math.min(p.y2, q.y2) - Math.max(p.y1, q.y1));
        return xOverlap * yOverlap;
    }
}