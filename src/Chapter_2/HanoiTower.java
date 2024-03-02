package Chapter_2; /**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/22  9:59
 */

import java.util.ArrayList;

public class HanoiTower {
    //a为初始，b为目标，c为临时中转
    public static void move(int n, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c){
        if (n  > 0) {
            move(n-1, a, c, b);
            b.add(a.get(a.size() - 1));
            a.remove(a.size() - 1);
            move(n-1, c, b, a);
        }
    }
    public static ArrayList<Integer> hanoi(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c){
        int n = a.size();
        move(n, a, b, c);
        return b;
    }

    public static void main(String[] args) {
        ArrayList<Integer> orgin = new ArrayList<>();
        orgin.add(1);
        orgin.add(2);
        orgin.add(3);
        orgin.add(4);
        ArrayList<Integer> target = hanoi(orgin, new ArrayList<>(), new ArrayList<>());
        System.out.println(target.toString());
    }
}
