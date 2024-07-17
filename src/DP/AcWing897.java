package DP;

import java.io.*;
// 最长公共子序列
public class AcWing897 {
    static final int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char[] a = (0 + in.readLine()).toCharArray();
        char[] b = (0 + in.readLine()).toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                if (a[i] == b[j]) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
             }
        }

        System.out.println(f[n][m]);
    }
}
