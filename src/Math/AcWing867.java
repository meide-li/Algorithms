package Math;

import java.io.*;
// 分解质因数
public class AcWing867 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(in.readLine());
                for (int j = 2; j <= a / j; j++) {
                    if (a % j == 0) {
                        int s = 0;
                        while (a % j == 0) {
                            a /= j;
                            s++;
                        }
                        out.write(j + " " + s + "\n");
                    }
                }
                if (a > 1) out.write(a + " 1\n");
                out.newLine();
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
