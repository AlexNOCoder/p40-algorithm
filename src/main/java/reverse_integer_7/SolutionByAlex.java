package reverse_integer_7;

public class SolutionByAlex {
    public int reverse(int x) {
        int flag = 1;
        long temp = x;
        if(temp < 0){
            temp = 0 - temp;
            flag = 0;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(temp);
        sb.reverse();
        if(flag == 1){
            return isOverSize(Long.valueOf(sb.toString()));
        }else{
            return isOverSize(Long.valueOf("-"+sb.toString()));
        }
    }

    public int isOverSize(long i){
        if(i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)i;
        }
    }
}
