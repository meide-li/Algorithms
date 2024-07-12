package Math;

import java.util.Scanner;
// 容斥原理
public class AcWing890 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 1; i < 1 << m; i++) {
            int cnt = 0;    // 当前组合选取了多少个集合
            int temp = 1;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    if ((long) temp * p[j] > n) {
                        temp = -1;
                        break;
                    }
                    cnt++;
                    temp *= p[j];
                }
            }
            if (temp == -1) continue;
            if (cnt % 2 == 0) res -= n / temp;
            else res += n / temp;
        }
        System.out.println(res);
    }
}
