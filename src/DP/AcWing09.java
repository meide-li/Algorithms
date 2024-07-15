package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 分组背包问题
public class AcWing09 {
    static final int N = 103, M = 103;
    static int[][] v = new int[N][N], w = new int[N][N];
    static int[] f = new int[M], u = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            u[i] = Integer.parseInt(in.readLine());
            for (int j = 1; j <= u[i]; j++) {
                s = in.readLine().split(" ");
                v[i][j] = Integer.parseInt(s[0]);
                w[i][j] = Integer.parseInt(s[1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= u[i]; k++) {
                    if (j >= v[i][k])
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                }
            }
        }

        System.out.println(f[m]);
    }
}
