package SearchAndGraph;

import java.io.*;
import java.util.Arrays;
// Bellman-Ford 算法
public class AcWing853 {
    static final int N = 505;
    static final int M = 10010;
    static int[] d = new int[N];
    static final int INF = 0x3f3f3f3f;
    static int n, m, k;
    static Edge[] edges = new Edge[M];

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // 边集
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            k = Integer.parseInt(s[2]);

            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int z = Integer.parseInt(s[2]);
                edges[i] = new Edge(x, y, z);
            }
            System.out.println(bellman_ford() < INF / 2 ? d[n] : "impossible");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Edge {
        int a, b, w;
        private Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    private static int bellman_ford() {
        Arrays.fill(d, INF);
        d[1] = 0;
        for (int i = 0; i < k; i++) {
            int[] back = Arrays.copyOf(d, d.length);
            for (int j = 0; j < m; j++) {
                int a = edges[j].a, b = edges[j].b, w = edges[j].w;
                d[b] = Math.min(d[b], back[a] + w);
            }
        }
        return d[n];
    }
}
