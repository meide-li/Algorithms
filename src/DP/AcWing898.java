package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 数字三角形——自顶而下
public class AcWing898 {
    static final int N = 503, INF = 0x3f3f3f3f;
    static int[][] f = new int[N][N], a = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            Arrays.fill(f[i], -INF);
            String[] s = in.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        f[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + a[i][j];
            }
        }

        int res = -INF;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);
    }
}
