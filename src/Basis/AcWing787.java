package Basis;

import java.io.*;
import java.util.Arrays;
// 归并排序
public class AcWing787 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        mergeSort(0, n - 1);
        for (int i : arr) System.out.print(i + " ");
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

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
