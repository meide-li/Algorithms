package DataStructure;

import java.io.*;

public class AcWing838 {
    static final int N = 100010;
    static int[] heap = new int[N];
    static int size;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            size = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            // 初始化
            s = in.readLine().split(" ");
            for (int i = 1; i <= size; i++) heap[i] = Integer.parseInt(s[i - 1]);
            // 建堆
            for(int i = size / 2; i > 0; i--) down(i);
            // 输出
            for (int i = 0; i < m; i++) {
                out.write(heap[1] + " ");
                heap[1] = heap[size--];
                down(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void down(int u) {
        int t = u;
        if (u * 2 <= size && heap[t] > heap[u * 2]) t = u * 2;
        if (u * 2 + 1 <= size && heap[t] > heap[u * 2 + 1]) t = u * 2 + 1;
        if (t != u) {
            swap(t, u);
            down(t);
        }
    }
    private static void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }
}
