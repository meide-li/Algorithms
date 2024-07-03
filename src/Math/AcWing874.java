package Math;

import java.util.Scanner;
// 筛法求欧拉函数
public class AcWing874 {
    static final int N = 1000010;
    static int[] euler = new int[N], primes = new int[N];
    static boolean[] st = new boolean[N];
    static int n;
    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        getEulers(n);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += euler[i];
        }
        System.out.println(res);
    }
    private static void getEulers(int x) {
        euler[1] = 1;
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                euler[i] = i - 1;
            }
            for (int j = 0; primes[j] <= x / i; j++) {
                int t = i * primes[j];
                st[t] = true;
                if (i % primes[j] == 0) {
                    euler[t] = euler[i] * primes[j];
                    break;
                }
                euler[t] = euler[i] * (primes[j] - 1);
            }
        }
    }
}
