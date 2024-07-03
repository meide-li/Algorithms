package Math;

import java.io.*;
// 快速幂
public class AcWing875 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = in.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int p = Integer.parseInt(s[2]);
                out.write(qmi(a, b, p) + "\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int qmi(int a, int b, int p) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = (int) ((long) res * a % p);
            a =(int) ((long) a * a % p);
            b >>= 1;
        }
        return res;
    }
}
