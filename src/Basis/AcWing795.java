package Basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AcWing795 {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] a = Arrays.stream(("0 " + in.readLine()).split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] b = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                b[i] = b[i - 1] + a[i];
            }
            for (int i = 0; i < m; i++) {
                s = in.readLine().split(" ");
                int left = Integer.parseInt(s[0]);
                int right = Integer.parseInt(s[1]);
                System.out.println(b[right] - b[left - 1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
