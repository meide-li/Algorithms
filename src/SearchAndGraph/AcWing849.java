package SearchAndGraph;

import java.io.*;
import java.util.Arrays;
// 朴素dijkstra
public class AcWing849 {
    static final int N = 503;
    static int[][] g = new int[N][N];
    static final int INF = 0x3f3f3f3f;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // 图邻接矩阵
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) {
                Arrays.fill(g[i], INF);
                g[i][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int z = Integer.parseInt(s[2]);
                g[x][y] = Math.min(g[x][y], z);     // 去重边
            }
            System.out.println(dijksrta(n) == INF ? -1 : d[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int dijksrta(int n) {
        Arrays.fill(d, INF);
        d[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            // 在还未确定最短路的点中，寻找dist最小的点
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[t] > d[j])) t = j;
            }
            if (t == n) break;
            st[t] = true;
            // 更新的d[]
            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }
        return d[n];
    }
}