package DataStructure;

import java.io.*;

public class AcWing837 {
    static final int N = 100010;
    static int[] p = new int[N];
    static int[] size = new int[N];
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) {
                p[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int a = Integer.parseInt(s[1]);
                int b = 0;
                if (s.length == 3) b = Integer.parseInt(s[2]);
                switch (s[0]) {
                    case "C":
                        if (find(a) != find(b)) {
                            size[find(b)] += size[find(a)];
                            p[find(a)] = find(b);
                        }
                        break;
                    case "Q1":
                        out.write(find(a) == find(b) ? "Yes\n" : "No\n");
                        break;
                    case "Q2":
                        out.write(size[find(a)] + "\n");
                        break;
                }
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
