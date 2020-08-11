package remove_duplicates_from_sorted_array_26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionByAlex {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {1,2,2};
//        System.out.println(removeDuplicates(nums));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }

    public static int removeDuplicates(int[] nums) {
        int result =  nums.length;
        for(int i=0,j=1;j<nums.length;){
            while(nums[i] == nums[j]){
                //结尾有重复情况处理
                if(j == nums.length-1){
                    return i +1;
                }
                j++;
                //有重复，减一
                result--;
            }
            //非重复数字前移
            nums[i+1] = nums[j];
            i++;
            j++;
        }
        return result;
    }
}
