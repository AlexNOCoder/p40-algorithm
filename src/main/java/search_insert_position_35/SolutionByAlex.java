package search_insert_position_35;

public class SolutionByAlex {

    public static int searchInsert(int[] nums, int target) {
        int result = binarySearch(nums,0,nums.length -1,target);
        if(result != -1){
            return result;
        }else{
            return findTheNearLessNum(nums,target);
        }
    }

    public static int binarySearch(int[] nums,int start,int end,int target){
        //在数组中返回坐标，不在返回-1
        //条件判断大于或等于
        if(start >= end){
            //相遇的一个是目标值
            if(nums[start] == target){
                return  start;
            }else {
                return -1;
            }
        }
        int medium = (start + end)/2;
        if(nums[medium] == target){
            return medium;
        }else if(nums[medium] < target){
            if(medium < nums.length-1){
                return  binarySearch(nums,medium+1,end,target);
            }else{
                return -1;
            }

        }else{
            if(medium > 0){
                return  binarySearch(nums,start,medium-1,target);
            }else{
                return -1;
            }
        }
    }

    public static  int findTheNearLessNum(int[] nums,int target){
        //不在数组中，找到插入位置
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length-1] < target){
            return  nums.length;
        }

        for(int i = 0,j = 1;i < nums.length && j < nums.length;i++,j++){
            if(nums[i]<target && nums[j]>target){
                return j;
            }
        }
        return  -1;
    }

}
