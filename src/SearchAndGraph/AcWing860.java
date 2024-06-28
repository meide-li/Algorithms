package SearchAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 染色法判定二分图
public class AcWing860 {
    static final int N = 100010;
    static int[] e = new int[2 * N], h = new int[N], ne = new int[2 * N];
    static int idx = 1;
    static int[] color = new int[N];    // -1未染色
    static int n, m;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                add(a, b); add(b, a);
            }
            System.out.println(check() ? "Yes" : "No");
            System.out.println(Arrays.toString(color));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    // 给u染c
    private static boolean dfs (int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != 0; i = ne[i]) {
            int j = e[i];
            if (color[j] == -1) {
                if (!dfs(j, c^1)) return false;
            } else if (color[j] == c) return false;
        }
        return true;
    }

    private static boolean check() {
        Arrays.fill(color, -1);
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            // 未染色
            if (color[i] == -1) {
                if (!dfs(i, 0)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
