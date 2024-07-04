package Math;

import java.io.*;
// 线性同余方程
public class AcWing878 {
    static int x, y;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int m = Integer.parseInt(s[2]);
                // b是(a, m)的倍数时有解
                int d = exgcd(a, m);
                out.write(b % d == 0 ? (long) x * b / d % m + "\n" : "impossible\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int exgcd(int a, int b) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        int d = exgcd(b, a % b);
        int t = x;
        x = y;
        y = t - a / b * y;
        return d;
    }
}
