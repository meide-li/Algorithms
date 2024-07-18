package DP;

import java.io.*;
import java.util.Arrays;
// 石子合并——循环
public class AcWing282 {
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
            Arrays.fill(f[i], 0x3f3f3f);
            f[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;

                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + S[j] - S[i - 1]);
                }
            }
        }

        System.out.println(f[1][n]);
    }
}
