package SearchAndGraph;

import java.io.*;
// 排列数字
public class AcWing842 {
    static boolean[] state = new boolean[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            dfs(1, n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int u, int n) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (u > n) {
            for (int i = 1; i <= n; i++) out.write(a[i] + " ");
            out.newLine();
            out.flush();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!state[i]) {
                state[i] = true;
                a[u] = i;
                dfs(u + 1, n);
                state[i] = false;
            }
        }
    }
}
