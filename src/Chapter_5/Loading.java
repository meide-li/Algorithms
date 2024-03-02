package Chapter_5;

public class Loading {
    //类数据成员
    static int n;       //集装箱数量
    static int[] w;     //集装箱重量数组
    static int c;       //第一艘轮船的载重量
    static int cw;      //当前载重量
    static int bestw;   //当前最优载重量
    static int r;       //剩余集装箱重量
    static int[] x;     //当前解
    static int[] bestx; //当前最优解

    //回溯算法
    private static void backtrack(int i) {//搜索第i层
        if (i >= n) {           //到达叶节点，已搜索完
            if (cw > bestw){
                bestw = cw;
                for (int j = 0; j < n; j++) bestx[j] = x[j];
            }
            return;
        }
        //搜索子树
        r -= w[i];
        if (cw + w[i] <= c) {
            //搜索左子树
            x[i] = 1;
            cw += w[i];
            backtrack(i + 1);//递归调用
            cw -= w[i];
        }
        if (cw + r > bestw) {
            //搜索右子树
            x[i] = 0;
            backtrack(i + 1);
        }
        r += w[i];
    }

    public static void main(String[] args) {
        w = new int[] {8, 1, 3};
        n = w.length;
        c = 10;
        cw = 0;
        bestw = 0;
        x = new int[n];
        bestx = new int[n];
        for (int i = 0; i < n; i++) {
            r += w[i];
        }

        backtrack(0);
        System.out.println(bestw);
        for (int i = 0; i < n; i++) {
            System.out.print(bestx[i]);
        }
    }
}