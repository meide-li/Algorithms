package DP;

import java.io.*;
// 没有上司的舞会
public class AcWing285 {
    static final int N = 6010;
    static int[] e = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static int[] happy = new int[N];
    static int[][] f = new int[N][2];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(in.readLine());
        }

        boolean[] st = new boolean[N];
        int root = 1;
        for (int i = 0; i < n - 1; i++) {
            String[] s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            add(b, a);
            st[a] = true;
        }
        while (st[root]) root++;

        System.out.println(dfs(root));
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int dfs(int x) {
        f[x][1] = happy[x];

        for (int i = h[x]; i != 0; i = ne[i]) {
            int j = e[i];
            dfs(j);

            f[x][1] += f[j][0];
            f[x][0] += Math.max(f[j][0], f[j][1]);
        }
        return Math.max(f[x][0], f[x][1]);
    }
}
