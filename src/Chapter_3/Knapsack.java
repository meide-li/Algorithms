package Chapter_3;

public class Knapsack {
    private static void knapsack(int[] v, int[] w, int C, int[][] m) {//价值、重量、容量
        for (int j = 0; j <= C; j++) {
            m[0][j] = (j >= w[0]) ? v[0] : 0;
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j <= C; j++) {
                //第i件不可能装得下
                if (j < w[i]) {
                    m[i][j] = m[i - 1][j];
                }
                //第i件可能装得下
                else {
                    int a = m[i - 1][j];
                    int b = m[i - 1][j - w[i]] + v[i];
                    m[i][j] = (a >= b) ? a : b;
                }
            }
        }
    }

    private static void traceback(int[] w,int[][] m, int a, int b) {
        if(a < 0 || b < 0) return;
        if (a > 0 && m[a][b] == m[a-1][b]) traceback(w, m, a - 1, b);
        else {
            traceback(w, m, a - 1, b - w[a]);
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] v = {3, 6, 9, 7};
        int[] w = {2, 3, 4, 2};
        int n = v.length;//物品数量
        int C = 4;
        int[][] m = new int[n][C + 1];

        knapsack(v, w, C, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }

        traceback(w, m, n - 1, C);
    }
}
