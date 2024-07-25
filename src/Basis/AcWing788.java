package Basis;

import java.io.*;
import java.util.Arrays;
// 逆序对的数量
public class AcWing788 {
    static int[] arr;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        mergeSort(0, n - 1);
        System.out.println(res);
    }

    private static void mergeSort(int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        int[] t = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) t[k++] = arr[i++];
            else {
                t[k++] = arr[j++];
                res += mid - i + 1;
            }
        }
        
        while (i <= mid) t[k++] = arr[i++];
        while (j <= r) t[k++] = arr[j++];
        for (i = l, j = 0; j < k; i++, j++) {
            arr[i] = t[j];
        }
    }
}