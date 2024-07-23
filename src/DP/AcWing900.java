package DP;

import java.util.Scanner;
// 整数划分
public class AcWing900 {
    static int N = 1010, MOD = (int) (1e9 + 7);
    static int[] f = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j - i]) % MOD;
            }
        }
        System.out.println(f[n]);
    }
}
