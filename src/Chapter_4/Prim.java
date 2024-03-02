package Chapter_4;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/11/10  15:41
 */
public class Prim {
    static int INFINITY = 65535;
    public static void prim(int[][] weight){
        int n = weight.length;
        //被纳入最小生成树(MST)的顶点
        boolean[] S = new boolean[n];
        S[0] = true;
        //顶点到MST的最小距离
        int[] lowcost = new int[n];
        //顶点到MST哪个顶点距离最小
        int[] closest = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            lowcost[i] = weight[0][i];
            closest[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int min = INFINITY;
            int minNode = 0;
            //找到离MST最近的顶点
            for (int j = 1; j < n; j++) {
                if (!S[j] && lowcost[j] < min) {
                    min = lowcost[j];
                    minNode = j;
                }
            }
            //顶点加入MST
            S[minNode] = true;
            System.out.println("("+minNode+","+closest[minNode]+")");
            //更新lowcost和closet
            for (int j = 1; j < n; j++) {
                if (weight[minNode][j] < lowcost[j] && !S[j]) {
                    lowcost[j] = weight[minNode][j];
                    closest[j] = minNode;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] weight = {
                {0,10,INFINITY,INFINITY,INFINITY,11,INFINITY,INFINITY,INFINITY},
                {10,0,18,INFINITY,INFINITY,INFINITY,16,INFINITY,12},
                {INFINITY,18,0,22,INFINITY,INFINITY,INFINITY,INFINITY,8},
                {INFINITY,INFINITY,22,0,20,INFINITY,24,16,21},
                {INFINITY,INFINITY,INFINITY,20,0,26,INFINITY,7,INFINITY},
                {11,INFINITY,INFINITY,INFINITY,26,0,17,INFINITY,INFINITY},
                {INFINITY,16,INFINITY,24,INFINITY,17,0,19,INFINITY},
                {INFINITY,INFINITY,INFINITY,16,7,INFINITY,19,0,INFINITY},
                {INFINITY,12,8,21,INFINITY,INFINITY,INFINITY,INFINITY,0}
        };
        prim(weight);
    }
}
