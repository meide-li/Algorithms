package SearchAndGraph;

import java.io.*;
import java.util.*;
// spfa求负环
public class AcWing852 {
    static final int N = 10010;
    static int[] e = new int[N], w = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static int[] d = new int[N], cnt = new int[N];  // 最短路经过的边数
    static boolean[] st = new boolean[N];
    static int n, m;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // 图邻接表
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int z = Integer.parseInt(s[2]);
                add(x, y, z);
            }
            System.out.println(spfa() ? "Yes" : "No");
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

    private static boolean spfa() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
            st[i] = true;
        }

        while (!q.isEmpty()) {
            int t = q.poll();
            st[t] = false;

            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return true;
                    if (!st[j]) {
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }
}
