package Greed;

import java.io.*;
// 最长上升子序列Ⅱ
public class AcWing896 {
    static final int N = 100010;
    // q[i]维护长度为i的上升子序列的序列末位最小值
    static int[] q = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");

        int len = 0;
        q[0] = -0x3f3f;
        // 二分查找比a[i]小的最大的数，即a[i]要放入的位置
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(s[i]);

            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] >= a) r = mid - 1;
                else l = mid;
            }
            if (r == len) len += 1; // a[i]是否比q中所有数都大
            q[r + 1] = a;
        }

        System.out.println(len);
    }
}
