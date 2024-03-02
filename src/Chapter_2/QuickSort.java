package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/30  22:37
 */
public class QuickSort {
    static int[] arr;

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int start, int end) {
        if (start >= end) return;
        int mid = arr[start];
        int left = start, right = end;
        while (left < right) {
            while (arr[right] >= mid && left < right) right--;
            while (arr[left] <= mid && left < right) left++;
            swap(left, right);
        }
        swap(start, left);
        quickSort(start, left - 1);
        quickSort(left + 1, end);
    }
    public static void main(String[] args) {
        arr = new int[]{1, 2, 4, 3, 2};
        quickSort(0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
