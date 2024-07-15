package DP;

import java.io.*;
// 数字三角形——自底而上
public class AcWing898_2 {
    static final int N = 503, INF = 0x3f3f3f3f;
    static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            String[] s = in.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                f[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                f[i][j] += Math.max(f[i + 1][j], f[i + 1][j + 1]);
            }
        }

        System.out.println(f[1][1]);
    }
}
