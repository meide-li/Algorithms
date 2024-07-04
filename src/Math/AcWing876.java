package Math;

import java.io.*;
// 快速幂求逆元
public class AcWing876 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int p = Integer.parseInt(s[1]);
                out.write(a % p == 0 ? "impossible\n" : qmi(a, p) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int qmi(int a, int p) {
        // a^(p-2) % p
        int res = 1;
        int m = p - 2;
        while (m != 0) {
            if ((m & 1) != 0) res = (int) ((long) res * a % p);
            a = (int) ((long) a * a % p);
            m >>= 1;
        }
        return res;
    }
}
