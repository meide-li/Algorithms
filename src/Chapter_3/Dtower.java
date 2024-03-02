package Chapter_3;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/10/06  21:36
 */
public class Dtower {
    private static int[][] stower(int[][] a) {
        int n = a.length;
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) s[n - 1][i] = a[n - 1][i];
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                s[i][j] = a[i][j] + max(s[i + 1][j], s[i + 1][j + 1]);
            }
        }
        return s;
    }

    private static void traceback(int[][] a, int[][] s, int i, int j){
        int n = a.length - 1;
        if (i == n){
            System.out.println(j);
            return;
        }
        System.out.println(j);
        if (s[i][j] == a[i][j] + s[i + 1][j]) {
            traceback(a, s, i + 1, j);
        } else {
            traceback(a, s, i + 1, j + 1);
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {30, 0, 0, 0, 0},
                {23, 21, 0, 0, 0},
                {20, 13, 10, 0, 0},
                {7, 12, 10, 22, 0},
                {4, 5, 2, 6, 5}
        };
        int[][] s = stower(a);
        traceback(a, s, 0, 0);
    }
}
