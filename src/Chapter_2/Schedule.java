package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/10/04  22:02
 */
public class Schedule {
    //n：人数，a：日程表，i,j：行列坐标
    private static int[][] a;
    private static void table(int n, int i, int j) {
        if (n <= 1) return;
        table(n / 2, i, j);
        table(n / 2, i + n / 2, j);
        copy(n, i, j);
    }
    private static void copy(int n, int i, int j) {
        int m = n / 2;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                a[i + x + m][j + y + m] = a[i + x][j + y];
                a[i + x][j + y + m] = a[i + x + m][j + y];
            }
        }
    }
    public static void main(String[] args) {
        int n = 8;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][0] = i + 1;
        }
        table(n, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}