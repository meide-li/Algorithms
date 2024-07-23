package Others;

import java.io.*;
import java.util.Arrays;
// 移动石子
public class AcWing3769 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int[] a = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int res = a[0], j = 1;
            while (j < n && d - j * a[j] >= 0) {
                res += a[j];
                d -= j * a[j];
                j++;
            }
            if (j < n && d > 0) res += d / j;

            System.out.println(res);
        }
    }
}
