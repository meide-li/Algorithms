package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
// 约数之和
public class AcWing871 {
    static final int MOD = (int) (1e9 + 7);
    static HashMap<Integer, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(in.readLine());
                divide(a);
            }
            long res = 1;
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int p = entry.getKey();
                int s = entry.getValue();
                long t = 1;
                for (int i = 0; i < s; i++) {
                    t = (t * p + 1) % MOD;
                }
                res = (res * t) % MOD;
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void divide(int a) {
        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                int s = 0;
                while (a % i == 0) {
                    a /= i;
                    s++;
                }
                m.put(i, m.getOrDefault(i, 0) + s);
            }
        }
        if (a != 1) m.put(a, m.getOrDefault(a, 0) + 1);
    }
}
