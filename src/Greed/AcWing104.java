package Greed;

import java.io.*;
import java.util.Arrays;
// 货仓选址
public class AcWing104 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);

        int res = 0;
        int p = a[n / 2];
        for (int i = 0; i < n; i++) {
            res += Math.abs(a[i] - p);
        }
        System.out.println(res);
    }
}