package Math;

import java.io.*;
// 欧拉函数
public class AcWing873 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(in.readLine());
                out.write(phi(a) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int phi(int x) {
        int res = x;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                res = res / i * (i - 1);
                while (x % i == 0) x /= i;
            }
        }
        if (x != 1) res = res / x * (x - 1);
        return res;
    }
}
