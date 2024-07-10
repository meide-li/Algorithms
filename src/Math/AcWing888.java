package Math;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.*;
// 求组合数Ⅳ
public class AcWing888 {
    static int a, b, cnt, N = 5007;
    static int[] primes = new int[N], sum = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        get_primes(a);
        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = get(a, p) - get(a - b, p) - get(b, p);
        }

        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            for (int j = 0; j < sum[i]; j++) {
                res = res.multiply(BigInteger.valueOf(p));
            }
        }
        System.out.println(res);
    }
    private static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; i <= n / primes[j]; j++) {
                st[i * primes[j]] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }
    private static int get(int n, int p) {
        int res = 0;
        while (n != 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }
}
