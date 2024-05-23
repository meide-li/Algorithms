package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 队列
public class AcWing829 {
    static final int N = 100010;
    static int[] q = new int[N];
    static int hh = 0, tt = -1;
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String[] s = in.readLine().split(" ");
                if (s[0].equals("push")) q[++tt] =  Integer.parseInt(s[1]);
                if (s[0].equals("pop")) hh++;
                if (s[0].equals("empty")) System.out.println(hh > tt ? "YES" : "NO");
                if (s[0].equals("query")) System.out.println(q[hh]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}