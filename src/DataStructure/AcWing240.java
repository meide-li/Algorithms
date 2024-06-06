package DataStructure;

import java.io.*;
// 食物链
@SuppressWarnings("SuspiciousNameCombination")
public class AcWing240 {
    static final int N = 100010;
    static int[] p = new int[N];
    static int[] d = new int[N];    // d[x]维护x到p[x]的距离
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) p[i] = i;
            int res = 0;
            for (int i = 0; i < k; i++) {
                s = in.readLine().split(" ");
                int x = Integer.parseInt(s[1]);
                int y = Integer.parseInt(s[2]);
                if (x > n || y > n) {
                    res++;
                    continue;
                }
                int px = find(x);
                int py = find(y);
                if (s[0].equals("1")) {
                    // x和y还未有关联，认为是真话
                    if (px != py) {
                        d[px] = d[y] - d[x];
                        p[px] = py;
                    }
                    // 假话
                    if (px == py && (d[x] - d[y]) % 3 != 0) res++;
                } else if (s[0].equals("2")) {
                    if (px != py) {
                        d[px] = d[y] - d[x] + 1;
                        p[px] = py;
                    }
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) res++;
                }
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int find (int x) {
        if (p[x] != x) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
}
