package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/20  11:26
 */
public class IntegerDivision {
    public static int q(int n, int m){
        if((n == 1) || (m == 1)) return 1;
        if (m > n) return q(n, n);
        if (n == m) return q(n, m-1) + 1;
        //n>m时分为：1.最大划分数为m，其余还有n-m个数；2.最大划分数没到m
        return q(n-m, m) + q(n, m-1);
    }

    public static void main(String[] args) {
        System.out.println(q(5,6));
    }
}
