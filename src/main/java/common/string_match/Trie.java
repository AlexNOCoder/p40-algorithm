package common.string_match;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 字典树
 * @date 2022-03-02 22:11:43
 */
public class Trie {
    private class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
        }
    }
    // 存储无意义字符
    private TrieNode root = new TrieNode('/');

    // 往Trie树种插入一个字符串
    public void insert(char[] text){
        TrieNode p = root;
        for(int i=0;i<text.length;i++){
            int index = text[i] - 97;
            if(p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在Trie数中查找一个字符串
    public boolean find(char[] pattern){
        TrieNode p = root;
        for(int i=0;i< pattern.length;i++){
            int index = pattern[i] - 97;
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("world".toCharArray());
        trie.insert("java".toCharArray());
        trie.insert("how".toCharArray());
        trie.insert("see".toCharArray());
        trie.insert("you".toCharArray());
        System.out.println(trie.find("how".toCharArray()));
    }
}
