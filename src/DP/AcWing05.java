package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 多重背包问题Ⅱ
public class AcWing05 {
    static final int N = 11010, M = 2010;
    static int[] v = new int[N], w = new int[N];
    static int[] f = new int[M];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            int k = 1;
            while (k <= c) {
                cnt++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                c -= k;
                k *= 2;
            }
            if (c > 0) {
                cnt++;
                v[cnt] = c * a;
                w[cnt] = c * b;
            }
        }
        n = cnt;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);
    }
}
