package how_many_apples_can_you_put_into_the_basket_1196;


//先快排，再从数量小的开始取，直到装不下为止
public class SolutionByAlex {

    public int maxNumberOfApples(int[] arr) {
        quickSort(arr,0,arr.length-1);
        int sum=0;
        int number =0;
        for(int i:arr){
            sum+=i;
            if(sum <=5000){
                number++;
            }else{
                return number;
            }
        }
        return number;
    }

    private void quickSort(int[] num, int left, int right) {
        if(left>=right) {
            return;
        }
        int key=num[left];
        int i=left;
        int j=right;
        while(i<j){
            while(num[j]>=key && i<j){
                j--;
            }
            while(num[i]<=key && i<j){
                i++;
            }
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
    }
}
