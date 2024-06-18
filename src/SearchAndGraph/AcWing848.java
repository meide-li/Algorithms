package SearchAndGraph;

import java.io.*;
// 拓扑排序
public class AcWing848 {
    static final int N = 100010;
    static int[] e = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static int[] d = new int[N], q = new int[N];    // 各点的入度和队列
    static int hh = 0, tt = -1;
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // 图邻接表
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                add(a, b);
                d[b] += 1;
            }
            System.out.println(topsort(n) ? res : -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    private static boolean topsort(int n) {
        // 入度为0的入队
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
                res.append(i).append(" ");
            }
        }
        while (tt >= hh) {
            int t = q[hh++];
            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    q[++tt] = j;
                    res.append(j).append(" ");
                }
            }
        }
        // 是否所有节点都能入队
        return tt == n - 1;
    }
}