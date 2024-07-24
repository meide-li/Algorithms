package Basis;

import java.io.*;
import java.util.Arrays;
// 第k小的数——快速排序
public class AcWing786 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(quickSelect(0, n - 1, k));
    }

    private static int quickSelect(int l, int r, int k) {
        if (l >= r) return arr[k - 1];
        int i = l - 1, j = r + 1, mid = arr[l + r >> 1];
        while (i < j) {
            while (arr[++i] < mid);
            while (arr[--j] > mid);
            if (i < j) swap(i, j);
        }
        if (j + 1 >= k) return quickSelect(l, j, k);
        else return quickSelect(j + 1, r, k);
    }

    private static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}