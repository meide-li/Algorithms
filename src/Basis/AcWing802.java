package Basis;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 区间和
public class AcWing802 {
    final static int N = 3 * 100010;
    static List<Integer> alls = new ArrayList<>();    // 所有操作的下标
    static int[] a = new int[N];    // 离散化后的数组
    static int[] q = new int[N];    // a的前缀和


    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] add = new int[n][2];
            int[][] query = new int[m][2];
            for (int i = 0; i < n; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int c = Integer.parseInt(s[1]);
                add[i][0] = x;
                add[i][1] = c;
                alls.add(x);
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int l = Integer.parseInt(s[0]);
                int r = Integer.parseInt(s[1]);
                query[i][0] = l;
                query[i][1] = r;
                alls.add(l);
                alls.add(r);
            }
            // 去重、排序
            alls = alls.stream().distinct().sorted()
                    .collect(Collectors.toList());

//            alls = new ArrayList<>(new HashSet<>(alls));
//            Collections.sort(alls);
            // 离散化映射
            for (int[] item : add) {
                int i = Collections.binarySearch(alls, item[0]) + 1;
                a[i] += item[1];
            }
            // 前缀和
            for (int i = 1; i < N; i++) {
                q[i] = q[i - 1] + a[i];
            }

            for (int[] item : query) {
                int l = Collections.binarySearch(alls, item[0]) + 1;
                int r = Collections.binarySearch(alls, item[1]) + 1;
                System.out.println(q[r] - q[l - 1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}