package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2024/05/02  21:25
 */
public class AcWing789 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < q; i++) {
                int k = Integer.parseInt(in.readLine());
                int l = LBS(arr, 0, n - 1, k);
                int r = RBS(arr, 0, n - 1, k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int LBS(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + right >> 1;
            if (arr[mid] >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int RBS(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (arr[mid] <= k) left = mid;
            else right = mid - 1;
        }
        return right;
    }

}
