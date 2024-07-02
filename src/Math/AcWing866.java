package Math;

import java.io.*;
// 试除法判定质数
public class AcWing866 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(in.readLine());
                out.write(isPrime(a) ? "Yes\n" : "No\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
