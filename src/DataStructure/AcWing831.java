package DataStructure;

import java.io.*;
// KMP
public class AcWing831 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            char[] p = (" " + in.readLine()).toCharArray();
            int m = Integer.parseInt(in.readLine());
            char[] s = (" " + in.readLine()).toCharArray();
            int[] ne = new int[n + 1];
            for (int i = 2, j = 0; i <= n; i++) {
                while(j != 0 && p[i] != p[j + 1]) j = ne[j];
                if (p[i] == p[j + 1]) j++;
                ne[i] = j;
            }
            for (int i = 1, j = 0; i <= m; i++) {
                while (j != 0 && s[i] != p[j + 1]) j = ne[j];
                if (s[i] == p[j + 1]) j++;
                if (j == n) {
                    j = ne[j];
                    out.write(i - n + " ");
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}