package Math;

import java.io.*;
// 求组合数Ⅱ
public class AcWing886 {
    static final int MOD = (int) (1e9 + 7), N = 100010;
    static long[] fact = new long[N], infact = new long[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());

            fact[0] = infact[0] = 1;
            for(int i = 1; i < N; i++) {
                fact[i] = fact[i - 1] * i % MOD;
                infact[i] = infact[i - 1] * qmi(i) % MOD;
            }

            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                // 这里输出的时候不能把三个全乘到一起然后再 %，会溢出
                long res = fact[a] * infact[b] % MOD * infact[a - b] % MOD;
                out.write(res + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long qmi(long a) {
        int k = MOD - 2;
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            k >>= 1;
        }
        return res;
    }
}