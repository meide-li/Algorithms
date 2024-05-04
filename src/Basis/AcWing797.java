package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing797 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] b = new int[n + 2];
            s = in.readLine().split(" ");
            // b初始化
            for (int i = 1; i <= n; i++) {
                int c = Integer.parseInt(s[i - 1]);
                insert(b, i, i, c);
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int l = Integer.parseInt(s[0]);
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                insert(b, l, r, c);
            }
            for (int i = 1; i <= n; i++) {
                b[i] += b[i - 1];
                System.out.print(b[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(int[] arr, int l, int r, int c) {
        arr[l] += c;
        arr[r + 1] -= c;
    }
}