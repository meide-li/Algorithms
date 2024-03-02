package Chapter_4;

import java.util.PriorityQueue;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/11/12  15:38
 */
public class Kruskal {
    public static class EdgeNode implements Comparable<EdgeNode> {
        int weight;
        int begin, end;

        EdgeNode(int weight, int begin, int end) {
            this.weight = weight;
            this.begin = begin;
            this.end = end;
        }
        @Override
        public int compareTo(EdgeNode o) {
            return this.weight - o.weight;
        }
    }

    public static void kruskal(int nodeNum, EdgeNode[] edges) {
        int n = edges.length;
        //并查集！！！表示节点所属的连通分支（父节点），判断是否形成环路
        int[] parents = new int[nodeNum];
        //初始化将根节点设置为自己
        for (int i = 0; i < nodeNum; i++) {
            parents[i] = i;
        }
        //初始化优先级队列
        PriorityQueue<EdgeNode> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(edges[i]);
        }

        for (int i = 0; i < n; i++) {
            EdgeNode min_edge = queue.poll();
            //判断边两端是否属于同一个连通分支
            int a = find(parents, min_edge.begin);
            int b = find(parents, min_edge.end);
            if (a != b) {
                parents[b] = a;
                System.out.println("("+min_edge.begin+","+min_edge.end+")");
            }
        }
    }

    public static int find(int[] parents, int k) {
        while (parents[k] != k) {
            k = parents[k];
        }
        return k;
    }

    public static void main(String[] args) {
        EdgeNode[] edges = new EdgeNode[15];
        edges[0] = new EdgeNode(10, 0, 1);
        edges[1] = new EdgeNode(11, 0, 5);
        edges[2] = new EdgeNode(16, 1, 6);
        edges[3] = new EdgeNode(17, 5, 6);
        edges[4] = new EdgeNode(18, 1, 2);
        edges[5] = new EdgeNode(12, 1, 8);
        edges[6] = new EdgeNode(24, 3, 6);
        edges[7] = new EdgeNode(19, 6, 7);
        edges[8] = new EdgeNode(16, 3, 7);
        edges[9] = new EdgeNode(7, 4, 7);
        edges[10] = new EdgeNode(26, 4, 5);
        edges[11] = new EdgeNode(8, 2, 8);
        edges[12] = new EdgeNode(22, 2, 3);
        edges[13] = new EdgeNode(21, 3, 8);
        edges[14] = new EdgeNode(20, 3, 4);

        //节点个数
        int nodeNum = 9;
        kruskal(nodeNum, edges);
    }
}
