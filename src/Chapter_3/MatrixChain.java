package Chapter_3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/10/06  9:23
 */
public class MatrixChain {
    //p：矩阵维数，第一个矩阵的行数和所有矩阵的列数；m：最少数乘次数；s：最优断开位置
    private static void matrixChain(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;
        //与矩阵数学下标相同，从1开始
        for (int i = 1; i <= n; i++) m[i][i] = 0;
        //r控制相乘矩阵的个数
        for (int r = 2; r <= n; r++) {
            //i：开始矩阵下标
            for (int i = 1; i <= n - r + 1; i++) {
                //j：结束矩阵下标
                int j = i + r - 1;
                //在矩阵i后面断开的情况
                m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                //不同断开方式，更好则替换
                for (int k = i + 1; k < r; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    private static ArrayList<Integer> division = new ArrayList<>();
    private static void tracceBack(int[][] s, int i, int j) {
        if (i+1 >= j) return;
        tracceBack(s, i, s[i][j]);
        tracceBack(s, s[i][j] + 1, j);
        division.add(s[i][j]);
    }

    public static void main(String[] args) {
        int[] p = {10, 100, 5, 50};
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];
        matrixChain(p, m, s);
        System.out.println(m[1][p.length - 1]);
        tracceBack(s, 1, p.length - 1);
        Collections.sort(division);
        for (Integer num:division) {
            System.out.print(num+" ");
        }
    }
}