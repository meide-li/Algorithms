package Basis;

import java.io.*;
import java.util.Arrays;
// 前缀和
public class AcWing795 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] a = Arrays.stream(("0 " + in.readLine()).split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = b[i - 1] + a[i];
        }
        for (int i = 0; i < m; i++) {
            s = in.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            System.out.println(b[r] - b[l - 1]);
        }
    }
}
