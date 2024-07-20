package Greed;

import java.io.*;
import java.util.Arrays;
/*
可以把这个问题想象成活动安排问题
有若干个活动，同一间教室安排的活动之间不能交叠，求要安排所有活动，至少需要几间教室？

我们可以把所有开始时间和结束时间排序，遇到开始时间就把需要的教室加1，遇到结束时间就把需要的教室减1；
在一系列需要的教室个数变化的过程中，峰值就是最多同时进行的活动数，也就是我们至少需要的教室数。
*/
public class AcWing904_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = new int[2 * n];
        int idx = 0;
        while (idx < 2 * n) {
            String[] s = in.readLine().split(" ");
            a[idx++] = Integer.parseInt(s[0]) * 2;  // 标记开始时间为偶数
            a[idx++] = Integer.parseInt(s[1]) * 2 + 1;  // 结束时间为奇数
        }
        Arrays.sort(a);

        int res = 0, t = 0;
        for (int i = 0; i < 2 * n; i++) {
            if ((a[i] & 1) == 0) t++;
            else t--;
            res = Math.max(res, t);
        }
        System.out.println(res);
    }
}
