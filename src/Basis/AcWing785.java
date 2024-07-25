package Basis;

import java.io.*;
import java.util.Arrays;

// 快速排序
public class AcWing785 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int l, int r){
        if (l >= r) return;
        int i = l - 1, j = r + 1, mid = arr[l + r >> 1];
        while (i < j) {
            while (arr[++i] < mid);
            while (arr[--j] > mid);
            if (i < j) swap(i, j);
        }
        quickSort(l, j);
        quickSort(j + 1, r);
    }

    private static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
