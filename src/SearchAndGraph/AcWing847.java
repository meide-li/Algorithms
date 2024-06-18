package SearchAndGraph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// 图中点的层次
public class AcWing847 {
    static final int N = 100010;
    static int[] e = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static boolean[] st = new boolean[N];
    static int[] d = new int[N];    // 距离，其实本题di[]可以代替st[]的功能
    static Queue<Integer> q = new LinkedList<>();

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
            }

            System.out.println(bfs(n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int bfs(int n) {
        Arrays.fill(d, -1);
        st[1] = true;
        q.offer(1);
        d[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = h[cur]; i != 0; i = ne[i]) {
                int j = e[i];
                if (!st[j]) {
                    st[j] = true;
                    q.offer(j);
                    d[j] = d[cur] + 1;
                }
                if (d[n] != -1) return d[n];
            }
        }
        return -1;
    }
}