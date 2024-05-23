package DataStructure;

import java.io.*;
// 字符串哈希
public class AcWing841 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[] chars = (" " + in.readLine()).toCharArray();
            long[] p = new long[n + 10], h = new long[n + 10];
            int P = 131;
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] * P;
                h[i] = h[i - 1] * P + chars[i];
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int l1 = Integer.parseInt(s[0]);
                int r1 = Integer.parseInt(s[1]);
                int l2 = Integer.parseInt(s[2]);
                int r2 = Integer.parseInt(s[3]);
                boolean judge = (h[r1] - h[l1 - 1] * p[r1 - l1 + 1]) == (h[r2] - h[l2 - 1] * p[r2 - l2 + 1]);
                out.write(judge ? "Yes\n" : "No\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
