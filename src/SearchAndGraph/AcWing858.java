package SearchAndGraph;

import java.io.*;
import java.util.Arrays;

// prim算法
public class AcWing858 {
    static final int N = 505, INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static int n, m;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) {
                Arrays.fill(g[i], INF);
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                int w = Integer.parseInt(s[2]);
                g[u][v] = g[v][u] = Math.min(g[u][v], w);
            }
            int t = prim();
            System.out.println(t == INF ? "impossible" : t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int prim() {
        Arrays.fill(d, INF);
        d[1] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || d[t] > d[j])) t = j;
            }
            if (d[t] == INF) return INF;

            st[t] = true;
            res += d[t];
            for (int j = 1; j <= n; j++) {
                if (!st[j]) d[j] = Math.min(d[j], g[t][j]);
            }
        }
        return res;
    }
}
