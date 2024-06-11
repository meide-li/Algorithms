package DataStructure;

import java.io.*;
import java.util.*;
// 堆
public class AcWing839 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            int idx = 0;
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                switch (s[0]) {
                    case "I":
                        int x = Integer.parseInt(s[1]);
                        heap.offer(x);
                        map.put(++idx, x);
                        break;
                    case "PM":
                        out.write(heap.peek() + "\n");
                        break;
                    case "DM":
                        heap.poll();
                        break;
                    case "D":
                        int k = Integer.parseInt(s[1]);
                        heap.remove(map.get(k));
                        break;
                    case "C":
                        k = Integer.parseInt(s[1]);
                        x = Integer.parseInt(s[2]);
                        heap.remove(map.get(k));
                        heap.offer(x);
                        map.put(k, x);
                        break;
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}