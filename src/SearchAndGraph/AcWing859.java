package SearchAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
// kruskal算法
public class AcWing859 {
    static final int N = 100010, INF = 0x3f3f3f;
    static int[] p = new int[N];
    static int n, m;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                edges.offer(new Edge(a, b, c));
            }
            int t = kruskal(edges);
            System.out.println(t == INF ? "impossible" : t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int kruskal(PriorityQueue<Edge> edges) {
        int res = 0, cnt = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            Edge e = edges.poll();
            int u = e.u, v = e.v, w = e.w;
            u = find(u); v = find(v);
            if (u != v) {
                p[u] = v;
                res += w;
                cnt++;
            }
            if (cnt == n) return res;
        }
        return INF;
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static class Edge {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
