package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 最长上升子序列
public class AcWing895 {
    static final int N = 1010;
    static int[] f = new int[N], a = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i + 1] = Integer.parseInt(s[i]);
        }

        int res = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i]) f[i] = Math.max(f[i], f[j] + 1);
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
