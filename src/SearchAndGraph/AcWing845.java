package SearchAndGraph;

import java.util.*;
// 八数码
public class AcWing845 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = "";
        for (int i = 0; i < 9; i++) {
            start += scanner.next();
        }
        System.out.println(bfs(start));
    }

    private static int bfs(String start) {
        String end = "12345678x";

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dis = new HashMap<>();
        q.offer(start);
        dis.put(start, 0);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(end)) return dis.get(cur);   // 找到答案

            int index = cur.indexOf('x');
            int x = index / 3, y = index % 3;   // 二维化坐标
            for (int i = 0; i < 4; i++) {       // 探索可行路径
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {   // 若合法
                    String ne = swapChars(cur, index, 3 * a + b);   // 新状态
                    if (!dis.containsKey(ne)) {     // 没走过
                        q.offer(ne);
                        dis.put(ne, dis.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }
    public static String swapChars(String str, int a, int b) {
        char[] c = str.toCharArray();
        char t = c[a];
        c[a] = c[b];
        c[b] = t;
        return new String(c);
    }
}