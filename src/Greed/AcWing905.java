package Greed;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
// 区间选点
public class AcWing905 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            a[i][0] = Integer.parseInt(s[0]);
            a[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        int res = 0, t = -0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            if (a[i][0] > t) {
                res++;
                t = a[i][1];
            }
        }
        System.out.println(res);
    }
}
