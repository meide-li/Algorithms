package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/22  11:33
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int media = (left + right) / 2;
            if (nums[media] == target) return media;
            else if (nums[media] > target) right = media - 1;
            else left = media + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-6, -5, -2, 0, 1, 4, 6, 8, 9};
        int index = binarySearch(nums, 3);
        System.out.println(index);
    }
}
