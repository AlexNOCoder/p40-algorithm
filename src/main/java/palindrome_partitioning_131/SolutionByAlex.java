package palindrome_partitioning_131;

import java.util.*;

public class SolutionByAlex {
    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new LinkedList<>();
        if(len == 0){
            return res;
        }
        //stack 保存回溯路径
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray,0,len,stack,res);

        return res;

    }
    //深度优先遍历找出每一条可能的路径
    public static void dfs(char[] charArray, int index, int len, Deque<String> path,List<List<String>> res){
        //如果到达尾部则将这个结果加入到res中
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        //从index到len区间内判断
        for (int i = index;i < len;i++){
            if(!checkPalindrome(charArray,index,i)){
                continue;
            }
            //深度优先遍历递归实现，找出每一种可能并加入到res中
            path.addLast(new String(charArray,index,i+1-index));
            dfs(charArray,i+1,len,path,res);
            path.removeLast();
        }
    }

    //判断是否是回文字符串
    public static boolean checkPalindrome(char[] charArray,int left,int right){
        while(left < right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> partition = partition(input);
        System.out.println(partition.toString());

        char[] charArray = input.toCharArray();
        System.out.println(checkPalindrome(charArray,1,2));
    }
}
