package DataStructure;

import java.io.*;
import java.util.Arrays;
// 单调队列——滑动窗口
public class AcWing154 {
    static final int N = 1000010;
    // 数组 q 保存滑动窗口处理后的严格单调队列元素的下标
    static int[] q = new int[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] a = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int tt = -1, hh = 0;
            for (int i = 0; i < n; i++) {
                if (hh <= tt && i - q[hh] + 1 > k) hh++;
                while (hh <= tt && a[q[tt]] >= a[i]) tt--;
                q[++tt] = i;
                if (i >= k - 1) out.write(a[q[hh]] + " ");
            }
            out.newLine();
            tt = -1; hh = 0;
            for (int i = 0; i < n; i++) {
                if (hh <= tt && i - q[hh] + 1 > k) hh++;
                while (hh <= tt && a[q[tt]] <= a[i]) tt--;
                q[++tt] = i;
                if (i >= k - 1) out.write(a[q[hh]] + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}