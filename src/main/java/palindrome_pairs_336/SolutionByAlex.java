package palindrome_pairs_336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionByAlex {
    public List<List<Integer>> palindromePairs(String[] words) {
        // 用来记录找到的配对
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
        // 创建trie
        for(int i=0;i<words.length;i++){
            addWord(root,words[i],i);
        }
        // 利用Tire,找出所有配对
        for(int i=0;i<words.length;i++){
            search(words,i,root,res);
        }

        return res;
    }

    void addWord(TrieNode root,String word,int index){
        // 从每个字符串的末尾开始遍历
        for(int i=word.length()-1;i>=0;i--){
            char ch = word.charAt(i);
            // 对于每个当前字符，如果还没有被添加到children哈希表中，就创建一个新的节点
            if(!root.children.containsKey(ch)){
                root.children.put(ch,new TrieNode());
            }
            // 难点：如果该字符串从头开始到当前位置能成为回文，则把该字符串的下标添加到这个Trie节点的回文列表中
            // 例如：aaaba 由于从后向前遍历，当遍历到字符b时，发现aaa是回文，于是需要更新b指向的节点，这个节点往下有一个字符能构成回文
            if(isPalindrome(word,0,i)){
                root.palindromes.add(index);
            }
            root = root.children.get(ch);
        }
        // 当对该字符串创建完Trie，将字符串的下标添加到回文列表中，并赋给index，表明这里是字符串的结束
        root.palindromes.add(index);
        root.index = index;
    }


    void search(String[] words,int i,TrieNode root,List<List<Integer>> res){
        // 处理查到时，从头遍历每个字符串，然后尝试从Trie中找到匹配的字符串
        for(int j=0;j<words[i].length();j++){
            // 当第二种情况k1>k2，并且s1剩下的字符能构成回文，则把这对组合添加到结果中
            if(root.index >=0 && root.index != i && isPalindrome(words[i],j,words[i].length()-1)){
                res.add(Arrays.asList(i,root.index));
            }
            // 然后不断往下继续查找
            root = root.children.get(words[i].charAt(j));
            if(root == null){
                return;
            }

        }
        // 最后，当遇到第一种情况和第三种情况的时候，只需把回文列表的字符串都与s1组合在一起即可
        for(int j: root.palindromes){
            if(i == j){
                continue;
            }
            res.add(Arrays.asList(i,j));
        }
    }

    boolean isPalindrome(String word,int i,int j){
        while(i<j){
            if(word.charAt(i++) != word.charAt(j--)){
                return false;
            }
        }
        return true;
    }


}

//class TrieNode{
//    // 表示该节点是否为某字符串的结尾
//    boolean isEnd;
//    // 罗列出每个分支中包含的所有字符
//    HashMap<Character,TrieNode> children;
//
//    TrieNode(){
//        isEnd = false;
//        children = new HashMap<>();
//    }
//
//}

class TrieNode{
    // 用index替换isEnd
    int index;
    // 用来记录从该节点往下的字符串，能构成回文的所有输入字符串的下标
    List<Integer> palindromes;
    HashMap<Character,TrieNode> children;
    TrieNode(){
        index = -1;
        children = new HashMap<>();
        palindromes = new ArrayList<>();
    }

}