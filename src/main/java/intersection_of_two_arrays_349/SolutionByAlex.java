package intersection_of_two_arrays_349;


import java.util.HashSet;
import java.util.Set;

public class SolutionByAlex {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int j:nums2){
            if(set.contains(j)){
                result.add(j);
            }
        }
        int[] arr  = new int[result.size()];
        int index =0;
        for(Integer num:result){
            arr[index] = num;
            index++;
        }
        return  arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1,nums2);
        for(int num:result){
            System.out.println(num);
        }
    }
}
