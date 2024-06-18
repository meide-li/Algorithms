package SearchAndGraph;

import java.io.*;
// 树的重心
public class AcWing846 {
    static final int N = 100010;
    static int[] e = new int[2 * N], h = new int[2 * N], ne = new int[2 * N];
    static int idx = 1;
    static boolean[] st = new boolean[N];
    static int res = N;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            // 建图
            String[] s;
            for (int i = 0; i < n - 1; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                add(a, b);
                add(b, a);
            }

            dfs(1, n);
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    private static int dfs(int u, int n) {
        st[u] = true;
        int sum = 1, size = 0;
        for (int i = h[u]; i != 0; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                int t = dfs(j, n);
                // 最大的子树
                size = Math.max(size, t);
                // 以此节点为根的树的大小
                sum += t;
            }
        }
        // 去除当前节点后的最大连通分支的点数
        size = Math.max(size, n - sum);
        res = Math.min(res, size);
        return sum;
    }
}
