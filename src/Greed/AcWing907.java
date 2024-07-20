package Greed;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
// 区间覆盖
public class AcWing907 {
    static int n, start, end;
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
        n = Integer.parseInt(in.readLine());
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            a[i][0] = Integer.parseInt(s[0]);
            a[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        System.out.println(cover());
    }

    private static int cover() {
        int i = 0, res = 0;
        while (i < n) {
            int t = -0x3f3f3f3f;
            while (i < n && a[i][0] <= start) {
                t = Math.max(t, a[i][1]);
                i++;
            }
            if (t < start) return -1;
            start = t;
            res++;
            if (t >= end) return res;
        }
        return -1;
    }
}
