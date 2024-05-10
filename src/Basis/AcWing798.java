package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 差分矩阵
public class AcWing798 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int q = Integer.parseInt(s[2]);
            // 可以省去原来的a矩阵，a相当于在0矩阵中插入元素
            int[][] b = new int[n + 2][m + 2];

            for (int i = 1; i <= n; i++) {
                s = in.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    int c = Integer.parseInt(s[j - 1]);
                    // 初始化b
                    insert(b, i, j, i, j, c);
                }
            }

            for (int i = 0; i < q; i++) {
                s = in.readLine().split(" ");
                int x1 = Integer.parseInt(s[0]);
                int y1 = Integer.parseInt(s[1]);
                int x2 = Integer.parseInt(s[2]);
                int y2 = Integer.parseInt(s[3]);
                int c = Integer.parseInt(s[4]);
                insert(b, x1, y1, x2, y2, c);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    b[i][j] = b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1] + b[i][j];
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(int[][] arr, int x1, int y1, int x2, int y2, int c) {
        arr[x1][y1] += c;
        arr[x1][y2 + 1] -= c;
        arr[x2 + 1][y1] -= c;
        arr[x2 + 1][y2 + 1] += c;
    }
}
