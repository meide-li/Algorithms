package DataStructure;

import java.io.*;
// 散列表——拉链法
public class AcWing840 {
    static final int N = 100003;
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int idx = 1;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int num = Integer.parseInt(s[1]);
                if (s[0].equals("I")) insert(num);
                else out.write(find(num) ? "Yes\n" : "No\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    private static boolean find(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != 0; i = ne[i]) {
            if (e[i] == x) return true;
        }
        return false;
    }
}
