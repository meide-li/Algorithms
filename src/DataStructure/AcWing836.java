package DataStructure;

import java.io.*;
// 并查集
public class AcWing836 {
    static final int N = 100010;
    static int[] p = new int[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);
                if (s[0].equals("M")) p[find(a)] = find(b);
                else if (s[0].equals("Q")) out.write(find(a) == find(b) ? "Yes\n" : "No\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int find (int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}