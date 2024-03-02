package Chapter_4;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/11/09  16:07
 */
public class Dijkstra {
    static int INFINITY = 65535;

    public static void dijkstra(int v, int[][] weight, int[] dist, int[] prev){
        int n = dist.length;
        //存放已经获取最短路径的节点
        ArrayList<Integer> S = new ArrayList<>();
        //放入源节点
        S.add(v);
        //初始化dist
        for (int i = 0; i < n; i++) {
            dist[i] = weight[v][i];
            prev[i] = v;
        }

        while (S.size() < n) {
            //确定可以固定的最小值节点
            int m = nextNode(dist, S);
            S.add(m);
            //更新dist
            for (int i = 0; i < n; i++) {
                if (dist[i] > dist[m] + weight[m][i]) {
                    dist[i] = dist[m] + weight[m][i];
                    prev[i] = m;
                }
            }
        }
    }

    public static int nextNode(int[] arr, ArrayList<Integer> S) {
        int min = INFINITY;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && !S.contains(i)) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static void main(String[] args) {
        int[][] weight =
           {{0,1,5,INFINITY,INFINITY,INFINITY,INFINITY,INFINITY,INFINITY},
            {1,0,3,7,5,INFINITY,INFINITY,INFINITY,INFINITY},
            {5,3,0,INFINITY,1,7,INFINITY,INFINITY,INFINITY},
            {INFINITY,7,INFINITY,0,2,INFINITY,3,INFINITY,INFINITY},
            {INFINITY,5,1,2,0,3,6,9,INFINITY},
            {INFINITY,INFINITY,7,INFINITY,3,0,INFINITY,5,INFINITY},
            {INFINITY,INFINITY,INFINITY,3,6,INFINITY,0,2,7},
            {INFINITY,INFINITY,INFINITY,INFINITY,9,5,2,0,4},
            {INFINITY,INFINITY,INFINITY,INFINITY,INFINITY,INFINITY,7,0,4}};

        int[] dist = new int[weight.length];
        int[] prev = new int[weight.length];

        dijkstra(0, weight, dist, prev);
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
            System.out.println(prev[i]+" ");
        }
    }
}
