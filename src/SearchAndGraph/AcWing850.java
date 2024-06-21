package SearchAndGraph;

import java.io.*;
import java.util.*;

// 堆优化dijkstra
public class AcWing850 {
    static final int N = 150010;
    static int[] e = new int[N], h = new int[N], ne = new int[N], w = new int[N];
    static int idx = 1;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int z = Integer.parseInt(s[2]);
                add(x, y, z);
            }
            System.out.println(dijkstra(n) == INF ? -1 : d[n]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void add(int x, int y, int z) {
        e[idx] = y;
        w[idx] = z;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    private static int dijkstra(int n) {
        PriorityQueue<int[]> heap =
                new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));     // 节点编号，距离
        Arrays.fill(d, INF);
        d[1] = 0;
        heap.offer(new int[]{1, 0});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int nd = cur[0], dis = cur[1];
            if (st[nd]) continue;
            st[nd] = true;
            for (int i = h[nd]; i != 0; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                    heap.offer(new int[]{j, d[j]});
                }
            }
        }
        return d[n];
    }
}
