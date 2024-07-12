package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 台阶Nim游戏
public class AcWing892 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res ^= Integer.parseInt(s[i]);
        }
        System.out.println(res != 0 ? "Yes" : "No");
    }
}
