package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 多重背包问题Ⅰ
public class AcWing04 {
    static final int N = 103, M = 103;
    static int[] v = new int[N], w = new int[N], u = new int[N];
    static int[] f = new int[M];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            s = in.readLine().split(" ");
            v[i] = Integer.parseInt(s[0]);
            w[i] = Integer.parseInt(s[1]);
            u[i] = Integer.parseInt(s[2]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                for (int k = 0; k <= u[i] && j >= k * v[i]; k++) {
                    f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(f[m]);
    }
}
