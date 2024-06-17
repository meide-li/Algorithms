package SearchAndGraph;

import java.io.*;
import java.util.Arrays;
// Floyd求最短路
public class AcWing854 {
    static final int N = 205;
    static final int INF = 0x3f3f3f;
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            // 初始化g
            for (int i = 1; i <= n; i++) {
                Arrays.fill(d[i], INF);
                d[i][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int w = Integer.parseInt(s[2]);
                d[a][b] = Math.min(d[a][b], w);
            }

            floyd(n);
            for (int i = 0; i < k; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                out.write(d[a][b] > INF / 2 ? "impossible\n" : d[a][b] + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
