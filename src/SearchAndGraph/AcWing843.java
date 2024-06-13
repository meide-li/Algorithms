package SearchAndGraph;

import java.io.*;
import java.util.Arrays;

// n皇后
public class AcWing843 {
    static final int N = 12;
    static char[][] res =new char[N][N];
    static boolean[] col = new boolean[N];
    static boolean[] dig = new boolean[2 * N];
    static boolean[] sdig = new boolean[2 * N];
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 1; i <= n; i++) {
                Arrays.fill(res[i], '.');
            }
            dfs(1, n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int u, int n) throws IOException{
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    out.write(res[i][j]);
                }
                out.newLine();
            }
            out.newLine();
            out.flush();
            return;
        }
        // 决定在哪一列放
        for (int i = 1; i <= n; i++) {
            if (!col[i] && !dig[u - i + n] && !sdig[u + i]) {
                col[i] = dig[u - i + n] = sdig[u + i] = true;
                res[u][i] = 'Q';
                dfs(u + 1, n);
                col[i] = dig[u - i + n] = sdig[u + i] = false;
                res[u][i] = '.';
            }
        }
    }
}
