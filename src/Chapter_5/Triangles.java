package Chapter_5;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/11/21  15:55
 */
public class Triangles {
    static int n,               // 三角形的边数
               half,            // 三角形元素个数的一半，即 n*(n+1)/4
               plus_nums;       //加号的个数
    static int[][] p;             //符号三角形矩阵
    static long sum;            //符号条件的三角形个数
    //回溯
    private static void backtrack(int t) {
        if ((plus_nums > half) || t * (t - 1) / 2 - plus_nums > half) return;   //剪枝
        if (t > n) {
            sum ++;
        } else {
            for (int i = 0; i < 2; i++) {
                p[1][t] = i;
                plus_nums += i;
                //计算p矩阵
                for (int j = 2; j <= t; j++) {
                    p[j][t - j + 1] = p[j - 1][t - j + 1] ^ p[j - 1][t - j + 2];    //异或
                    plus_nums += p[j][t - j + 1];
                }
                backtrack(t + 1);
                for (int j = 2; j <= t; j++) {
                    plus_nums -= p[j][t - j + 1];
                }
                plus_nums -= i;
            }
        }

    }

    public static void main(String[] args) {
        n = 7;
        half = n * (n + 1) / 2;
        if (half % 2 == 1) {
            throw new RuntimeException("n*(n+1)/2 必须为偶数");
        } else {
            half /= 2;
        }
        plus_nums = 0;
        p = new int[n+1][n+1];
        sum = 0;
        backtrack(1);
        System.out.printf(String.valueOf(sum));
    }
}
