package SearchAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AcWing861 {
    static final int N = 100010;
    static int[] e = new int[N], h = new int[N], ne = new int[N];
    static int idx = 1;
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    static int n1, n2, m;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            n1 = Integer.parseInt(s[0]);
            n2 = Integer.parseInt(s[1]);
            m = Integer.parseInt(s[2]);
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                add(u, v);
            }
            int res = 0;
            for (int i = 1; i <= n1; i++) {
                Arrays.fill(st, false);
                if (find(i)) res++;
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void add(int u, int v) {
        e[idx] = v;
        ne[idx] = h[u];
        h[u] = idx++;
    }

    private static boolean find(int x) {
        for (int i = h[x]; i != 0; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
