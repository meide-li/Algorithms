package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 功能描述
 *
 * @author 古月
 * @date 2024/05/02  20:14
 */
public class AcWing787 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            mergeSort(arr, 0, n - 1);
            for (int i : arr) {
                System.out.print(i + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int i = left, j= mid + 1, k = 0;
        int[] temp =new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left, j = 0; i <= right; i++, j++) {
            arr[i] = temp[j];
        }
    }

}
