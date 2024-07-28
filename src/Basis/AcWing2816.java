package Basis;

import java.io.*;
import java.util.Arrays;
// 判断子序列
public class AcWing2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int i = 0;
        for (int j = 0; j < m; j++) {
            if (i < n && a[i] == b[j]) i++;
        }

//        另一种写法
//        int i = 0, j = 0;
//        for (; i < n; i++, j++) {
//            while (j < m && b[j] != a[i]) j++;
//            if (j >= m) break;
//        }

        if (i == n) System.out.println("Yes");  //注意这里是 i==n而不是n-1，因为最后判断成功还会i++一次
        else System.out.println("No");
    }
}
