package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 逆序对的数量
public class AcWing788 {
    static long result = 0;
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            mergeSort(arr, 0, n - 1);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                result += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (i = l, j = 0; i <= r ; i++, j++) {
            arr[i] = temp[j];
        }
    }
}