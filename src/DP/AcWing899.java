package DP;

import java.io.*;
import java.util.HashSet;
// 编辑距离
public class AcWing899 {
    static final int N = 15;
    static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 1; i < N; i++) f[i][0] = f[0][i] = i;

        HashSet<char[]> str = new HashSet<>();
        for (int i = 0; i < n; i++) {
            str.add((0 + in.readLine()).toCharArray());
        }

        for (int k = 0; k < m; k++) {
            int res = 0;
            s = in.readLine().split(" ");
            char[] b = (0 + s[0]).toCharArray();
            int y = b.length - 1;
            int lim = Integer.parseInt(s[1]);
            for (char[] a : str) {
                int x = a.length - 1;
                for (int i = 1; i <= x; i++) {
                    for (int j = 1; j <= y; j++) {
                        if (a[i] == b[j]) f[i][j] = f[i - 1][j - 1];
                        else {
                            f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]) + 1;
                        }
                    }
                }
                if (f[x][y] <= lim) res++;
            }
            out.write(res + "\n");
        }
        out.flush();
    }
}
