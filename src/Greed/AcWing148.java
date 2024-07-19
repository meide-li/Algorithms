package Greed;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
// 合并果子——Huffman树
public class AcWing148 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.add(a[i]);
        }
        int res = 0;
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            res += x + y;
            heap.add(x + y);
        }
        System.out.println(res);
    }
}
