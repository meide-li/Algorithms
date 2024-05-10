package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 快速排序
public class AcWing785 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(in.readLine());
            int[] arr = new int[n];
            String[] s = in.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            quickSort(arr, 0, n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void quickSort(int[] arr, int left, int right){
        if (left >= right) return;
        int i = left - 1, j = right + 1, mid = arr[left + right >> 1];
        while (i < j){
            while (arr[++i] < mid);
            while (arr[--j] > mid);
            if (i < j) swap(arr, i, j);
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
