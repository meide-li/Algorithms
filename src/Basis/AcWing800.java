package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 数组元素的目标和——哈希表法
public class AcWing800 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int[] A = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(x - A[i], i);
            }
            for (int i = 0; i < m; i++) {
                if (map.containsKey(B[i])) {
                    System.out.println(map.get(B[i]) + " " + i);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}