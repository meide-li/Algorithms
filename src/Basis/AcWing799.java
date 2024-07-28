package Basis;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
// 最长连续不重复子序列
public class AcWing799 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < n; i++) {
            while (set.contains(a[i])) {
                set.remove(a[j++]);
            }
            set.add(a[i]);
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
