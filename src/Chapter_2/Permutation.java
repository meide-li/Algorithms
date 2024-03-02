package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/19  20:04
 */
public class Permutation {
    public static  void swap(Object[] list, int index1, int index2){
        Object temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public static void perm(Object[] list, int i){
        int l = list.length;
        if (i == l-1){
            for (int j = 0; j < l; j++) {
                System.out.print(list[j]);
            }
            System.out.println();
        }else {
            for (int j = i; j < l; j++) {
                swap(list, j, i);
                perm(list, i+1);
                swap(list, j ,i);
            }
        }
    }

    public static void main(String[] args) {
        Object[] list = {1, 2, 3};
        perm(list, 0);
    }
}
