package suanfa.sort;

import java.util.Arrays;

/**
 * @author wubin
 * @Description 三数取中的快排
 * @project Learn-develop
 * @package suanfa.sort
 * @email wubin326@qq.com
 * @date 2019/03/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/02        wubin            0.0.1
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 6, 6, 1, 8, 9, 3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            //获取中间值(放在整个数组的末尾)用来作比较
            getMidNum(nums, left, right);
            //保存比较值的下标
            int privot = right - 1;
            int i = left, j = right - 1;
            while (true) {
                //从左边第二个开始比较，第一个在获取中间值得时候就已经比较了
                while (nums[++i] < nums[privot]) {
                }
                //从右边第三个开始
                while (j > left && nums[--j] > nums[privot]) {
                }
                if (i < j) {
                    swapNum(nums, i, j);
                } else
                    break;
            }
            if (i < right) {
                swapNum(nums, i, right - 1);
            }
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        } else {
            return;
        }
    }

    private static void getMidNum(int[] nums, int left, int right) {
        int mid = (right + left) / 2;
        //如果中间值比左边值小则交换
        if (nums[left] > nums[mid]) {
            swapNum(nums, mid, left);
        }
        if (nums[left] > nums[right]) {
            swapNum(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            swapNum(nums, mid, right);
        }
        //将枢纽值放在倒数第二个
        swapNum(nums, mid, right - 1);
    }

    //将两个值进行交换
    private static void swapNum(int[] nums, int mid, int left) {
        int temp = nums[mid];
        nums[mid] = nums[left];
        nums[left] = temp;
    }
}