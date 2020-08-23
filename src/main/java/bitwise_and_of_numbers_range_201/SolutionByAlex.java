package bitwise_and_of_numbers_range_201;


public class SolutionByAlex {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(600000000
                ,2147483645));
    }

    /**
        前提：
            与操作：有0则0，全1则1
            进制转换使用Integer的内置函数
                二进制：Integer.toBinaryString(n)
                八进制：Integer.toOctalString(n)
                十六进制：Integer.toHexString(n)
                三进制：Integer.toString(n, 3)
            二进制字符串转十进制
                String keys = Integer.parseInt(key, 2);

        解题思路：
            1.确定[m,n]之间的所有数
            2.将每个数字从十进制转换为二进制
            3.按照最大数的位数，为位数不够的数补零 尝试失败
            4.遍历每一个数字的每一位，根据与运算规则得出结果
            5.不用计算最大的值，只需要根据最小的数字来运算，高位为0，则最后结果也是0 尝试失败
            6.按照最大值去计算会堆空间不足 尝试失败
            7.按照最小值去计算当m与n都非常大的时候，会运行时间超时 尝试失败
            8.当最小值同位数的最小值小于n的一半时，结果为0
            9. eg 111与1000（100 *2）
       */

    public static int rangeBitwiseAnd(int m, int n) {
        if(m ==0 ){
            //如果有0，则直接返回
            return 0;
        }
        //初始化数组存放数据,确定[m,n]之间的所有数
        //超出这个位数，直接截取
        int minNum = Integer.toBinaryString(m).length();
        //判断是否需要运算，当与最小值同位数的最小值的两倍都还在数组中时，不用计算
        int minValue = Integer.parseInt(fixLastZero(minNum),2);
        if(minValue < Integer.MAX_VALUE/2 &&  minValue*2 < n){
            return 0;
        }
        char[] resultChars  = new char[minNum];
        for(int k=0;k<minNum;k++){
            resultChars[k] = '1';
        }
        for(int i=m,j=0;i<=n && i<Integer.MAX_VALUE;i++,j++){
            //将每个数字转换成二进制，按照最小值的位数截取
            String temp = Integer.toBinaryString(m+j);
            char[] tempChars = temp.substring(temp.length() - minNum).toCharArray();
            for(int o=0;o< tempChars.length;o++){
                if(tempChars[o] == '0'){
                    resultChars[o] ='0';
                }
            }
            tempChars = null;
            if(isAllZero(resultChars)){
                break;
            }
        }
        return  Integer.parseInt(new String(resultChars),2);
    }

    public static boolean isAllZero(char[] chars){
        for(char c:chars){
            if(c =='1'){
                return false;
            }
        }
        return true;
    }

    public static String fixLastZero(int n){
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for(int i=1;i<n;i++){
            sb.append("0");
        }
        return sb.toString();
    }

}
