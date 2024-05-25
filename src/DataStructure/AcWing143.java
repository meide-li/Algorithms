package DataStructure;

import java.io.*;
import java.util.Arrays;

public class AcWing143 {
    static final int N = 100010;
    static int[][] son = new int[31 * N][2];
    static int idx = 0;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int res = 0;
            for (int i = 0; i < n; i++) {
                insert(arr[i]);
                res = Math.max(res, query(arr[i]));
            }
            System.out.print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(int num) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = num >> i & 1;   // num第i位数字
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }

    private static int query(int num) {
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = num >> i & 1;
            // 当前层取反位存在
            if (son[p][u^1] != 0) {
                p = son[p][u^1];
                res += 1 << i;
            }
            else p = son[p][u];
        }
        return res;
    }
}
