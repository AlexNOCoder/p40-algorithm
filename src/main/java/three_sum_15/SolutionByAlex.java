package three_sum_15;

import java.util.List;

public class SolutionByAlex {

    public static void main(String[] args) {
        int[] test = {-2,1,-1,-1,3,0,4,-5};
        int[] result = partition(test);
        for(int i:result){
            System.out.println(i);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

    return  null;

    }

    public static int[] partition(int[] nums){
        int[] result = new int[nums.length];
        int front =0;
        int tail = nums.length -1;
        for(int i:nums){
            if(i >0){
                result[tail] = i;
                tail--;
            }
            if(i < 0){
                result[front] = i;
                front++;
            }
        }
        if(!((front+1) == tail)){
            for(int j=front+1;j<tail;j++){
                result[j] =0;
            }
        }
        return result;
    }

}
