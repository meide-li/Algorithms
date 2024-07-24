package Basis;

import java.io.*;
// 第k小的数——堆排序
public class AcWing786_2 {
    static int N = 100010;
    static int[] heap = new int[N];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            heap[i + 1] = Integer.parseInt(s[i]);
        }
        for (int i = n / 2; i > 0; i--) down(i);

        int res = -1;
        for (int i = 0; i < k; i++) {
            res = heap[1];
            heap[1] = heap[n--];
            down(1);
        }
        System.out.println(res);
    }

    private static void down(int i) {
        int t = i;  // 最小数的下标
        if (i * 2 <= n && heap[t] > heap[i * 2]) t = i * 2;
        if (i * 2 + 1 <= n && heap[t] > heap[i * 2 + 1]) t = i * 2 + 1;
        if (t != i) {
            swap(t, i);
            down(t);
        }
    }

    private static void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}
