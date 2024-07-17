package DP;

import java.io.*;
// 最短编辑距离
public class AcWing902 {
    static final int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        char[] a = (0 + in.readLine()).toCharArray();
        int m = Integer.parseInt(in.readLine());
        char[] b = (0 + in.readLine()).toCharArray();

        for (int i = 1; i <= n; i++) f[i][0] = i;
        for (int i = 1; i <= m; i++) f[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i] == b[j]) f[i][j] = f[i - 1][j - 1];
                else {
                    f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]) + 1;
                }
            }
        }

        System.out.println(f[n][m]);
    }
}
