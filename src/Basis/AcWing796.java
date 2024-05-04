package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing796 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int q = Integer.parseInt(s[2]);
            int[][] a = new int[n + 1][m + 1];
            int[][] b = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                s = in.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    a[i][j] = Integer.parseInt(s[j - 1]);
                    b[i][j] = b[i][j - 1] + b[i - 1][j] - b[i - 1][j - 1] + a[i][j];
                }
            }

            for (int i = 0; i < q; i++) {
                s = in.readLine().split(" ");
                int x1 = Integer.parseInt(s[0]);
                int y1 = Integer.parseInt(s[1]);
                int x2 = Integer.parseInt(s[2]);
                int y2 = Integer.parseInt(s[3]);
                System.out.println(b[x2][y2] - b[x1 - 1][y2] - b[x2][y1 - 1] + b[x1 - 1][y1 - 1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}