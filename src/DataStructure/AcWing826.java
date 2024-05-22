package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 单链表
public class AcWing826 {
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int head = 0;
    static int idx = 1;    // 链表从1开始
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String[] s = in.readLine().split(" ");
                switch (s[0]) {
                    case "H" -> {
                        int x = Integer.parseInt(s[1]);
                        addHead(x);
                    }
                    case "D" -> {
                        int k = Integer.parseInt(s[1]);
                        remove(k);
                    }
                    default -> {
                        int k = Integer.parseInt(s[1]);
                        int x = Integer.parseInt(s[2]);
                        add(k, x);
                    }
                }
            }
            int i = head;
            while (i != 0) {
                System.out.print(e[i] + " ");
                i = ne[i];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void remove(int k) {
        if (k == 0) head = ne[head];
        else ne[k] = ne[ne[k]];
    }

    private static void addHead (int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    private static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }
}
