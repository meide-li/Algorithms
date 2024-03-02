package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/10/01  22:27
 */

import java.util.Random;
public class RandomizedSelect {
    private static int[] arr;
    private static Random random = new Random();

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int random(int a, int b) {
        int randomNumber = random.nextInt(b - a + 1) + a;
        return randomNumber;
    }


    //快速排序中随机化分区方法,返回分区基准下标
    private static int randomizedPartition(int start, int end) {
        if (start >= end) return start;
        //随机生成基准数字初始下标
        int standard = random(start, end);
        swap(start, standard);

        int mid = arr[start];
        int left = start, right = end;
        while (left < right) {
            while (arr[right] >= mid && left < right) right--;
            while (arr[left] <= mid && left < right) left++;
            swap(left, right);
        }
        swap(start, left);

        return left;
    }

    //选择第k小的数
    private static int randomizedSelect(int start, int end, int k) {
        if (start == end) return arr[start];
        int index = randomizedPartition(start, end),
        //左半部分数字个数
        left_count = index - start + 1;
        if (k <= left_count) return randomizedSelect(start, index, k);
        else return randomizedSelect(index + 1, end, k - left_count);
    }

    public static void main(String[] args) {
        arr = new int[]{6, 2, 9, 0, 2, 4};
        int result = randomizedSelect(0, arr.length - 1, 4);
        System.out.println(result);
    }
}
