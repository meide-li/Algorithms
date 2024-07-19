package Greed;

import java.io.*;
import java.util.Arrays;
// 排队打水
public class AcWing913 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);


        long res = 0;
        for (int i = 1; i < n; i++) {
            res += a[i - 1] * (n - i);
        }
        System.out.println(res);
    }
}
