package Math;

import java.io.*;
import java.util.PriorityQueue;
// 试除法求约数
public class AcWing869 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(in.readLine());
                PriorityQueue<Integer> res = getDivisor(a);
                while (!res.isEmpty()) {
                    out.write(res.poll() + " ");
                }
                out.newLine();
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PriorityQueue<Integer> getDivisor(int a) {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        for (int i = 1; i <= a / i; i++) {
            if (a % i == 0) {
                h.offer(i);
                if (i != a / i) h.offer(a / i);
            }
        }
        return h;
    }
}
