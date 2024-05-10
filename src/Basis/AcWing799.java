package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
// 最长连续不重复子序列
public class AcWing799 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int res = 1;
            HashMap<Integer, Integer> S = new HashMap<>();
            for (int i = 0, j = 0; i < n; i++) {
                S.put(arr[i], S.getOrDefault(arr[i], 0) + 1);
                while (j < i && S.get(arr[i]) > 1) {  // j<i其实冗余了
                    S.put(arr[j], S.get(arr[j]) - 1);
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
