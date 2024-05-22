package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 栈
public class AcWing828 {
    static final int N = 100010;
    static int[] stk = new int[N];
    static int tt = 0;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String[] s = in.readLine().split(" ");
                switch (s[0]) {
                    case "push":
                        int x = Integer.parseInt(s[1]);
                        stk[++tt] = x;
                        break;
                    case "pop":
                        tt--;
                        break;
                    case "empty":
                        if (tt > 0) System.out.println("NO");
                        else System.out.println("YES");
                        break;
                    case "query":
                        System.out.println(stk[tt]);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}