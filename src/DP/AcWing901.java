package DP;

import java.io.*;
import java.util.Arrays;
// 滑雪——记忆化搜索（递归）
public class AcWing901 {
    static final int N = 310;
    static int[][] w = new int[N][N], f = new int[N][N];
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        for (int i = 0; i < r; i++) {
            Arrays.fill(f[i], -1);
            s = in.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                w[i][j] = Integer.parseInt(s[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res = Math.max(res, dp(i, j));
            }
        }
        System.out.println(res);
    }

    private static int dp(int x, int y) {
        if (f[x][y] != -1) return f[x][y];

        f[x][y] = 1;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < r && b >= 0 && b < c && w[x][y] > w[a][b])
                f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
        }

        return f[x][y];
    }
}
