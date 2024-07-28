package Basis;

import java.io.*;
import java.util.Arrays;
// 数组元素的目标和——双指针法
public class AcWing800_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int[] A = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0, j = m - 1; i < n; i++) {
            while (A[i] + B[j] > x) j--;
            if (A[i] + B[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}