package DataStructure;

import java.io.*;
// 字符串哈希方法
public class AcWing831_2 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            char[] p = (" " + in.readLine()).toCharArray();
            int m = Integer.parseInt(in.readLine());
            char[] s = (" " + in.readLine()).toCharArray();
            long[] k = new long[m + 10], hs = new long[m + 10];
            long hp = 0;
            int K = 131;
            k[0] = 1;
            for (int i = 1; i <= m; i++) {
                k[i] = k[i - 1] * K;
                hs[i] = hs[i - 1] * K + s[i];
                if (i <= n) hp = hp * K + p[i];
            }
            for (int i = 0; i <= m - n; i++) {
                if ((hs[i + n] - hs[i] * k[n]) == hp) out.write(i + " ");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}