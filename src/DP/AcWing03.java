package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 完全背包
public class AcWing03 {
    static final int N = 1010, M = 1010;
    static int[] v = new int[N], w = new int[N];
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
        }

        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);
    }
}
