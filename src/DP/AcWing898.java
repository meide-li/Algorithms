package DP;

import java.io.*;
import java.util.Arrays;
// 数字三角形——自顶而下
public class AcWing898 {
    static final int N = 503, INF = 0x3f3f3f3f;
    static int[][] a = new int[N][N];
    static int[] f = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            String[] s = in.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        // 若在线更新a，几乎无提升
        Arrays.fill(f, -INF);
        f[1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                f[j] = Math.max(f[j - 1], f[j]) + a[i][j];
            }
        }

        int res = -INF;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}