package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 第k小的数
public class AcWing786 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(quickSelect(arr, 0, n - 1, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left >= right) return arr[left];
        int i = left - 1, j = right + 1, mid = arr[left + right >> 1];
        while (i < j) {
            while (arr[++i] < mid);
            while (arr[--j] > mid);
            if (i < j) swap(arr, i, j);
        }
        // k从1开始
        // 如果第 k 个数字在 j 的左边就递归左边
        // 否则递归右边
        // 这样可以把时间复杂度优化为  O(n)
        if (k - 1 <= j) return quickSelect(arr, left, j, k);
        else return quickSelect(arr, j + 1, right, k);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}