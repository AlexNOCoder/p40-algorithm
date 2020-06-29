package kth_largest_element_in_an_array_215;

/**
 * 再次复习快排
 *
 * @author : wangcheng
 * @date : 2020年06月29日 15:49
 */
public class SolutionByCdtft {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int index = left;
        int compareValue = nums[right];
        for (int i = index; i < right; i++) {
            if (nums[i] > compareValue) {
                if (i == index) {
                    index++;
                } else {
                    int tmp = nums[index];
                    nums[index++] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        int tem = nums[index];
        nums[index] = nums[right];
        nums[right] = tem;
        return index;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        SolutionByCdtft cdtft = new SolutionByCdtft();
        System.out.println(cdtft.findKthLargest(array, 2));
    }
}
