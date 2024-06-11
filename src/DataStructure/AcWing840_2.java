package DataStructure;

import java.io.*;
import java.util.Arrays;

// 散列表——开放寻址法
public class AcWing840_2 {
    static final int N = 200010;
    static int[] h = new int[N];
    static final int NULL = Integer.MAX_VALUE;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Arrays.fill(h, NULL);
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int num = Integer.parseInt(s[1]);
                int k = find(num);
                if (s[0].equals("I")) h[k] = num;
                else out.write(h[k] == num ? "Yes\n" : "No\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int find(int x) {
        int k = (x % N + N) % N;
        while (h[k] != NULL && h[k] != x) {
            k++;
            if (k == N) k = 0;
        }
        return k;
    }
}
