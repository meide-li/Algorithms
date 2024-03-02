package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/28  22:53
 */
public class MergeSort {
    static void mergeSort(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;
        // 计算中间索引，len >> 1 相当于len/2，但更高效
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        // 递归地对数组的两半排序
        mergeSort(arr, result, start1, end1);
        mergeSort(arr, result, start2, end2);
        int k = start;
        // 将两个已排序的半部分合并到结果数组中
        while (start1 <= end1 && start2 <= end2) {
            // 关键步骤！！！如果arr[start1]小于arr[start2]，
            // 则将arr[start1]复制到结果数组的当前位置，然后增加start1和k的值。
            // 否则，将arr[start2]复制到结果数组的当前位置，然后增加start2和k的值。
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        // 将结果复制到原始数组
        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,7,1,3,9,0,4,6,7,2,4};
        int len = arr.length;
        int[] result = new int[len];
        mergeSort(arr, result, 0, len - 1);
        for (int i = 0; i < len; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
