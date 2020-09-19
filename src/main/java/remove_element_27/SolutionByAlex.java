package remove_element_27;



public class SolutionByAlex {
    public static int removeElement(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans;) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(removeElement(nums,1));
        System.out.println(nums.toString());
    }
}
