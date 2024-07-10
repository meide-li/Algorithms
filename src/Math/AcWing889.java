package Math;

import java.util.Scanner;
// 卡特兰数
public class AcWing889 {
    static int n, MOD = (int) (1e9 + 7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        long res = 1;
        for (int i = 1, j = 2 * n; i <= n; i++, j--) {
            res = res * j % MOD;
            res = res * qmi(i) % MOD;
        }
        res = res * qmi(n + 1) % MOD;
        System.out.println(res);
    }

    private static long qmi(long a) {
        long res = 1;
        int k = MOD - 2;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            k >>= 1;
        }
        return res;
    }
}
