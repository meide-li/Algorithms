package Chapter_3;

public class LcsLength {
    private static int lcsLength(int[] x, int[] y, int[][] b){
        int m = x.length;
        int n = y.length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = (i > 0 && j > 0) ? c[i - 1][j - 1] + 1 : 1;
                    b[i][j] = 1;
                } else if (i > 0 && j > 0 && c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 2;
                } else if (i > 0) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 3;
                }
            }
        }
        return c[m - 1][n - 1];
    }

    private static void lcs(int[] x, int[][] b, int m, int n) {
        if (m < 0 || n < 0) return;
        if (b[m][n] == 1) {
            lcs(x, b, m - 1, n - 1);
            System.out.print(x[m] + " ");
        }else if (b[m][n] == 2) lcs(x, b, m, n - 1);
        else lcs(x, b, m - 1, n);
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 5, 7, 2, 6};
        int[] y = {1, 4, 2, 5, 6};
        int[][] b = new int[x.length][y.length];
        System.out.println(lcsLength(x, y, b));
        lcs(x, b, x.length - 1, y.length - 1);
    }
}