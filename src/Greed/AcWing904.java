package Greed;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// 区间分组
public class AcWing904 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            a[i][0] = Integer.parseInt(s[0]);
            a[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(a[0][1]);
        for (int i = 1; i < n; i++) {
            if (heap.peek() < a[i][0]) heap.poll();
            heap.add(a[i][1]);
        }
        System.out.println(heap.size());
    }
}
