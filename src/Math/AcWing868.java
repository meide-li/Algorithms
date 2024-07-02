package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 朴素筛法求素数
public class AcWing868 {
    static final int N = 1000010;
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int cnt = 0;
            for (int i = 2; i <= n; i++) {
                if (!st[i]) {
                    cnt++;
                    for (int j = i; j <= n; j += i) st[j] = true;
                }
            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
