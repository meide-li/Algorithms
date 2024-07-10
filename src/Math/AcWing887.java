package Math;

import java.io.*;
// 求组合数Ⅲ
public class AcWing887 {
    static int p;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());

            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                long a = Long.parseLong(s[0]);
                long b = Long.parseLong(s[1]);
                p = Integer.parseInt(s[2]);
                out.write((int) lucas(a, b) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static long qmi(long a) {
        long res = 1;
        int k = p - 2;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % p;
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }
    // 定义求组合数
    private static long C(long a, long b) {
        long res = 1;
        for (long i = 1, j = a; i <= b; i++, j--) {
            res = res * j % p;
            res = res * qmi(i) % p;
        }
        return res;
    }
    private static long lucas(long a, long b) {
        if (a < p) return C(a, b);
        return C(a % p, b % p) * lucas(a / p, b / p) % p;
    }
}
