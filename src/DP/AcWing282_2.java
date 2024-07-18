package DP;

import java.io.*;
import java.util.Arrays;
// 石子合并——迭代（记忆化搜索）
public class AcWing282_2 {
    static final int N = 310;
    static int[][] f = new int[N][N];
    static int[] S = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++) S[i] = S[i - 1] + a[i - 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(f[i], -1);
        }
        System.out.println(dp(1, n));
    }

    private static int dp(int x, int y) {
        if (x == y) return 0;
        if (f[x][y] != -1) return f[x][y];

        f[x][y] = 0x3f3f3f;
        for (int k = x; k < y; k++) {
            f[x][y] = Math.min(f[x][y], dp(x, k) + dp(k + 1, y) + S[y] - S[x - 1]);
        }
        return f[x][y];
    }
}
