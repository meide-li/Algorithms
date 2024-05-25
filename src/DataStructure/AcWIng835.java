package DataStructure;

import java.io.*;
// trie字符串统计
public class AcWIng835 {
    static final int N = 100010;
    static int[][] son = new int[N][26];
    static int[] cnt = new int[N];
    static int idx = 0;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                if (s[0].equals("I")) insert(s[1]);
                if (s[0].equals("Q")) out.write(query(s[1]) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p] ++;
    }

    private static int query(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
}
