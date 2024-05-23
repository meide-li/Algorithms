package DataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
// 单调栈
public class AcWing830 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            int[] a = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Deque<Integer> stk = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && stk.peekLast() >= a[i]) stk.pollLast();
                out.write(stk.isEmpty() ? -1 + " " : stk.peekLast() + " ");
                stk.offer(a[i]);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}