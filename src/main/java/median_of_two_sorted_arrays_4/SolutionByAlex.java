package median_of_two_sorted_arrays_4;

import static com.sun.tools.javac.jvm.ByteCodes.swap;
import static kth_largest_element_in_an_array_215.SolutionByAlex.findKthLargest;

/**
   * @author luoyuntian
   * @date 2020-08-23 12:59
   * @description 第一道 leetcode hard
   */
public class SolutionByAlex {
    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={3,4};
//        System.out.println(findMedianSortedArrays2(nums1,nums2));
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

    // faster
    // 根据两个字符串长度的总和判断如何调用递归函数以及返回结果
    public  double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int k= (m+n)/2;
        // 当总长度为奇数时，返回正中央的数
        if((m+n)%2 == 1){
            return findKth(nums1,0,m-1,nums2,0,n-1,k+1);
        }else{
            // 当总长度为偶数时，返回中间两个数的平均值
            return (findKth(nums1,0,m-1,nums2,0,n-1,k) + findKth(nums1,0,m-1,nums2,0,n-1,k+1))/2.0;
        }
    }
    // 寻找第k小的元素
    public double findKth(int[] nums1,int l1,int h1,int[] nums2,int l2,int h2,int k){
        int m = h1 - l1 +1;
        int n = h2 - l2 +1;
        // 如果nums1数组的长度大于nums2数组的长度
        // 将二者互换，加快程序结束
        if(m > n){
          return findKth(nums2,l2,h2,nums1,l1,h1,k);
        }
        // 当nums1数组长度为0时，
        // 直接返回nums2数组的第k小的数
        if(m == 0){
            return nums2[l2+k-1];
        }
        // 当k=1时，返回两个数组中的最小值
        if(k == 1){
            return Math.min(nums1[l1],nums2[l2] );
        }
        // 分别去两个数组中的中间数
        int na = Math.min(k/2,m);
        int nb = k - na;
        int va = nums1[l1 + na -1];
        int vb = nums2[l2 + nb -1];
        // 比较下两者的大小
        // 如果相等，表明中位数已经找到，返回该值
        // 如果不等，进行剪枝处理
        if(va == vb){
         return va;
        }else if (va < vb){
            return findKth(nums1,l1+na,h1,nums2,l2,l2+nb-1,k-na);
        }else {
            return findKth(nums1,l1,l1+na-1,nums2,l2+nb,h2,k-nb);
        }
    }

   // 通过快速选择算法实现
    public  double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int k= (m+n)/2;
        return (m+n)%2 == 1?findKthLargest(nums1,nums2,k+1):(findKthLargest(nums1,nums2,k)+findKthLargest(nums1,nums2,k+1))/2.0;
    }
    public double findKthLargest(int[] nums1, int[] nums2,int k){
        return quickSelect(nums1,nums2,0,nums1.length+nums2.length-1,k);
    }

    public double quickSelect(int[] nums1, int[] nums2,int low,int high,int k){
        int pivot = low;
        for(int j=low;j<high;j++){
            if(getNum(nums1,nums2,j) <= getNum(nums1,nums2,high)){
                swap(nums1,nums2,pivot++,j);
            }
        }
        swap(nums1,nums2,pivot,high);
        int count = high - pivot +1;
        if( count == k){
            return getNum(nums1,nums2,pivot);
        }
        if(count > k){
            return quickSelect(nums1,nums2,pivot+1,high,k);
        }
        return  quickSelect(nums1,nums2,low,pivot-1,k-count);
    }
    public int getNum(int[] nums1, int[] nums2, int index){
        return (index < nums1.length) ? nums1[index] : nums2[index - nums1.length];
    }

    public void swap(int[] nums1, int[] nums2,int i,int j){
        int m = nums1.length;
        if(i < m && j < m){
            swap(nums1,i,j);
        }else if(i >= m && j>= m){
            swap(nums2,i-m,j-m);
        }else if(i < m && j>= m){
            int temp = nums1[i];
            nums1[i] = nums2[j-m];
            nums2[j-m] = temp;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

