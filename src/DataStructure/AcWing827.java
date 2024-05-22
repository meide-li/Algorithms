package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 双链表
public class AcWing827 {
    static final int N = 100010;
    static int[] e = new int[N];    //数据数组
    static int[] l = new int[N];    //左指针
    static int[] r = new int[N];    //右指针
    static int idx; // 当前节点
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(in.readLine());
            int head = 0, tail = N - 1;
            r[head] = tail; l[tail] = head;
            idx = 1;
            for (int i = 0; i < m; i++) {
                String[] s = in.readLine().split(" ");
                if ("D".equals(s[0])) {
                    int k = Integer.parseInt(s[1]);
                    remove(k);
                } else if ("L".equals(s[0])) {
                    int x = Integer.parseInt(s[1]);
                    insert(head, x);
                } else if ("R".equals(s[0])) {
                    int x = Integer.parseInt(s[1]);
                    insert(l[tail], x);
                } else if ("IL".equals(s[0])) {
                    int k = Integer.parseInt(s[1]);
                    int x = Integer.parseInt(s[2]);
                    insert(l[k], x);
                } else if ("IR".equals(s[0])) {
                    int k = Integer.parseInt(s[1]);
                    int x = Integer.parseInt(s[2]);
                    insert(k, x);
                }
            }

            int flag = r[0];
            while (flag != tail) {     // 指向右端点时结束
                System.out.print(e[flag] + " ");
                flag = r[flag];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 在节点k的右边插入一个数x
    private static void insert (int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx ++;
    }
    private static void remove (int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

}
