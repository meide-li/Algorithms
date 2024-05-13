package Basis;

import java.io.*;
// 二进制中1的个数
public class AcWing801 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(in.readLine());
            String[] s = in.readLine().split(" ");

            for(int i = 0; i < n; i++){
                int x = Integer.parseInt(s[i]);
                int res = 0;
                while(x > 0) {
                    // lowbit 操作
                    x = x - (x & -x);
                    res++;
                }
                out.write(res + " ");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
