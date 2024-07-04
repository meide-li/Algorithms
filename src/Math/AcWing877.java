package Math;

import java.io.*;
// 扩展欧几里得算法
public class AcWing877 {
    static int x, y;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                exgcd(a, b);
                out.write(x + " " + y + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void exgcd(int a, int b) {
        if (b == 0) {
            x = 1; y = 0;
            return;
        }
        exgcd(b, a % b);
        int t = x;
        x = y;
        y = t - a / b * y;
    }
}
