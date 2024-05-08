package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 区间合并
public class AcWing803 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int l = Integer.parseInt(s[0]);
                int r = Integer.parseInt(s[1]);
                a[i][0] = l; a[i][1] = r;
            }
            // Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
            Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
            int r = a[0][1];
            int res = 1;
            for (int i = 1; i < n; i++) {
                if (a[i][0] <= r) r = Math.max(r, a[i][1]);
                else {
                    r = a[i][1];
                    res++;
                }
            }
            // 事实上，可以进一步化简
//            for(int i = 1; i < n; i++){
//                if(r < a[i][0]) res++;
//                r = Math.max(a[i][1], r);
//            }

            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}