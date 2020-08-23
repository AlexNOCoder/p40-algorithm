package median_of_two_sorted_arrays_4;

/**
   * @author luoyuntian
   * @date 2020-08-23 12:59
   * @description 第一道 leetcode hard
   */
public class SolutionByAlex {
    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double result  = 0;
        int flag = 1;
        if(total % 2 ==0){
            //todo 偶数，两个
            int num1 = total/2;
            int num2 = total/2 +1;
            double tempResult1 = Integer.MIN_VALUE;
            double tempResult2 = Integer.MIN_VALUE;
            for(int i=0,j=0;i<= nums1.length && j<= nums2.length;){
                //处理一个数组已经遍历完成情况
                if(i >= nums1.length){
                    //nums1遍历结束，取nums2
                    if(flag == num1){
                        tempResult1 = nums2[j];
                    }
                    if(flag == num2){
                        tempResult2 = nums2[j];
                        break;
                    }
                    j++;
                    flag++;
                }else if(j >= nums2.length){
                    //nums2遍历结束,取nums1
                    if(flag == num1){
                        tempResult1 = nums1[i];
                    }
                    if(flag == num2){
                        tempResult2 = nums1[i];
                        break;
                    }
                    i++;
                    flag++;
                }else {
                    if(nums1[i] >= nums2[j]){
                        //nums1大于等于nums2,取nums2
                        if(flag == num1){
                            tempResult1 = nums2[j];
                        }
                        if(flag == num2){
                            tempResult2 = nums2[j];
                            break;
                        }
                        j++;
                    }else {
                        //nums1小于nums2,取nums1
                        if(flag == num1){
                            tempResult1 = nums1[i];
                        }
                        if(flag == num2){
                            tempResult2 = nums1[i];
                            break;
                        }
                        i++;
                    }
                    flag ++;
                }
                }
            result = (tempResult1 + tempResult2)/2;
        }else {
            //todo 奇数，中间值
            int num = total/2 +1;
            for(int i=0,j=0;i<=nums1.length && j<=nums2.length;){
                //处理一个数组已经遍历完成情况
                if(i >= nums1.length){
                    //nums1遍历结束，取nums2
                    if(flag == num){
                        result = nums2[j];
                        break;
                    }
                    j++;
                    flag++;
                }else if(j >= nums2.length){
                    //nums1小于nums2,取nums1
                    if(flag == num){
                        result = nums1[i];
                        break;
                    }
                    i++;
                    flag++;
                }else{
                    if(nums1[i] >= nums2[j]){
                        //nums1大于等于nums2,取nums2
                        if(flag == num){
                            result = nums2[j];
                            break;
                        }
                        j++;
                    }else {
                        //nums1小于nums2,取nums1
                        if(flag == num){
                            result = nums1[i];
                            break;
                        }
                        i++;
                    }
                    flag ++;
                }
            }
        }

        return result;

    }

}

