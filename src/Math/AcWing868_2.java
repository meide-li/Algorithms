package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 线性筛法求素数
public class AcWing868_2 {
    static final int N = 1000010;
    static boolean[] st = new boolean[N];
    static int[] prime = new int[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int cnt = 0;
            for (int i = 2; i <= n; i++) {
                if (!st[i]) prime[cnt++] = i;
                for (int j = 0; prime[j] <= n / i; j++) {
                    st[i * prime[j]] = true;
                    if (i % prime[j] == 0) break;
                }
            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
