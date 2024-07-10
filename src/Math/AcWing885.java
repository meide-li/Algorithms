package Math;

import java.io.*;
// 求组合数Ⅰ
public class AcWing885 {
    static final int MOD = (int) (1e9 + 7), N = 2005;
    static int[][] C = new int[N][N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) C[i][j] = 1;
                    else C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                out.write(C[a][b] + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
