package longest_palindromic_substring_5;


public class SolutionByAlex {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
    }

    public static String longestPalindrome(String s) {
            if(s.length()<2){
                return s;
            }
            char[] inputChars = s.toCharArray();
            int longestLength = 0;
            String longestStr ="";
            //遍历查找最长回文串
            for(int index=0;index<inputChars.length;index++){
                //只要没有到达边界就一直搜索
                //用两个参数去记录两种搜索方式，不然会造成干扰：eg：aaabaaaa
                int i=1,j=1;
                //搜索条件达成
                //1.index-1 与index+1字符相同，index-2 与index +2 字符相同
                while(index-i>=0 && index+i <inputChars.length){
                    if(inputChars[index-i] == inputChars[index+i]){
                        String tempPalindrome  = s.substring(index-i,index+i+1);
                        if(tempPalindrome.length()>longestLength){
                            longestStr = tempPalindrome;
                            longestLength = tempPalindrome.length();
                        }
                        i++;
                    }else {
                        break;
                    }
                }
                //2.index 与index+1 字符相同，index-1 与index +2 字符相同
                while(index-j+1 >=0 && index+j <inputChars.length){
                    if(inputChars[index-j+1] == inputChars[index+j]){
                        String tempPalindrome  = s.substring(index-j+1,index+j+1);
                        if(tempPalindrome.length()>longestLength){
                            longestStr = tempPalindrome;
                            longestLength = tempPalindrome.length();
                        }
                        j++;
                    }else {
                        break;
                    }
                }
            }
            if(longestLength == 0){
                return s.substring(0,1);
            }
            return longestStr;
        }
    }
