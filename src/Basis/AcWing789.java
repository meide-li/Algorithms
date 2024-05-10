package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 数的范围
public class AcWing789 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < q; i++) {
                int target = Integer.parseInt(in.readLine());
                int l = LBS(arr, n, target);
                if (arr[l] != target) System.out.println("-1 -1");
                else {
                    int r = RBS(arr, n, target);
                    System.out.println(l + " " + r);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int LBS(int[] arr, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int RBS(int[] arr, int n, int target) {
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
