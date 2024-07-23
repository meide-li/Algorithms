package DP;

import java.io.*;
import java.util.Arrays;
// 蒙德里安的梦想
public class AcWing291 {
    static int N = 12, M = 1 << N;
    // f[i][j]表示已经将前i -1列摆好，且从第i−1列，伸出到第i列的状态是j的所有方案
    static long[][] f = new long[N][M];
    static boolean[] st = new boolean[M];
    static int[][] state = new int[M][M];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            if (n == 0) break;

            for (int i = 0; i < 1 << n; i++) {
                int cnt = 0;
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 1) {
                        if ((cnt & 1) == 1) break;
                        cnt = 0;
                    } else cnt++;
                }
                // 判断最后一层
                if ((cnt & 1) == 0) flag = true;
                st[i] = flag;
            }

            for (int i = 0; i < 1 << n; i++) {
                Arrays.fill(state[i], 0);
                for (int j = 0; j <= i; j++) {
                    if ((i & j) == 0 && st[i | j]) state[i][j] = state[j][i] = 1;
                }
            }

            for (int i = 0; i <= m; i++) {
                Arrays.fill(f[i], 0);
            }
            f[0][0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < 1 << n; k++) {
                        if (state[j][k] == 1) f[i][j] += f[i - 1][k];
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
