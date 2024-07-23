package DP;

import java.io.*;
import java.util.Arrays;
// 最短Hamilton路径
public class AcWing091 {
    static int N = 20;
    static int[][] a = new int[N][N];
    static int[][] f = new int [1 << N][N]; // f[i][j]:从0走到j,走过点的情况是i的路径
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(f[i], 0x3f3f3f);
        }
        f[1][0] = 0;
        for (int i = 1; i < 1 << n; i += 2) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        if ((i >> k & 1) == 1)
                            // 按倒数第二个分类
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + a[k][j]);
                    }
                }
            }
        }
        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}
