package SearchAndGraph;

import java.io.*;
import java.util.*;
// spfa
public class AcWing851 {
    static final int N = 100010;
    static int[] e = new int[N], w = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static final int INF = 0x3f3f3f3f;
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
            System.out.println(spfa() > INF / 2 ? "impossible" : d[n]);
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

    private static int spfa() {
        Arrays.fill(d, INF);
        d[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        st[1] = true;
        while (!q.isEmpty()) {
            int t = q.poll();
            st[t] = false;

            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    if (!st[j]) {
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return d[n];
    }
}
