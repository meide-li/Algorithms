package Basis;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
// 数组元素的目标和——哈希法
public class AcWing800 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int[] A = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(x - A[i], i);
        }
        for (int i = 0; i < m; i++) {
            if (map.containsKey(B[i])) {
                System.out.println(map.get(B[i]) + " " + i);
                break;
            }
        }
    }
}