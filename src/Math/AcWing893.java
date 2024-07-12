package Math;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
// 集合Nim游戏
public class AcWing893 {
    static final int N = 103, H = 10010;
    static int k;
    static int[] S = new int[N], f = new int[H];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            S[i] = Integer.parseInt(s[i]);
        }
        int n = Integer.parseInt(in.readLine());
        s = in.readLine().split(" ");

        Arrays.fill(f, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(s[i]);
            res ^= sg(h);
        }
        System.out.println(res != 0 ? "Yes" : "No");
    }
    private static int sg(int x) {
        if (f[x] != -1) return f[x];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (x >= S[i]) set.add(sg(x - S[i]));
        }
        // mex
        for (int i = 0; ; i++) {
            if (!set.contains(i)) return f[x] = i;
        }
    }
}
