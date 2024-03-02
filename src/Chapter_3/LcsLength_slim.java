package Chapter_3;

public class LcsLength_slim {
    private static int lcsLength(int[] x, int[] y){
        int m = x.length;
        int n = y.length;
        int[][] c = new int[2][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    c[1][j] = j > 0 ? c[0][j - 1] + 1 : 1;
                } else if (j > 0 && c[1][j - 1] > c[0][j]) {
                    c[1][j] = c[1][j - 1];
                } else{
                    c[1][j] = c[0][j];
                }
            }
            for (int j = 0; j < n; j++) c[0][j] = c[1][j];
        }
        return c[1][n - 1];
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 5, 7, 2, 6};
        int[] y = {1, 5, 2, 4, 3};
        System.out.println(lcsLength(x, y));
    }
}
