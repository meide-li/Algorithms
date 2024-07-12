package Math;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
// 拆分Nim游戏
public class AcWing894 {
    static final int N = 103;
    static int[] f = new int[N];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        Arrays.fill(f, -1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(s[i]);
            res ^= sg(a);
        }
        System.out.println(res != 0 ? "Yes" : "No");
    }

    private static int sg(int x) {
        if (f[x] != -1) return f[x];

        // 状态转移
        HashSet<Integer> S = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                S.add(sg(i) ^ sg(j));
            }
        }

        for (int i = 0; ; i++) {
            if (!S.contains(i)) return f[x] = i;
        }
    }
}