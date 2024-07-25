package Basis;

import java.io.*;
import java.util.Arrays;
// 数的范围
public class AcWing789 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < q; i++) {
            int target = Integer.parseInt(in.readLine());
            int l = LBS(n, target);
            if (arr[l] != target) System.out.println("-1 -1");
            else {
                int r = RBS(n, target);
                System.out.println(l + " " + r);
            }
        }

    }

    private static int LBS(int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int RBS(int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (arr[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return right;
    }
}
