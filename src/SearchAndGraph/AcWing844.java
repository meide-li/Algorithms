package SearchAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// 走迷宫
public class AcWing844 {
    static final int N = 110;
    static int[][] a = new int[N][N];
    static int[][] d = new int[N][N];   // 记录步数
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 0; i < N; i++) {
                Arrays.fill(a[i], 1);
            }
            for (int i = 1; i <= n; i++) {
                s = in.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    a[i][j] = Integer.parseInt(s[j - 1]);
                }
            }

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{1, 1});
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                // 朝四个方向试探
                for (int i = 0; i < 4; i++) {
                    int[] ne = {cur[0] + dx[i], cur[1] + dy[i]};
                    if (a[ne[0]][ne[1]] == 0) { // 如果没有走过
                        a[ne[0]][ne[1]] = 1;
                        d[ne[0]][ne[1]] = d[cur[0]][cur[1]] + 1;
                        q.offer(ne);
                    }
                }
            }
            System.out.println(d[n][m]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
